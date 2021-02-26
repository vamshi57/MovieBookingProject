package com.vamshi.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor

public class DatesModel {
  
	
	 private LocalDate startDate;
	 private LocalDate endDate;
	 
}
