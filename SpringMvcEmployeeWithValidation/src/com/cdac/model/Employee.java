package com.cdac.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component("employee")
@Scope(scopeName="prototype")
public class Employee {
	@NotNull(message = "please enter Employye id")
	private Integer employeeId;
	private String employeeName;
	private Double employeeSalary;
	
	@Autowired
	@Valid
	private Address address;
	
	public Employee() {
		System.out.println("Employee object created.");
	}
	public Employee(Address address) {
		this.address = address;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", address=" + address + "]";
	}
	
	
}
