package com.cdac.dao;

import java.util.List;

import com.cdac.model.Employee;

public interface EmployeeDao {
	public int createEmployee(Employee employee);
	public Employee readEmployeeById(int employeeId);
	public List<Employee> readAllEmployee();
	public int updateEmployee(Employee employee);
	public int deleteEmployee(int employeeId);
	public List<Employee> findEmployeesWithAddress();
	public List<Integer> employeeId();
}
