<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Film</title>
</head>
<body>
<h1>Add New Film</h1>
<form:form action="addNewFilm.do" method="POST" modelAttribute="film">
	<form:label path="title">Film Title:</form:label><br>
	<form:input class="input" path="title" placeholder="Enter the Title:"/>
	<br>
	<form:label path="decsription">Description:</form:label><br>
	<form:input class="input" path="decsription" placeholder="Enter the Description:"/>
	<br>
	<form:label path="releaseYear">Release Year:</form:label><br>
	<form:input class="input" path="releaseYear" placeholder="Enter the Release Year:"/>
	<br>
	<form:label path="languageId">Language:</form:label><br>
		<form:select path="languageId">Language:
	<form:option value="1">English</form:option>
			<form:option value="2">Italian</form:option>
			<form:option value="3">Japanese</form:option>
			<form:option value="4">Mandarin</form:option>
			<form:option value="5">French</form:option>
			<form:option value="6">German</form:option>
		</form:select>

		<br>
	<form:label path="rentalDuration">Rental Duration:</form:label><br>
	<form:input class="input" path="rentalDuration" placeholder="Enter the Rental Duration:"/>
	<br>
	<form:label path="filmLength">Film Length:</form:label><br>
	<form:input class="input" path="filmLength" placeholder="Enter the Film Length:"/>
	<br>
	<form:label path="replacementCost">Replacement Cost:</form:label><br>
	<form:input class="input" path="replacementCost" placeholder="Enter the Replacement Cost:"/>
	<br>
	<form:label path="rating">Rating:</form:label><br>
	<form:input class="input" path="rating" placeholder="Enter the Rating:"/>
	<br>
	
	<input class="submit" type="submit" value="Submit"/>
</form:form>
<form action="addNewFilm.do" method="POST">
</form>
	 



	<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>
</body>
</html>