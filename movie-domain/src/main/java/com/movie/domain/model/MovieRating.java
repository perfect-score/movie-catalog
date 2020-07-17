package com.movie.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * A domain class representing a movie rating record stored in the database.
 *
 * @author Chris Reason
 * @version 1.0
 */
@Data
@Entity
@Table(name = "movie_ratings")
public class MovieRating implements Serializable {
   private static final long serialVersionUID = 1631018245320002L;

   @Id
   @Column(name = "id", nullable = false)
   private Integer id;

   @Column(name = "description", length = 100, nullable = false)
   private String description = "";

}
