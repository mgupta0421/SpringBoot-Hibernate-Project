package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleJpaRepo;


@RestController
public class VechileController {

	@Autowired
	private VehicleJpaRepo vehicleJpaRepo;


	 
	// This method used to to read the complete data
	@PostMapping("/data")
	public void addTopic(@RequestBody Vehicle vehicle) {
		
		List<Vehicle> vehicle1= new  ArrayList<>(Arrays.asList(vehicle));
		vehicleJpaRepo.save(vehicle1);
	}
	


	// Method to fetch details of all the vehicles like VIN, make, model, year etc
	@CrossOrigin
	@GetMapping(value = "/allvehicles")
	public List<Vehicle> getVehicles() {

		List<Vehicle> v = vehicleJpaRepo.findAll();
		return v;

	}
	// Method to fetch the details of the 10 users
	@CrossOrigin
	@GetMapping(value = "/tenvehicles")
	public List<Vehicle> getTenVehicles(){
		List<Vehicle> vehicle= new ArrayList();

		
		List<Vehicle> v = vehicleJpaRepo.findAll();
		for(int i = 0; i<11; i++) {
			vehicle.add(v.get(i));
			
		}
		return vehicle;
	}
	//Method returns the value by vin
	@CrossOrigin
	@GetMapping(value = "/{vin}")
	public Vehicle findByName(@PathVariable String vin){
		
		return vehicleJpaRepo.findOne(vin);
				
		
	}
	// Method to count the vehicle
	//@CrossOrigin
	@GetMapping(value = "/count")
	public int countVehicle(){
		List<Vehicle> v = vehicleJpaRepo.findAll();
		int size = v.size();
		return size;
				
		
	}

	//Method to add or update the vehicle data if exists
	
	@PutMapping(value = "/addvehicles/{vin}")
	public void createTopic(@RequestBody Vehicle vehicle) {
		updateTopic(vehicle.getVin(), vehicle);
	}
	
	
	public void updateTopic(String vin,Vehicle vehicle) {
		List<Vehicle> v = vehicleJpaRepo.findAll();
		for(int i = 0; i < v.size(); i++){
			Vehicle required = v.get(i);
			if(required.getVin().equals(vin)) {
				vehicleJpaRepo.save(vehicle);
			}else {
				vehicleJpaRepo.save(vehicle);	
			}
			
			
		}
	}



}