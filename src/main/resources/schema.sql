DROP SCHEMA IF EXISTS reservation CASCADE ;
CREATE SCHEMA reservation;

DROP TABLE IF EXISTS reservation.requests CASCADE ;
CREATE TABLE reservation.requests (
  id  UUID PRIMARY KEY,
  remarks VARCHAR(100) NOT NULL,
--   description TEXT NOT NULL,
--   date DATE NOT NULL,
--   time TIME NOT NULL,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE reservation.requests IS 'tour reservation request';

