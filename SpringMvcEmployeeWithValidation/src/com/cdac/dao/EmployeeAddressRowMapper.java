package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cdac.model.Address;
import com.cdac.model.Employee;

public class EmployeeAddressRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setAddress(new Address());

		employee.setEmployeeId(rs.getInt("employee_id"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setEmployeeSalary(rs.getDouble("employee_salary"));
		employee.getAddress().setCity(rs.getString("city"));
		employee.getAddress().setStreet(rs.getString("street"));
		employee.getAddress().setPin(rs.getString("pin"));
		return employee;
	}
}
