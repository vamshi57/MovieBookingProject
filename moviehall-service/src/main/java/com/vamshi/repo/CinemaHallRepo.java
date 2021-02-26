package com.vamshi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.model.CinemaHall;

@Repository
public interface CinemaHallRepo extends JpaRepository<CinemaHall, Long> {

}
