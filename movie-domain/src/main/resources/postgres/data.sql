-- Directors Sample 

DELETE FROM directors;
INSERT INTO directors (id, name) VALUES
(nextval('directors_seq'), 'Stanley Kubrick'),
(nextval('directors_seq'), 'Martin Scorsese'),
(nextval('directors_seq'), 'Quentin Tarantino'),
(nextval('directors_seq'), 'Francis Ford Coppola'),
(nextval('directors_seq'), 'Sergio Leone'),
(nextval('directors_seq'), 'Ridley Scott'),
(nextval('directors_seq'), 'Michael Bay');

-- Movie Ratings

DELETE FROM movie_ratings;
INSERT INTO movie_ratings (id, description) VALUES
(5, 'Outstanding'),
(4, 'Good'),
(3, 'Average'),
(2, 'Poor'),
(1, 'Diabolical'),
(0, 'Not rated');

-- Movies Sample

DELETE FROM movies;
INSERT INTO movies (id, name, description, director_id, movie_rating_id) VALUES
(nextval('movies_seq'), 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.', '4', '5');

INSERT INTO movies (id, name, description, director_id, movie_rating_id) VALUES
(nextval('movies_seq'), 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', '3', '5');

INSERT INTO movies (id, name, description, director_id, movie_rating_id) VALUES
(nextval('movies_seq'), 'The Good, the Bad and the Ugly', 'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.', '5', '5');

INSERT INTO movies (id, name, description, director_id, movie_rating_id) VALUES
(nextval('movies_seq'), 'Pearl Harbor', 'A tale of war and romance mixed in with history. The story follows two lifelong friends and a beautiful nurse who are caught up in the horror of an infamous Sunday morning in 1941.', '7', '3');
