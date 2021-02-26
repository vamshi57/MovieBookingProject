package com.vamshi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"movie_name"}))
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieId;
	
	@NonNull
	@Column(name="movie_name")
	private String movieName;
	@NonNull
	private String movieGenre;
	@NonNull
	private LocalDate releaseDate;
	@NonNull
	private String producer;
	@NonNull
	private String director;
}
