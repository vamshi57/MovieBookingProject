package com.vamshi.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.model.DatesModel;
import com.vamshi.model.Movie;
import com.vamshi.repo.MovieRepo;

@RestController
@RequestMapping("movie")
public class MovieController {
	
	
	
   @Autowired
   private MovieRepo repo;
   
   
   
   @PostMapping("/")
   public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
	   Optional<Movie> movie1=repo.findByMovieName(movie.getMovieName());
	   boolean saved=false;
	   try {
		   saved=false;
		   movie1.get();
		   
	   }
	   catch (NoSuchElementException e) {
		   repo.save(movie); 
		   saved=true;
	    }
	   
	  ResponseEntity<?> res=saved?
			  ResponseEntity.ok(movie.getMovieId()):
		      ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	  
	  return res;
	 
   }
   
   @PostMapping("/movie-in-dates")
   public ResponseEntity<?> findMovieByStartAndEnd(@RequestBody DatesModel dates){
	  
	   return ResponseEntity.ok(repo.findByStartDateAndEndDate(dates.getStartDate(), dates.getEndDate()));
	   
   }   
   
   
   
   @GetMapping("/all")
   public ResponseEntity<?> getAll(){
	   return ResponseEntity.ok(repo.findAll());
   }
   
   
   
   @GetMapping("id/{id}")
   public ResponseEntity<?> getById(@PathVariable("id") Long id){
	  Optional<Movie> movieOp= repo.findById(id);
	  boolean found=false;
	  Movie movie=null;
	  try {
		   movie=movieOp.get();
	        found=true;
	  } 
	  catch (NoSuchElementException e) {
	      found=false;
	  }
	  ResponseEntity<?> res=found?ResponseEntity.ok(movie)
			  :ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	   return res;
      }
   
   @GetMapping("name/{name}")
   public ResponseEntity<?> getByName(@PathVariable("name") String name){
	  Optional<Movie> movieOp= repo.findByMovieName(name);
	  boolean found=false;
	  Movie movie=null;
	  try {
		   movie=movieOp.get();
	        found=true;
	  } 
	  catch (NoSuchElementException e) {
	      found=false;
	  }
	  ResponseEntity<?> res=found?ResponseEntity.ok(movie)
			  :ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	   return res;
      }
   
   
   
   @PutMapping("edit/{id}")
   public ResponseEntity<?> editById(@PathVariable("id") Long id,@RequestBody Movie movie){
 	     
 	  boolean edited=false;
	      Optional<Movie> movieOp=repo.findById(id);
		   try {
		    movieOp.get();
		    movie.setMovieId(id);
		    repo.save(movie);
		    edited=true;
		   }
		   catch(NoSuchElementException nsee) {
			   
		   }
		   ResponseEntity<?> res= edited?ResponseEntity.status(HttpStatus.GONE)
	    		.body(null):
	    			ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    		.body(null);
	    		
 	    return res;
   }
   

   
}
