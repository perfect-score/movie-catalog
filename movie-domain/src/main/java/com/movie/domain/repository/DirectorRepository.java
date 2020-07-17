package com.movie.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.domain.model.Director;

/**
 * Repository to support access to the director database table.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 */
@Repository
public interface DirectorRepository extends CrudRepository<Director, Integer> {
}
