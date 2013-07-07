CREATE SCHEMA sample_data_db;

CREATE TABLE items (
  id INTEGER NOT NULL IDENTITY,
  name VARCHAR(100),
  category VARCHAR(50),
  price DOUBLE
)

/* MySQL Syntax:

CREATE TABLE items (
  id INTEGER NOT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  category VARCHAR(50),
  price DOUBLE
)
*/