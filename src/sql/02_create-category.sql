-- Table: everwas.category

-- DROP TABLE everwas.category;

CREATE TABLE everwas.category
(
  id serial NOT NULL,
  parent_id bigint,
  name text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE everwas.category ADD PRIMARY KEY ("id");
ALTER TABLE everwas.category OWNER TO everwas;
