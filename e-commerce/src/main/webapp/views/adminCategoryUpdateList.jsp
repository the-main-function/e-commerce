<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Admin :: Update Products</title>
	</head>

	<body>
		
		<form action="view-category-for-update" method="POST">
		
			<select name="categoryId">
				<option selected disabled>--Select a category--</option>
				<c:forEach items="${categoryList}" var="category">
					<option value="${category.categoryId}">${category.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="SUBMIT">
			
		</form>
				
	</body>
	
</html>