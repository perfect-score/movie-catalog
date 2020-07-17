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
 * A domain class representing a director record stored in the database.
 *
 * @author Chris Reason
 * @version 1.0
 */
@Data
@Entity
@Table(name = "directors")
@SequenceGenerator(name = "directors_seq_id", sequenceName = "directors_seq", allocationSize = 1)
public class Director implements Serializable {

   private static final long serialVersionUID = 1631017193370001L;

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(generator = "directors_seq_id", strategy = GenerationType.SEQUENCE)
   private Integer id;

   @Column(name = "name", length = 100, nullable = false)
   private String name = "";

}
