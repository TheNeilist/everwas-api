-- Table: everwas.time_point

-- DROP TABLE everwas.time_point;

CREATE TABLE everwas.time_point
(
  id serial NOT NULL,
  category_id bigint NOT NULL,
  time_point timestamp NOT NULL,
  name text NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE everwas.time_point ADD PRIMARY KEY ("id");
ALTER TABLE everwas.time_point OWNER TO everwas;
