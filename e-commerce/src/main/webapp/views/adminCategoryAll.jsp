<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Admin :: All Categories</title>
	</head>

	<body>
	
		<h2>---Categories----</h2>
		<table>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td><input type="hidden" value="${category.categoryId}"></td>
					<td>${category.name}</td>
					<td><img src="/images/category/${category.imageName}" width="200" height="200"></td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/admin/update-categories-option">Make changes</a>		
	</body>
	
</html>