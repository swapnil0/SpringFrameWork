package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.EmployeeDao;
import com.cdac.model.Employee;
@Service("service")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean addEmployee(Employee employee) {
		int result = getDao().createEmployee(employee);
		if(result == 1) {
			return true;
		}
		return false;
	}
	public Employee findEmployeeById(int employeeId) {
		Employee result = getDao().readEmployeeById(employeeId);
		return result;
	}
	public List<Employee> findAllEmployees() {
		List<Employee> result = getDao().readAllEmployee();
		return result;
	}
	public boolean modifyEmployee(Employee employee) {
		int result = getDao().updateEmployee(employee);
		if(result == 1) {
			return true;
		}
		return false;
	}
	public boolean removeEmployee(int employeeId) {
		int result = getDao().deleteEmployee(employeeId);
		if(result == 1) {
			return true;
		}
		return false;
	}
	public EmployeeDao getDao() {
		return dao;
	}
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	@Override
	public List<Employee> findAllEmployeesWithAddress() {
		return getDao().findEmployeesWithAddress();
	}
	@Override
	public List<Integer> allEmployeeId() {
		// TODO Auto-generated method stub
		return dao.employeeId();
	}
	
	
}
