package com.cdac.utils;

public interface EmployeeQueries {
	String INSERT_EMPLOYEE_RECORD = "insert into employee(employee_id, employee_name, employee_salary, address_id) values(:emp_id, :emp_name, :emp_sal, :address_id)";
	String INSERT_ADDRESS_RECORD = "insert into address(address_id, street, city, pin) values(:address_id, :street, :city, :pin)";
	String GET_EMPLOYEE_BY_ID = "select * from employee where employee_id = :emp_id";
	String GET_ALL_EMPLOYEE = "select * from employee";
	String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id = :emp_id";
	String UPDATE_EMPLOYEE_BY_ID = "update employee set employee_name=:emp_name, employee_salary=:emp_sal where employee_id=:emp_id";
	String GET_EMPLOYEE_WITH_ADDRESS = "select employee_id, employee_name, employee_salary, "
			+ "employee.address_id as address_id, city, street, pin from employee, address "
			+ "where employee.address_id = address.address_id";
	String GET_ALL_EMPLOYEEID = "select employee_id from employee";
}
