<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employees</title>
</head>
<body>
	<table>
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Employee Salary</th>
			<th>Address Id</th>
			<th>Street</th>
			<th>City</th>
			<th>Pin</th>
			<th>Update?</th>
			<th>Delete?</th>
		</tr>
		<c:forEach var="emp" items="${ requestScope.employees }">
			<c:url var="deleteUrl" value="page_to_be_called">
				<c:param name="employeeId" value="${ emp.employeeId }"/>
			</c:url>
			<c:url var="updateUrl" value="page_to_be_called">
				<c:param name="employeeId" value="${ emp.employeeId }"/>
				<c:param name="employeeName" value="${ emp.employeeName }"/>
				<c:param name="employeeSalary" value="${ emp.employeeSalary }"/>
				<c:param name="addressId" value="${ emp.address.addressId }"/>
				<c:param name="street" value="${ emp.address.street }"/>
				<c:param name="city" value="${ emp.address.city }"/>
				<c:param name="pin" value="${ emp.address.pin }"/>
			</c:url>
			<tr>
				<td><c:out value="${ emp.employeeId }"/></td>
				<td><c:out value="${ emp.employeeName }"/></td>
				<td><c:out value="${ emp.employeeSalary }"/></td>
				<td><c:out value="${ emp.address.addressId }"/></td>
				<td><c:out value="${ emp.address.street }"/></td>
				<td><c:out value="${ emp.address.city }"/></td>
				<td><c:out value="${ emp.address.pin }"/></td>
				<td><a href='<c:out value="${ updateUrl }" />'>Update</a></td>
				<td><a href='<c:out value="${ deleteUrl }"/>'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>