<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h1>Update Employee</h1>
<form:form method="post" action="<c:url value='/employees/update/${employee.id}'/>">
    <label for="name">Name:</label>
    <modelAttribute>employee</modelAttribute>
    <form:input path="name" id="name" /><br>
    <label for="dob">DOB:</label>
    <form:input path="dob" id="dob" type="date" /><br>
    <label for="gender">Gender:</label>
    <form:select path="gender" id="gender">
        <form:option value="MALE">Male</form:option>
        <form:option value="FEMALE">Female</form:option>
        <form:option value="OTHERS">Others</form:option>
    </form:select><br>
    <label for="mobile">Mobile:</label>
    <form:input path="mobile" id="mobile" /><br>
    <input type="submit" value="Update">
</form:form>
<br>
<a href="<c:url value='/employees/list'/>">Back to List</a>
</body>
</html>
