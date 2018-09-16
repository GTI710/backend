-- DROP TABLES

DROP TABLE IF EXISTS Account CASCADE;

-- CREATE TABLES

CREATE TABLE Account
(
  IdAccount        SERIAL PRIMARY KEY,
  Email       VARCHAR(100),
  Password         VARCHAR(100),
  Username     VARCHAR(50),
  ProfileDescription VARCHAR(250),
  DateCreation    TIMESTAMP,
  DateBirthday    TIMESTAMP,
  ImageProfile VARCHAR(250),
  Gender VARCHAR(50),
  FollowersCount  INTEGER,
  FollowingCount  INTEGER
);


-- CONSTRAINTS

