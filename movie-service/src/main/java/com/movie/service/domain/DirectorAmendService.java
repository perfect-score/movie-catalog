package com.movie.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.domain.model.Director;
import com.movie.domain.repository.DirectorRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Provide a service for amending directors.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Service
@Slf4j
public class DirectorAmendService implements AmendService<Director> {

   private final DirectorRepository repository;
   
   @Autowired
   public DirectorAmendService(DirectorRepository repository) {
      this.repository = repository;
   }

   /**
    * Save the provided director object.
    * 
    * @param Director The director object to save.
    */
   public void save(Director entity) {
      try {
         Director savedEntity = repository.save(entity);

         if (log.isDebugEnabled()) {
            log.debug("Director saved [{}]", savedEntity.toString());
         }
      } catch (RuntimeException e) {
         log.error("Director save error {}", e);
         throw (e);
      }
   }

   /**
    * Handle the director create operation using the provided details. This method provides a facade
    * to the main save method thus providing some level of abstraction.
    * 
    * @param name Name of the director.
    * @throws RuntimeException Error raised by the creation.
    */
   public void create(String name) throws RuntimeException {
      Director entity = new Director();
      entity.setName(name);
      save(entity);
   }

   /**
    * Handle the director update operation using the provided details. This method provides a facade
    * to the main save method thus providing some level of abstraction.
    * 
    * @param id Identifier of the director to update.
    * @param name Name of the director.
    */
   public void update(int id, String name) throws RuntimeException {
      Director entity = new Director();
      entity.setId(id);
      entity.setName(name);
      save(entity);
   }
   
   /**
    * Handle the director delete operation using the provided id.
    * 
    * @param id Identifier to delete.
    */
   public void delete(int id) {
      try {
         repository.deleteById(id);

         if (log.isDebugEnabled()) {
            log.debug("Director deleted [{}]", id);
         }
      } catch (RuntimeException e) {
         log.error("Director delete error {}", e);
         throw (e);
      }
   }

}
