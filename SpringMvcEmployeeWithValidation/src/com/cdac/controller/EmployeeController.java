package com.cdac.controller;


import java.util.List;

import javax.validation.Valid;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.model.Employee;
import com.cdac.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private EmployeeService service;
	
//	@ModelAttribute
//	public Employee getEmployee() {
//		return ctx.getBean(Employee.class);
//	}
//	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String homePage() {
		System.out.println(service.allEmployeeId());
		return "index";
	}
	@RequestMapping(path="addEmployee.view", method=RequestMethod.GET)
	public String addEmployeePage(Model model) {
		
		model.addAttribute("employeeForm", ctx.getBean(Employee.class));
		return "addEmployee";
	}
	
	@RequestMapping(path="addEmployee.do", method=RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("employeeForm") Employee employee,BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				return "addEmployee";
			}
		  boolean result = service.addEmployee(employee); 
		  if(result) { 
			  return "redirect:viewEmployee.do"; 
		  }
		  else{ 
			  return "error"; 
		  }
		 
	}
	@RequestMapping(path="viewEmployee.do", method=RequestMethod.GET)
	public String viewAllEmployees(Model model) {
		//List<Employee> employees = service.findAllEmployees();
		List<Employee> employees = service.findAllEmployeesWithAddress();
		model.addAttribute("employees", employees);
		return "viewEmployees";
	}
	
	@RequestMapping(path = "eid.do")
	public String employeeId(Model model) {
		model.addAttribute("employeeids", service.allEmployeeId());
		return "employee";
	}
	
	 @ExceptionHandler(Exception.class) public String handleException() { return
			 "error"; }
}











