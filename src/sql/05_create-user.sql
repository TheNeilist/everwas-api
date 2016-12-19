-- Table: everwas.user

-- DROP TABLE everwas.user;

CREATE TABLE everwas.user
(
  id serial NOT NULL,
  username text,
  password text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE everwas.user ADD PRIMARY KEY ("id");
ALTER TABLE everwas.user OWNER TO everwas;
