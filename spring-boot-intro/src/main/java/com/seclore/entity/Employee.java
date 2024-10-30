package com.seclore.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "emp")
@XmlRootElement(name = "emp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empno;

	private String name;
	private double salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJoining;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public static class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
	    public LocalDate unmarshal(String v) throws Exception {
	        return LocalDate.parse(v);
	    }

	    public String marshal(LocalDate v) throws Exception {
	        return v.toString();
	    }
	}
	
}
