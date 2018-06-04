CREATE TABLE student
(
  id    SERIAL      NOT NULL,
  name  VARCHAR(25),
  phone VARCHAR(25) NOT NULL,
  email VARCHAR(25) NOT NULL,
  age   INTEGER     NOT NULL
);

CREATE UNIQUE INDEX student_phone_uindex
  ON student (phone);

CREATE UNIQUE INDEX student_email_uindex
  ON student (email);
