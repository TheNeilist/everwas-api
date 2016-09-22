-- Table: everwas.time_period

-- DROP TABLE everwas.time_period;

CREATE TABLE everwas.time_period
(
  id serial NOT NULL,
  category_id bigint NOT NULL,
  period_start timestamp NOT NULL,
  period_end timestamp NOT NULL,
  name text NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE everwas.time_period ADD PRIMARY KEY ("id");
ALTER TABLE everwas.time_period OWNER TO everwas;
