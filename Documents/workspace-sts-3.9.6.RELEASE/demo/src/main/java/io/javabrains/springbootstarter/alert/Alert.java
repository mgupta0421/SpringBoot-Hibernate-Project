package io.javabrains.springbootstarter.alert;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alert {
	
	@Id
	private int alert;
	private String priority;
	private String vin;
	private Date date;
	private String errMsg;
	public int getAlert() {
		return alert;
	}
	public void setAlert(int alert) {
		this.alert = alert;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
