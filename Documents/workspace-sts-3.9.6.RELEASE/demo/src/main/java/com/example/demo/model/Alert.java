package com.example.demo.model;



	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	@Entity
	public class Alert {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int alert;
		private String priority;
		private String vin;
		private Date date;
		private String errMsg;
		
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
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
		
	}


