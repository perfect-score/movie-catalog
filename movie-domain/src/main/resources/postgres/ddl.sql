-- -------------------------------------------------------------------------------------------------
-- Drop Objects
-- -------------------------------------------------------------------------------------------------

DROP VIEW IF EXISTS v_movie_details;

DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS movie_ratings;
DROP TABLE IF EXISTS directors;

DROP SEQUENCE IF EXISTS directors_seq;
DROP SEQUENCE IF EXISTS movies_seq;

-- -------------------------------------------------------------------------------------------------
-- Create Tables
-- -------------------------------------------------------------------------------------------------

--------------
-- Directors
--------------

CREATE SEQUENCE directors_seq START WITH 1 MAXVALUE 9999999999 INCREMENT BY 1 NO CYCLE;
CREATE TABLE directors
(
  id                             INTEGER      NOT NULL,
  name                           VARCHAR(100) NOT NULL,
  CONSTRAINT directors_pk PRIMARY KEY (id),
  CONSTRAINT directors_uk1_name UNIQUE (name)
);

------------------
-- Movie Ratings
------------------

CREATE TABLE movie_ratings
(
  id                             INTEGER      NOT NULL,
  description                    VARCHAR(100) NOT NULL,
  CONSTRAINT movie_ratings_pk PRIMARY KEY (id)
);

-----------
-- Movies
-----------

CREATE SEQUENCE movies_seq START WITH 1 MAXVALUE 9999999999 INCREMENT BY 1 NO CYCLE;
CREATE TABLE movies
(
  id                             INTEGER      NOT NULL,
  name                           VARCHAR(100) NOT NULL,
  description                    VARCHAR(200) NOT NULL,
  director_id                    INTEGER      NOT NULL,
  movie_rating_id                INTEGER      NOT NULL,
  CONSTRAINT movies_pk PRIMARY KEY (id),
  CONSTRAINT movies_uk1_name UNIQUE (name),
  CONSTRAINT director_fk FOREIGN KEY (director_id)
  REFERENCES directors (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION,
  CONSTRAINT movie_rating_fk FOREIGN KEY (movie_rating_id)
  REFERENCES movie_ratings (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
);

CREATE INDEX movies_director_id_idx     ON movies (director_id);
CREATE INDEX movies_movie_rating_id_idx ON movies (movie_rating_id);

-- -------------------------------------------------------------------------------------------------
-- Create Views
-- -------------------------------------------------------------------------------------------------

----------------------
-- All Movie Details
----------------------

CREATE OR REPLACE VIEW v_movie_details AS
 SELECT m.id AS "id",
        m.name AS "movie_name",
        m.description AS "movie_description",
        m.director_id AS "director_id",
        d.name AS "director_name",
        m.movie_rating_id AS "movie_rating_id",
        r.description AS "movie_rating_description"
   FROM movies m
   JOIN directors d ON d.id = m.director_id
   JOIN movie_ratings r ON r.id = m.movie_rating_id
ORDER BY m.name;
