package com.movie.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * A domain class representing a movie details record stored in the database.
 *
 * @author Chris Reason
 * @version 1.0
 */
@Data
@Entity
@Table(name = "v_movie_details")
public class MovieDetail implements Serializable {
   private static final long serialVersionUID = 1631014280070000L;

   @Id
   @Column(name = "id", nullable = false)
   private Integer id;

   @Column(name = "movie_name", length = 100, nullable = false)
   private String movieName = "";

   @Column(name = "movie_description", length = 200, nullable = false)
   private String movieDescription = "";

   @Column(name = "director_id", nullable = false)
   private Integer directorId = 0;

   @Column(name = "director_name", length = 30, nullable = false)
   private String directorName = "";

   @Column(name = "movie_rating_id", nullable = false)
   private Integer movieRating = 0;

   @Column(name = "movie_rating_description", length = 100, nullable = false)
   private String movieRatingDescription = "";
}

