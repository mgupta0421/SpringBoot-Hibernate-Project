package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Alert;


@Component
public interface AlertJpaRepo extends JpaRepository<Alert, String> {

	List<Alert> findByPriority(String string);

	List<Alert> findByVin(String string);

}