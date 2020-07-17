package com.movie.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.domain.model.Movie;
import com.movie.domain.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Provide a service for amending movies.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class MovieAmendService implements AmendService<Movie> {

   private final MovieRepository repository;

   @Autowired
   public MovieAmendService(MovieRepository repository) {
      this.repository = repository;
   }

   /**
    * Save the provided movie object.
    * 
    * @param Movie The movie object to save.
    */
   public void save(Movie entity) {
      try {
         Movie savedEntity = repository.save(entity);

         if (log.isDebugEnabled()) {
            log.debug("Movie saved [{}]", savedEntity.toString());
         }
      } catch (RuntimeException e) {
         log.error("Movie save error {}", e);
         throw (e);
      }
   }

   /**
    * Handle the movie create operation using the provided details. This method provides a facade to
    * the main save method thus providing some level of abstraction.
    *
    * @param name Name of the movie
    * @param description Description of the movie.
    * @param directorId Director identifier associated with teh movie.
    * @param movieRatingId Movie rating.
    * @throws RuntimeException Error raised by the creation.
    */
   public void create(String name, String description, int directorId, int movieRatingId)
         throws RuntimeException {
      Movie entity = new Movie();
      entity.setName(name);
      entity.setDescription(description);
      entity.setDirectorId(directorId);
      entity.setMovieRatingId(movieRatingId);
      save(entity);
   }

   /**
    * Handle the movie update operation using the provided details. This method provides a facade to
    * the main save method thus providing some level of abstraction.
    * 
    * @param id Identifier of the movie to update.
    * @param name Name of the movie
    * @param description Description of the movie.
    * @param directorId Director identifier associated with teh movie.
    * @param movieRatingId Movie rating.
    * @param name Name of the director.
    */
   public void update(int id, String name, String description, int directorId, int movieRatingId)
         throws RuntimeException {
      Movie entity = new Movie();
      entity.setId(id);
      entity.setName(name);
      entity.setDescription(description);
      entity.setDirectorId(directorId);
      entity.setMovieRatingId(movieRatingId);
      save(entity);
   }

   /**
    * Handle the director delete operation using the provided id.
    * 
    * @param id Identifier to delete.
    */
   public void delete(int id) {
      try {
         repository.deleteById(id);

         if (log.isDebugEnabled()) {
            log.debug("Movie deleted [{}]", id);
         }
      } catch (RuntimeException e) {
         log.error("Movie delete error {}", e);
         throw (e);
      }
   }

}
