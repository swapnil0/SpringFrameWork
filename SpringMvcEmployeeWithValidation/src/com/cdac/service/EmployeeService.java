package com.cdac.service;

import java.util.List;

import com.cdac.model.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee employee);
	public Employee findEmployeeById(int employeeId);
	public List<Employee> findAllEmployees();
	public boolean modifyEmployee(Employee employee);
	public boolean removeEmployee(int employeeId);
	public List<Employee> findAllEmployeesWithAddress();
	public List<Integer> allEmployeeId();
}
