package com.vamshi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vamshi.model.CinemaHall;
import com.vamshi.model.Screen;
import com.vamshi.repo.CinemaHallRepo;

//@Component
public class runner implements CommandLineRunner {
  @Autowired
  private CinemaHallRepo cineRepo;
	 
	@Override
	public void run(String... args) throws Exception {
		/*
		 * CinemaHall hall=new CinemaHall("vamsi", "hyderabad", "india");
		 * hall.setChId(101l); Screen screen =new Screen(10,
		 * LocalDate.of(2020,Month.MAY, 11),
		 * 
		 * LocalTime.of(4, 0),5 , "ha"); screen.setScreenId(10l);
		 * 
		 * Set<Screen> screens=new HashSet<Screen>(); screens.add(screen);
		 * hall.setScreens(screens);
		 * 
		 * cineRepo.save(hall);
		 */
		//cineRepo.findAll().stream().forEach(p->System.out.println(p));
		
		
	}

}
