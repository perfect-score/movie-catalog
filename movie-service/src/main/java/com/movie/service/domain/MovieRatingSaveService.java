package com.movie.service.domain;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.domain.repository.MovieRatingRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Provide a service for saving movie ratings.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class MovieRatingSaveService {

   @Autowired
   private MovieRatingRepository repository;

   @Transactional
   public void saveMovieRating(int id, int movieRatingId) {
      try {
         int count = repository.updateMovieRating(id, movieRatingId);
         log.debug("Movie rating saved [id={}] [movieRatingId={}] [updatedCount={}]", id,
               movieRatingId, count);
      } catch (RuntimeException e) {
         log.error("Movie rating save error {}", e);
         throw (e);
      }
   }

}
