package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attandance")
public class Attandance {


	@Id
	@GeneratedValue
	@Column(name="AttId")
	private int attandanceId;
	@Column(name="Month")
	private String month;
	@Column(name=" Year")
	private int  year;
	@Column(name=" fullDay")
	private int  fullDay;
	@Column(name=" HalfDay")
	private int  halfDay;
	@OneToOne
	@JoinColumn(name="EmployeeId")
	Employee EmpObj;
	@OneToOne
	@JoinColumn(name="ProjectId")
	Employee ProjObj;
	@Override
	public String toString() {
		return "Attandance [attandanceId=" + attandanceId + ", month=" + month + ", year=" + year + ", fullDay="
				+ fullDay + ", halfDay=" + halfDay + ", EmpObj=" + EmpObj + ", ProjObj=" + ProjObj + "]";
	}
	public int getAttandanceId() {
		return attandanceId;
	}
	public void setAttandanceId(int attandanceId) {
		this.attandanceId = attandanceId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getFullDay() {
		return fullDay;
	}
	public void setFullDay(int fullDay) {
		this.fullDay = fullDay;
	}
	public int getHalfDay() {
		return halfDay;
	}
	public void setHalfDay(int halfDay) {
		this.halfDay = halfDay;
	}
	public Employee getEmpObj() {
		return EmpObj;
	}
	public void setEmpObj(Employee empObj) {
		EmpObj = empObj;
	}
	public Employee getProjObj() {
		return ProjObj;
	}
	public void setProjObj(Employee projObj) {
		ProjObj = projObj;
	}
	
}
