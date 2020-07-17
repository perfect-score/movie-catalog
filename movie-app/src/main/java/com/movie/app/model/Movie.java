package com.movie.app.model;

import lombok.Data;

/**
 * Model object containing the movie message fields.
 */
@Data
public class Movie {

   private int id;
   private String name;
   private String description;
   private int directorId;
   private int movieRatingId;

}
