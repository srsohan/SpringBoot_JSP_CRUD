<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Department</title>
</head>
<body>
<h1>Delete Department</h1>
<p>Are you sure you want to delete this department?</p>
<a href="<c:url value='/departments/delete/${department.id}'/>">Yes, Delete</a>
<a href="<c:url value='/departments/list'/>">No, Cancel</a>
</body>
</html>
