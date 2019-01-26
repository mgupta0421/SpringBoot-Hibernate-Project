package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Vehicle;



@Component
public interface VehicleJpaRepo extends JpaRepository<Vehicle, String> {

}