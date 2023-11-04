<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
<h1>Delete Employee</h1>
<p>Are you sure you want to delete this employee?</p>
<a href="<c:url value='/employees/delete/${employee.id}'/>">Yes, Delete</a>
<a href="<c:url value='/employees/list'/>">No, Cancel</a>
</body>
</html>
