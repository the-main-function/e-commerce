<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Admin :: Add Category</title>
	</head>

	<body>
		<h2>ADD CATEGORY</h2>
		
		<form:form method="POST" action="/admin/add-category" modelAttribute="category" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Category</td>
					<td><form:input path="name" type="text"/></td>
					
				</tr>
				<tr>
					<td>Add image category(for display purpose)</td>
					<td><form:input path="image" type="file"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="submit"></td>
				</tr>
			</table>
			
			<form:errors path="name" cssClass="error" cssStyle="color:#ff0000;"/>
			<form:errors path="image" cssClass="error" cssStyle="color:#ff0000;"/>
			
		</form:form>
				
	</body>
	
</html>