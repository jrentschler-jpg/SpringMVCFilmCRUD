<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Film Results</title>
</head>
<br>
<body style="background-color:GREENYELLOW;">
	<c:choose>
		<c:when test="${empty film }">
			<h1>This Film has been successfully deleted!!!</h1>
			
		</c:when>
		
	</c:choose>

<br>


	<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>
</body>