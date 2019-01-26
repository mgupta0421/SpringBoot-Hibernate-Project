package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
	
	@Id
	private String vin;
	private String make;
	private String model;
	private int redLineRpm;
	private int year;
	private int makeFuelVolume;
	private String lastServiceDate;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRedLineRpm() {
		return redLineRpm;
	}
	public void setRedLineRpm(int redLineRpm) {
		this.redLineRpm = redLineRpm;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMakeFuelVolume() {
		return makeFuelVolume;
	}
	public void setMakeFuelVolume(int makeFuelVolume) {
		this.makeFuelVolume = makeFuelVolume;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	public int getRedlineRpm() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getMaxFuelVolume() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
