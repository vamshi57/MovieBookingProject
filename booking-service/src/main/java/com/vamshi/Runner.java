package com.vamshi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.model.Booking;
import com.vamshi.repository.BookingRepo;

//@Component
public class Runner implements CommandLineRunner {
   
	@Autowired
	private BookingRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Booking bk=new Booking();
		bk.setBookingDate(new Date());
		bk.setContactNumber(7013116012l);
		bk.setEmailId("vamshikrishna");
		bk.setPersonName("vamshi");
		bk.setChName("bakjfkj");
		bk.setMoiveName("acharya");
		
     repo.save(bk);
	}

}
