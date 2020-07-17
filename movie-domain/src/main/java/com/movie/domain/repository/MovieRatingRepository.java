package com.movie.domain.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.domain.model.MovieRating;

/**
 * Repository to support access to the movie rating database table.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 */
@Repository
public interface MovieRatingRepository extends CrudRepository<MovieRating, Integer> {

   /**
    * Update the movie rating.
    */
   @Modifying
   @Query("UPDATE Movie m SET m.movieRatingId = ?2 WHERE m.id = ?1 AND m.movieRatingId != ?2")
   int updateMovieRating(Integer id, Integer movieRatingId);
}
