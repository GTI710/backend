-- DROP TABLES

DROP TABLE IF EXISTS CommentTable CASCADE;
DROP TABLE IF EXISTS RatingTable CASCADE;
DROP TABLE IF EXISTS DeliveryTable CASCADE;
DROP TABLE IF EXISTS SaleTable CASCADE;

-- CREATE TABLES

CREATE TABLE SaleTable
(
  IdSaleTable        SERIAL PRIMARY KEY,
  SalesNumber       VARCHAR(250),
  Amount         NUMERIC,
  NameClient     VARCHAR(250),
  Currency VARCHAR(250),
  DateCreation    TIMESTAMP
);

CREATE TABLE DeliveryTable
(
  IdDeliveryTable        SERIAL PRIMARY KEY,
  IdSaleTable       INTEGER NOT NULL,
  Street         VARCHAR(250),
  Zipcode     VARCHAR(250),
  City    VARCHAR(250),
  Country   VARCHAR(250),
  DateCreation    TIMESTAMP
);

CREATE TABLE RatingTable
(
  IdRatingTable    SERIAL PRIMARY KEY,
  IdProductTemplate   INTEGER NOT NULL,
  body       NUMERIC,
  DateCreation    TIMESTAMP
);

CREATE TABLE CommentTable
(
  IdCommentTable    SERIAL PRIMARY KEY,
  IdProductTemplate   INTEGER NOT NULL,
  body       VARCHAR(250),
  DateCreation    TIMESTAMP
);


-- CONSTRAINTS

-- KEY TABLE DeliveryTable
ALTER TABLE DeliveryTable
  ADD CONSTRAINT fk_deliverytable_idsaletable FOREIGN KEY (IdSaleTable) REFERENCES SaleTable (IdSaleTable);

-- KEY TABLE RatingTable
ALTER TABLE RatingTable
  ADD CONSTRAINT fk_ratingtable_idproducttemplate FOREIGN KEY (IdProductTemplate) REFERENCES product_template (id);

-- KEY TABLE CommentTable
ALTER TABLE CommentTable
  ADD CONSTRAINT fk_commenttable_idproducttemplate FOREIGN KEY (IdProductTemplate) REFERENCES product_template (id);

