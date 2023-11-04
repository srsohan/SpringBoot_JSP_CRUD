<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Department List</title>
</head>
<body>
<h1>Department List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Active</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.active ? 'Yes' : 'No'}</td>
            <td>
                <a href="<c:url value='/departments/update/${department.id}'/>">Edit</a>
                <a href="<c:url value='/departments/delete/${department.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="<c:url value='/departments/create'/>">Create New Department</a>
</body>
</html>
