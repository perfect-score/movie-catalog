package com.movie.service.domain;

/**
 * Defines amend service template, enforcing implementation of required methods.
 * 
 * @author Chris Reason
 * @version 1.0
 *
 * @param <T> Generic save-object type passed in to the service.
 */
public interface AmendService<T> {
   void save(T entity);
}
