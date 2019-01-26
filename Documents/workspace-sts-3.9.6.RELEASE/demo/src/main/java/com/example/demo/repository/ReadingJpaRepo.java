package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Reading;




@Component
public interface ReadingJpaRepo extends JpaRepository<Reading, String>{

}