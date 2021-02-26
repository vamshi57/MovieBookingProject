package com.vamshi;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.model.Movie;
import com.vamshi.repo.MovieRepo;

//@Component
public class runner implements CommandLineRunner {
   @Autowired
    private MovieRepo repo;
   
	@Override
	public void run(String... args) throws Exception {
		
	List<Movie> list=  repo.findByStartDateAndEndDate(LocalDate.of(2020, 01, 01),
			   LocalDate.of(2020, Month.FEBRUARY, 01));
      list.stream().forEach(System.out::println);
      
	 
	}

}
