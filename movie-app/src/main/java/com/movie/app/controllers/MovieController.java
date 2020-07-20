package com.movie.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.model.Movie;
import com.movie.app.model.RestResponse;
import com.movie.service.domain.MovieAmendService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST controller handling movie messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController {

   private final MovieAmendService movieAmendService;

   @Autowired
   public MovieController(MovieAmendService movieAmendService) {
      this.movieAmendService = movieAmendService;
   }

   /**
    * Handle movie create messages.
    * 
    * @param movie Movie details to create.
    * @return Result of the database creation.
    */
   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public RestResponse create(@RequestBody Movie movie) {

      RestResponse restResponse;

      try {
         movieAmendService.create(movie.getName(), movie.getDescription(), movie.getDirectorId(),
               movie.getMovieRatingId());
         restResponse = new RestResponse(true, movie);
         log.info("Movie created [{}]", movie.toString());
      } catch (RuntimeException e) {
         log.error("Movie create error [{}]", movie.toString(), e);
         restResponse = new RestResponse(false, movie);
      }

      return restResponse;
   }

   /**
    * Handle movie update messages.
    * 
    * @param movie Movie details to update.
    * @return Result of the database update.
    */
   @RequestMapping(value = "/update", method = RequestMethod.PUT)
   public RestResponse update(@RequestBody Movie movie) {

      RestResponse restResponse;

      try {
         movieAmendService.update(movie.getId(), movie.getName(), movie.getDescription(),
               movie.getDirectorId(), movie.getMovieRatingId());
         restResponse = new RestResponse(true, movie);
         log.info("Movie update [{}]", movie.toString());
      } catch (RuntimeException e) {
         log.error("Movie update error [{}]", movie.toString(), e);
         restResponse = new RestResponse(false, movie);
      }

      return restResponse;
   }

   /**
    * Handle movie delete messages.
    * 
    * @param movie Movie details to delete.
    * @return Result of the database delete.
    */
   @RequestMapping(value = "/delete/{movieId}", method = RequestMethod.DELETE)
   public RestResponse delete(@PathVariable int movieId) {

      RestResponse restResponse;

      try {
         movieAmendService.delete(movieId);
         restResponse = new RestResponse(true, movieId);
         log.info("Movie ratings delete [movieId={}]", movieId);
      } catch (RuntimeException e) {
         log.error("Movie delete error [movieId={}]", movieId, e);
         restResponse = new RestResponse(false, movieId);
      }

      return restResponse;
   }

}
