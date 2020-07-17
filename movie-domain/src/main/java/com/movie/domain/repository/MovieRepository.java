package com.movie.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.domain.model.Movie;

/**
 * Repository to support access to the movie database table.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
