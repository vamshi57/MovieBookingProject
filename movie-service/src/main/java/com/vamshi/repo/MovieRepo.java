package com.vamshi.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vamshi.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
     
	
	Optional<Movie> findByMovieName(String movieName);
	
	 @Query("SELECT m FROM Movie m WHERE m.releaseDate BETWEEN :startDate AND :endDate") 
	List<Movie> findByStartDateAndEndDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
