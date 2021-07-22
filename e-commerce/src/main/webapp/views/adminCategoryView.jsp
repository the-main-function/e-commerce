<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Admin :: Add Category</title>
	</head>

	<body>
		<h2>ADD CATEGORY</h2>
		<c:set var="categoryId" value="${category.categoryId}"/>
		<c:out value="${categoryId}"/>
		<form:form method="POST" action="/admin/add-category" modelAttribute="category" enctype="multipart/form-data">
			<table>
				<tr>
					<td></td>
					<td><form:input path="categoryId" type="hidden"/></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><form:input path="name" type="text" value="${category.name}"/></td>
				</tr>
				<tr>
					<td><img src="/images/category/${category.imageName}" width="200" height="200"></td>
					<td><form:input path="image" type="file"/>Change image</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
			<form:errors path="name" cssClass="error" cssStyle="color:#ff0000;"/>
			<form:errors path="image" cssClass="error" cssStyle="color:#ff0000;"/>
			
		</form:form>
		
		<form method="POST" action="/admin/delete-category">
			<input type="hidden" value="<c:out value='${categoryId}'/>" name="categoryId"/>
			<input type="submit" value="DELETE"/>	
		</form>		
	</body>
	
</html>