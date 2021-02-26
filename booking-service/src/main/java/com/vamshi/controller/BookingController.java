package com.vamshi.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamshi.model.Booking;
import com.vamshi.repository.BookingRepo;

@RestController
@RequestMapping("booking")
public class BookingController {
	 @Autowired
	 private BookingRepo repo;
	 // get all booking details
      @GetMapping("/all")
      public ResponseEntity<?> getBookingDetails(){
               List<Booking> listBooking=repo.findAll();
    	  return  ResponseEntity.ok(listBooking);  	  
      }
      
      
      //create a booking 
      @PostMapping("/")
      public ResponseEntity<?> saveBookingDetails(@RequestBody Booking booking){
    	  booking.setBookingId(null);
    	  Booking bk=repo.save(booking);
    	  return ResponseEntity.ok(bk.getBookingId());
      }
      
     // get booking details of particular  id
      @GetMapping("id/{id}")
      public ResponseEntity<?> getById(@PathVariable("id") Long bookingId){
    	   Optional<Booking> bk=repo.findById(bookingId);
    	  return ResponseEntity.ok(bk.get());
      }
      // 
      @GetMapping("name/{name}")
      public ResponseEntity<?> getByName(@PathVariable("name") String name){
    	   List<Booking> bk=repo.findByPersonName(name);
    	  return ResponseEntity.ok(bk);
      }
      
      @GetMapping("contact/{contact}")
      public ResponseEntity<?> getByContact(@PathVariable("contact") Long contactNumber){
    	   List<Booking> bk=repo.findByContactNumber(contactNumber);
    	  return ResponseEntity.ok(bk);
      }
      
      
      @GetMapping("email/{email}")
      public ResponseEntity<?> getByEmail(@PathVariable("email") String email){
    	   List<Booking> bk=repo.findByEmailId(email);
    	  return ResponseEntity.ok(bk);
      }
      
      @DeleteMapping("cancel/{id}")
      public ResponseEntity<?> deleteById(@PathVariable("id") Long bookingId){
    	  boolean deleted=false;
    	   Optional<Booking> bk=repo.findById(bookingId);
    	   try {
    	   Booking booking=bk.get();
    	   repo.deleteById(bookingId);
    	   deleted=true;
    	   }
    	   catch(NoSuchElementException nsee) {
    		   
    	   }
    
    	   ResponseEntity<?> res= deleted?ResponseEntity.status(HttpStatus.ACCEPTED)
      	    		.body(null):
      	    			ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
      	    		.body(null);
    	  return res;
      }
     
      @PutMapping("edit/{id}")
      public ResponseEntity<?> editById(@PathVariable("id") Long id,@RequestBody Booking booking){
    	     
    	  boolean edited=false;
	      Optional<Booking> bk=repo.findById(id);
		   try {
		   Booking bookinggot=bk.get();
		   booking.setBookingId(id);
		   repo.save(booking);
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

