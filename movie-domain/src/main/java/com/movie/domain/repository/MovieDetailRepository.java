package com.movie.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.domain.model.MovieDetail;

/**
 * Repository to support access to the movie detail database table.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 */
@Repository
public interface MovieDetailRepository extends CrudRepository<MovieDetail, Integer> {

   /**
    * Derive a collection from the movie details view based on the provided director name. Cannot
    * sort using this method.
    */
   List<MovieDetail> findByDirectorName(String directorName);

   /**
    * Derive a collection from the movie details view based on the provided movie rating. Cannot
    * sort using this method.
    */
   List<MovieDetail> findByMovieRatingGreaterThan(int movieRating);

}
