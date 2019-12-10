<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<form:form action="addEmployee.do" modelAttribute="employeeForm" method="post">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><form:input path="employeeId"></form:input></td>
				<td><form:errors path="employeeId"></form:errors></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><form:input  path="employeeName"></form:input></td>
				<td><form:errors  path="employeeName"></form:errors></td>
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><form:input path="employeeSalary" ></form:input></td>
				<td><form:errors path="employeeSalary" ></form:errors></td>
			</tr>
			<tr>
				<td>Address Id</td>
				<td><form:input  path="address.addressId"></form:input></td>
				<td><form:errors  path="address.addressId"></form:errors></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><form:input  path="address.street"></form:input></td>
				<td><form:errors  path="address.street"></form:errors></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input  path="address.city"></form:input></td>
				<td><form:errors  path="address.city"></form:errors></td>
			</tr>
			<tr>
				<td>pin</td>
				<td><form:input  path="address.pin"></form:input></td>
				<td><form:errors  path="address.pin"></form:errors></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="Save Employee Details"></td></tr>
		</table>
	</form:form>
</body>
</html>