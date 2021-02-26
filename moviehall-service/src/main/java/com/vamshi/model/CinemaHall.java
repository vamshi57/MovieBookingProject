package com.vamshi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CinemaHall {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Ch_Id")
	private Long chId;
    @NonNull
	private String chName;
	@NonNull
    private String chCity;
	@NonNull
	private String chCountry;
	
	@OneToMany(
			targetEntity = Screen.class,
			cascade = CascadeType.ALL,
			fetch =FetchType.EAGER)
   @JoinColumn(referencedColumnName = "Ch_Id")
	
    	
	private Set<Screen> screens;
	

}
