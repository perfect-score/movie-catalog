package com.movie.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.domain.model.MovieDetail;
import com.movie.domain.repository.MovieDetailRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Provide a service for loading the movie collections.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class MovieSearchService {

   private final MovieDetailRepository repository;
   
   @Autowired
   public MovieSearchService(MovieDetailRepository repository) {
      this.repository = repository;
   }

   /**
    * Search movies using director name.
    * 
    * @param directorName Name of the director.
    * @return Collection of movies matched on director.
    */
   public List<MovieDetail> searchByDirectorName(String directorName) {

      List<MovieDetail> list = repository.findByDirectorName(directorName);

      if (log.isDebugEnabled()) {
         for (MovieDetail l : list) {
            log.debug("MovieDetail collection director search [{}]", l.toString());
         }
      }

      return list;
   }

   /**
    * Search movies using movie rating.
    * 
    * @param movieRating Rating of the movie.
    * @return Collection of movies matched on movie rating.
    */
   public List<MovieDetail> searchByMovieRating(int movieRating) {

      List<MovieDetail> list = repository.findByMovieRatingGreaterThan(movieRating);

      if (log.isDebugEnabled()) {
         for (MovieDetail l : list) {
            log.debug("MovieDetail collection rating search [{}]", l.toString());
         }
      }

      return list;
   }
}
