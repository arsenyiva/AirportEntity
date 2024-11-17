CREATE OR REPLACE VIEW bookings.flights_v AS
SELECT
    f.flight_id,
    f.flight_no,
    f.scheduled_departure,
    timezone(dep.timezone, f.scheduled_departure) AS scheduled_departure_local,
    f.scheduled_arrival,
    timezone(arr.timezone, f.scheduled_arrival) AS scheduled_arrival_local,
    (f.scheduled_arrival - f.scheduled_departure) AS scheduled_duration,
    f.departure_airport,
    dep.airport_name AS departure_airport_name,
    dep.city AS departure_city,
    f.arrival_airport,
    arr.airport_name AS arrival_airport_name,
    arr.city AS arrival_city,
    f.status,
    f.aircraft_code,
    f.actual_departure,
    timezone(dep.timezone, f.actual_departure) AS actual_departure_local,
    f.actual_arrival,
    timezone(arr.timezone, f.actual_arrival) AS actual_arrival_local,
    (f.actual_arrival - f.actual_departure) AS actual_duration
FROM flights f
         JOIN airports dep ON f.departure_airport = dep.airport_code
         JOIN airports arr ON f.arrival_airport = arr.airport_code;

CREATE MATERIALIZED VIEW bookings.routes AS
WITH f3 AS (
    SELECT
        f2.flight_no,
        f2.departure_airport,
        f2.arrival_airport,
        f2.aircraft_code,
        f2.duration,
        array_agg(f2.days_of_week) AS days_of_week
    FROM (
             SELECT
                 f1.flight_no,
                 f1.departure_airport,
                 f1.arrival_airport,
                 f1.aircraft_code,
                 f1.duration,
                 f1.days_of_week
             FROM (
                      SELECT
                          flights.flight_no,
                          flights.departure_airport,
                          flights.arrival_airport,
                          flights.aircraft_code,
                          (flights.scheduled_arrival - flights.scheduled_departure) AS duration,
                          (to_char(flights.scheduled_departure, 'ID'))::integer AS days_of_week
                      FROM flights
                  ) f1
             GROUP BY f1.flight_no, f1.departure_airport, f1.arrival_airport, f1.aircraft_code, f1.duration, f1.days_of_week
             ORDER BY f1.flight_no, f1.departure_airport, f1.arrival_airport, f1.aircraft_code, f1.duration, f1.days_of_week
         ) f2
    GROUP BY f2.flight_no, f2.departure_airport, f2.arrival_airport, f2.aircraft_code, f2.duration
)
SELECT
    f3.flight_no,
    f3.departure_airport,
    dep.airport_name AS departure_airport_name,
    dep.city AS departure_city,
    f3.arrival_airport,
    arr.airport_name AS arrival_airport_name,
    arr.city AS arrival_city,
    f3.aircraft_code,
    f3.duration,
    f3.days_of_week
FROM f3
         JOIN airports dep ON f3.departure_airport = dep.airport_code
         JOIN airports arr ON f3.arrival_airport = arr.airport_code
WITH NO DATA;
