package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alert;
import com.example.demo.model.Reading;
import com.example.demo.model.Tires;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.AlertJpaRepo;
import com.example.demo.repository.ReadingJpaRepo;
import com.example.demo.repository.TipeJpaRepo;
import com.example.demo.repository.VehicleJpaRepo;


@RestController
public class VechileController {

	@Autowired
	private VehicleJpaRepo vehicleJpaRepo;
	
	@Autowired
	private ReadingJpaRepo readingJpaRepo;

	@Autowired
	private AlertJpaRepo alertJpaRepo;

	@Autowired
	private TipeJpaRepo tipeJpaRepo;
	
	
	
	
	// Method to load vehicle details in bulk via a PUT /vehicles endpoint.
	// Method will update the record in db, if the vehicle with same VIN is already
	// present.
		@CrossOrigin
		@PutMapping(value = "/vehicles")
		public String setVechiles(@RequestBody List<Vehicle> payload) {

			for (Vehicle vehicle : payload) {
				if (vehicleJpaRepo.existsById(vehicle.getVin())) {
					vehicleJpaRepo.deleteById(vehicle.getVin());
					vehicleJpaRepo.save(vehicle);
					System.out.println("Old Vehicle ID  -->" + vehicle.getVin());

				} else {
					vehicleJpaRepo.save(vehicle);
					System.out.println("New Vehicle ID  -->" + vehicle.getVin());

				}

			}

			return "Vehicle successfully added";

		}

		// Method to ingest readings from these vehicles via a POST /readings
		@CrossOrigin
		@PostMapping(value = "/readings")
		public String setReadings(@RequestBody Reading reading) {

			Optional<Vehicle> v = vehicleJpaRepo.findById(reading.getVin());
			Tires tires = new Tires();
			tires.setFrontLeft(reading.getTires().getFrontLeft());
			tires.setFrontRight(reading.getTires().getFrontRight());
			tires.setRearLeft(reading.getTires().getRearLeft());
			tires.setRearRight(reading.getTires().getRearRight());
			tires.setVin(reading.getVin());
			tipeJpaRepo.save(tires);

			Reading r = new Reading();
			r.setVin(reading.getVin());
			r.setCheckEngineLightOn(reading.getCheckEngineLightOn());
			r.setCruiseControlOn(reading.getCruiseControlOn());
			r.setEngineCoolantLow(reading.getEngineCoolantLow());
			r.setEngineHp(reading.getEngineHp());
			r.setEngineRpm(reading.getEngineRpm());
			r.setFuelVolume(reading.getFuelVolume());
			r.setLatitude(reading.getLatitude());
			r.setLongitude(reading.getLongitude());
			r.setSpeed(reading.getSpeed());
			r.setTimestamp(reading.getTimestamp());
			r.setTires(tires);
			readingJpaRepo.save(r);

			if (reading.getEngineRpm() > v.get().getRedlineRpm()) {
				Alert alert = new Alert();
				alert.setPriority("HIGH");
				alert.setVin(reading.getVin());
				alert.setDate(new Date());
				alertJpaRepo.save(alert);
				System.out.println("High alert generated");
			}

			if (reading.getFuelVolume() < (v.get().getMaxFuelVolume() / 10)) {

				Alert alert = new Alert();
				alert.setPriority("MEDIUM");
				alert.setVin(reading.getVin());
				alert.setDate(new Date());
				alertJpaRepo.save(alert);
				System.out.println("Medium alert generated");
			}

			return "Reading successfully added";
		}



	 
	// This method used to to read the complete data
	@PostMapping("/data")
	public void addTopic(@RequestBody Vehicle vehicle) {
		
		List<Vehicle> vehicle1= new  ArrayList();
//	List<Vehicle> vehicle1= new  ArrayList<>(Arrays.asList(vehicle));
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