package com.movie.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * A domain class representing a movie record stored in the database.
 *
 * @author Chris Reason
 * @version 1.0
 */
@Data
@Entity
@Table(name = "movies")
@SequenceGenerator(name = "movies_seq_id", sequenceName = "movies_seq", allocationSize = 1)
public class Movie implements Serializable {
   private static final long serialVersionUID = 1631019208160003L;

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(generator = "movies_seq_id", strategy = GenerationType.SEQUENCE)
   private Integer id;

   @Column(name = "name", length = 100, nullable = false)
   private String name = "";

   @Column(name = "description", length = 200, nullable = false)
   private String description = "";

   @Column(name = "director_id", nullable = false)
   private Integer directorId = 0;

   @Column(name = "movie_rating_id", nullable = false)
   private Integer movieRatingId = 0;

}
