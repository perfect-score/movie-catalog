package com.movie.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.app.model.Director;
import com.movie.app.model.RestResponse;
import com.movie.service.domain.DirectorAmendService;

import lombok.extern.slf4j.Slf4j;

/**
 * REST controller handling director messages.
 * 
 * @author Chris Reason
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/director")
public class DirectorController {

   private final DirectorAmendService directorAmendService;

   @Autowired
   public DirectorController(DirectorAmendService directorSaveService) {
      this.directorAmendService = directorSaveService;
   }

   /**
    * Handle director create messages.
    * 
    * @param director Director details to create.
    * @return Result of the database creation.
    */
   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public RestResponse create(@RequestBody Director director) {

      RestResponse restResponse;

      try {
         directorAmendService.create(director.getName());
         restResponse = new RestResponse(true, director);
         log.info("Director created [{}]", director.toString());
      } catch (RuntimeException e) {
         log.error("Dirctor create error [{}]", director.toString(), e);
         restResponse = new RestResponse(false, director);
      }

      return restResponse;
   }

   /**
    * Handle director update messages.
    * 
    * @param director Director details to update.
    * @return Result of the database update.
    */
   @RequestMapping(value = "/update", method = RequestMethod.PUT)
   public RestResponse update(@RequestBody Director director) {

      RestResponse restResponse;

      log.info("Director update [{}]", director.toString());

      try {
         directorAmendService.update(director.getId(), director.getName());
         restResponse = new RestResponse(true, director);
         log.info("Director update [{}]", director.toString());
      } catch (RuntimeException e) {
         log.error("Director update error [{}]", director.toString(), e);
         restResponse = new RestResponse(false, director);
      }

      return restResponse;
   }

   /**
    * Handle director delete messages.
    * 
    * @param director Director details to delete.
    * @return Result of the database delete.
    */
   @RequestMapping(value = "/delete/{directorId}", method = RequestMethod.DELETE)
   public RestResponse delete(@PathVariable int directorId) {

      RestResponse restResponse;

      try {
         directorAmendService.delete(directorId);
         restResponse = new RestResponse(true, directorId);
         log.info("Movie ratings delete [directorId={}]", directorId);
      } catch (RuntimeException e) {
         log.error("Dirctor delete error [directorId={}]", directorId, e);
         restResponse = new RestResponse(false, directorId);
      }

      return restResponse;
   }

}
