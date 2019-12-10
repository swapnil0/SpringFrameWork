package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cdac.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("employee_id"));
		employee.setEmployeeName(rs.getString("employee_name"));
		employee.setEmployeeSalary(rs.getDouble("employee_salary"));
		return employee;
	}
}
