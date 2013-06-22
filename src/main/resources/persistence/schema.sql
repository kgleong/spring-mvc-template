CREATE SCHEMA sample_db;

CREATE TABLE items (
  /* IDENTITY auto-increment primary key column */
  id INTEGER IDENTITY,
  name VARCHAR(100),
  category VARCHAR(50),
  /* DECIMAL(precision, scale)
     precision (1-38) = maximum number of digits in the number.
     scale (0-precision) = numbers to the right of the decimal point. */
  price DECIMAL(18,2)
)