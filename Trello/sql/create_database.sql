-- Table: account
-- Postgres database
-- DROP TABLE account;

CREATE TABLE account
(
  id integer NOT NULL,
  username character varying(50) NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  email character varying(50) NOT NULL,
  password character varying(64),
  marketing_ok boolean NOT NULL,
  enabled boolean NOT NULL,
  date_created timestamp without time zone DEFAULT now(),
  date_modified timestamp without time zone DEFAULT now(),
  CONSTRAINT account_pkey PRIMARY KEY (id),
  CONSTRAINT account_username_key UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE account
  OWNER TO postgres;
  
CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE hibernate_sequence
  OWNER TO postgres;