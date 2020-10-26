package com.rc.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@IdClass(UserAndRecipeID.class)
@Table(
uniqueConstraints = {@UniqueConstraint(columnNames = {"userMailAdress", "recipe"})})
public class UserRatingAndComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingAndCommentID;
	
	private String userMailAdress;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(nullable = false, name = "recipe")
	private Recipe recipe;
		
	@NotBlank
	private String userName;
	
	@Positive
	@Max(5)
	@NotNull
	private Integer starVote;
	@NotBlank
	private String comment;

	private Timestamp creationDate = Timestamp.valueOf(LocalDateTime.now());
}
