package com.vamshi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
	
	 List<Booking> findByContactNumber(Long contactNumber);
	 List<Booking> findByBookingId(Long bookingId);
	 List<Booking> findByPersonName(String personName);
	 List<Booking> findByEmailId(String emailId);
	

}
