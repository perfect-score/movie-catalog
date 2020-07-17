package com.movie.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.model.Ratings;
import com.movie.app.model.RestResponse;
import com.movie.service.domain.MovieRatingSaveService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST controller handling movie rating messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/rating")
public class RatingsController {

   private MovieRatingSaveService movieRatingSaveService;

   @Autowired
   public RatingsController(MovieRatingSaveService movieRatingSaveService) {
      this.movieRatingSaveService = movieRatingSaveService;
   }

   /**
    * Handle movie rating create messages.
    * 
    * @param ratings Movie ratings details to create.
    * @return Result of the database creation.
    */
   @RequestMapping(value = "/update", method = RequestMethod.PUT)
   public RestResponse update(@RequestBody Ratings ratings) {

      RestResponse restResponse;

      try {
         movieRatingSaveService.saveMovieRating(ratings.getId(), ratings.getMovieRatingId());
         restResponse = new RestResponse(true, ratings);
         log.info("Movie ratings update [{}]", ratings.toString());
      } catch (RuntimeException e) {
         log.error("Movie rating update error [{}]", ratings.toString(), e);
         restResponse = new RestResponse(false, ratings);
      }

      return restResponse;
   }

   /**
    * Handle movie ratings update messages.
    * 
    * @param movieId Movie identifier to update.
    * @return Result of the database update.
    */
   @RequestMapping(value = "/delete/{movieId}", method = RequestMethod.PUT)
   public RestResponse delete(@PathVariable int movieId) {

      RestResponse restResponse;

      try {
         movieRatingSaveService.saveMovieRating(movieId, 0); // Set the movie rating to zero
         restResponse = new RestResponse(true, movieId);
         log.info("Movie ratings deleted/reset [{}]", movieId);
      } catch (

      RuntimeException e) {
         log.error("Movie ratings error [{}]", movieId, e);
         restResponse = new RestResponse(false, movieId);
      }

      return restResponse;
   }

}
