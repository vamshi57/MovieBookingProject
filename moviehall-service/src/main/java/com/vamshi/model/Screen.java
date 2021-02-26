package com.vamshi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Screen_Id")
	private Long screenId;
	@NonNull
	private Integer sCapacity;
	@NonNull
	private LocalDate sShowDate;
	@NonNull
	private LocalTime sShowTime;
	@NonNull
	private  Integer sBooked;
	@NonNull
	private String movieName;
	
	@ManyToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	
  

	private CinemaHall cinemaHallFk;

   

}
