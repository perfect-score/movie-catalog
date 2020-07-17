package com.movie.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.domain.model.MovieDetail;
import com.movie.service.domain.MovieSearchService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST controller containing facilities for searching by director name, or movie rating.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/search")
public class MovieSearchController {

   private final MovieSearchService movieSearchService;

   @Autowired
   public MovieSearchController(MovieSearchService movieSearchService) {
      this.movieSearchService = movieSearchService;
   }

   /**
    * Search movies using the provided director name.
    * 
    * Example: [URI]:/search/director/Francis Ford Coppola
    * 
    * @param directorName Name of the director to search for.
    * @return JSON list of movies found, otherwise none/blank is returned.
    */
   @GetMapping(value = "/director/{directorName}")
   public List<MovieDetail> searchByDirectorName(@PathVariable String directorName) {

      List<MovieDetail> movies = movieSearchService.searchByDirectorName(directorName);

      if (log.isTraceEnabled()) {
         log.trace("Search by director name [directorName={}]", directorName);

         for (MovieDetail md : movies) {
            log.trace("Movie search by director [{}]", md.toString());
         }
      }

      return movies;
   }

   /**
    * Search movies by movie rating (must be equal or greater than the provided value).
    * 
    * Example: [URI]:/search/rating/3
    * 
    * @param rating Movie ratings to find (inclusive).
    * @return JSON list of movies found, otherwise none/blank is returned.
    */
   @GetMapping(value = "/rating/{rating}")
   public List<MovieDetail> searchByMovieRating(@PathVariable int rating) {

      List<MovieDetail> movies = movieSearchService.searchByMovieRating(rating);

      if (log.isTraceEnabled()) {
         log.trace("Search by movie rating [rating={}]", rating);

         for (MovieDetail md : movies) {
            log.trace("Movie search by rating [{}]", md.toString());
         }
      }

      return movies;
   }
}
