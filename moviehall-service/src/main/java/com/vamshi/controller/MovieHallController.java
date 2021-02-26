package com.vamshi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.model.CinemaHall;
import com.vamshi.model.Screen;
import com.vamshi.repo.CinemaHallRepo;
import com.vamshi.repo.ScreenRepo;

@RestController
@RequestMapping("moviehall")

public class MovieHallController {

	@Autowired
	private CinemaHallRepo chRepo;
	
	@Autowired
	private ScreenRepo scRepo;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		 List<?> all=chRepo.findAll();
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("movie/{movie}")
	public ResponseEntity<?> getScreenByMoiveName(@PathVariable("movie") String movie){
		 List<CinemaHall> listHalls=chRepo.findAll();
		 List<Screen> resultlist=new ArrayList<Screen>();
		 
		listHalls.forEach(p->p.getScreens().stream().forEach(p1->{
		   if(p1.getMovieName().equals(movie)) {
			    resultlist.add(p1);
		   }
		}));
	  return ResponseEntity.ok(resultlist); 	 
	}
	
}
