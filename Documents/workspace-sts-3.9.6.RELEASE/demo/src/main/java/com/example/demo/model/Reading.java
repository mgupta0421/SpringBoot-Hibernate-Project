package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reading {
	
	@Id
	private String  vin;
	private double latitude;
	private double longitude;
	private String timestamp;
	private double fuelVolume;
	private int speed;
	private int engineHp;
	private Boolean checkEngineLightOn;
	private Boolean engineCoolantLow;
	private Boolean cruiseControlOn;
	private int engineRpm;
	
	
	private Tires tires;


	public String getVin() {
		return vin;
	}


	public void setVin(String vin) {
		this.vin = vin;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public double getFuelVolume() {
		return fuelVolume;
	}


	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getEngineHp() {
		return engineHp;
	}


	public void setEngineHp(int engineHp) {
		this.engineHp = engineHp;
	}


	public Boolean getCheckEngineLightOn() {
		return checkEngineLightOn;
	}


	public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}


	public Boolean getEngineCoolantLow() {
		return engineCoolantLow;
	}


	public void setEngineCoolantLow(Boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}


	public Boolean getCruiseControlOn() {
		return cruiseControlOn;
	}


	public void setCruiseControlOn(Boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}


	public int getEngineRpm() {
		return engineRpm;
	}


	public void setEngineRpm(int engineRpm) {
		this.engineRpm = engineRpm;
	}


	public Tires getTires() {
		return tires;
	}


	public void setTires(Tires tires) {
		this.tires = tires;
	}
	
	

}
