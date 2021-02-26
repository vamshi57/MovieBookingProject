package com.vamshi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vamshi.model.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Long> {

}
