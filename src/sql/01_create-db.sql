-- Database: everwas

-- DROP DATABASE everwas;

CREATE DATABASE everwas
  WITH OWNER = everwas
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

CREATE SCHEMA everwas
       AUTHORIZATION everwas;
