DROP SCHEMA IF EXISTS reservation CASCADE ;
CREATE SCHEMA reservation;

CREATE SEQUENCE reservation.request_number;

DROP TABLE IF EXISTS reservation.requests CASCADE ;
CREATE TABLE reservation.requests (
  id  INTEGER PRIMARY KEY,
  remarks VARCHAR(100) NOT NULL,
--   description TEXT NOT NULL,
   date DATE NOT NULL,
  start_time TIME NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE reservation.requests IS 'tour reservation request';

