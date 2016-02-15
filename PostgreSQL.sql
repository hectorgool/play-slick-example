CREATE DATABASE "play-slick-example" WITH ENCODING 'UTF8';
GRANT ALL ON DATABASE "play-slick-example" TO santo;

CREATE SEQUENCE cat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

DROP TABLE cat;
CREATE TABLE cat (
    id smallint NOT NULL DEFAULT nextval('cat_id_seq'),
    name text,
    color text,
    activate BOOLEAN DEFAULT TRUE
);

ALTER TABLE public.cat_id_seq OWNER TO santo;
ALTER TABLE public.cat OWNER TO santo;


CREATE DATABASE "mydb" WITH ENCODING 'UTF8';
GRANT ALL ON DATABASE "mydb" TO santo;

CREATE TABLE dog (
    name text,
    color text
);
ALTER TABLE public.dog OWNER TO santo;