package com.cdac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.model.Address;
import com.cdac.model.Employee;
import com.cdac.utils.EmployeeQueries;

@Repository // ("dao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private NamedParameterJdbcTemplate template;
	@Autowired
	private ApplicationContext ctx;
	public int createEmployee(Employee employee) {
		Map<String, Object> employeeParams = new HashMap<>();
		employeeParams.put("emp_id", employee.getEmployeeId());
		employeeParams.put("emp_name", employee.getEmployeeName());
		employeeParams.put("emp_sal", employee.getEmployeeSalary());
		employeeParams.put("address_id", employee.getAddress().getAddressId());

		Map<String, Object> addressParams = new HashMap<>();
		addressParams.put("address_id", employee.getAddress().getAddressId());
		addressParams.put("street", employee.getAddress().getStreet());
		addressParams.put("city", employee.getAddress().getCity());
		addressParams.put("pin", employee.getAddress().getPin());

		int reuslt = template.update(EmployeeQueries.INSERT_ADDRESS_RECORD, addressParams);
		reuslt = template.update(EmployeeQueries.INSERT_EMPLOYEE_RECORD, employeeParams);
		return reuslt;
	}

	public Employee readEmployeeById(int employeeId) {
		Map<String, Integer> employeeParams = new HashMap<String, Integer>();
		employeeParams.put("emp_id", employeeId);
		return template.queryForObject(EmployeeQueries.GET_EMPLOYEE_BY_ID, employeeParams, new EmployeeRowMapper());
	}
	
		/****
		 * 1. Row mapper class
		 * 2.by lambda expression 
		 * 
		 */
	public List<Employee> readAllEmployee() {
		List<Employee> employees = getTemplate().query(EmployeeQueries.GET_ALL_EMPLOYEE, new RowMapper<Employee>() {
			@Override
			public Employee  mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = ctx.getBean(Employee.class);
				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setEmployeeName(rs.getString("employee_name"));
				employee.setEmployeeSalary(rs.getDouble("employee_salary"));
				return employee;
			}
		});
		return employees;
	}

	public int updateEmployee(Employee employee) {
		Map<String, Object> employeeParams = new HashMap<>();
		employeeParams.put("emp_id", employee.getEmployeeId());
		employeeParams.put("emp_name", employee.getEmployeeName());
		employeeParams.put("emp_sal", employee.getEmployeeSalary());
		return template.update(EmployeeQueries.UPDATE_EMPLOYEE_BY_ID, employeeParams);
	}

	public int deleteEmployee(int employeeId) {
		Map<String, Integer> employeeParams = new HashMap<String, Integer>();
		employeeParams.put("emp_id", employeeId);
		return template.update(EmployeeQueries.DELETE_EMPLOYEE_BY_ID, employeeParams);
	}

	/***
	 * this is using Lambda expression
	 */
	
	@Override
	public List<Employee> findEmployeesWithAddress() {
		List<Employee> list = getTemplate().query(EmployeeQueries.GET_EMPLOYEE_WITH_ADDRESS, (rs,row)->{
			Employee employee = ctx.getBean(Employee.class);
			employee.setAddress(new Address());
			employee.setEmployeeId(rs.getInt("employee_id"));
			employee.setEmployeeName(rs.getString("employee_name"));
			employee.setEmployeeSalary(rs.getDouble("employee_salary"));
			employee.getAddress().setCity(rs.getString("city"));
			employee.getAddress().setStreet(rs.getString("street"));
			employee.getAddress().setPin(rs.getString("pin"));
			return employee;
		});
		return list;
	}

	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Integer> employeeId() {
		
		return template.query(EmployeeQueries.GET_ALL_EMPLOYEEID, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return rs.getInt("employee_id");
			}
		});
	}

}
