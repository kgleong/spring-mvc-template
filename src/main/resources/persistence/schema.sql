CREATE SCHEMA sample_data_db;

CREATE TABLE items (
  id INTEGER NOT NULL IDENTITY,
  name VARCHAR(100),
  category VARCHAR(50),
  price DOUBLE
)