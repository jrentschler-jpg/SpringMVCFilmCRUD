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
<body style="background-color:LightGray;">
<h1>Add New Film
<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-camera-reels-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M0 8a2 2 0 0 1 2-2h7.5a2 2 0 0 1 1.983 1.738l3.11-1.382A1 1 0 0 1 16 7.269v7.462a1 1 0 0 1-1.406.913l-3.111-1.382A2 2 0 0 1 9.5 16H2a2 2 0 0 1-2-2V8z"/>
  <circle cx="3" cy="3" r="3"/>
  <circle cx="9" cy="3" r="3"/>
</svg>
</h1>
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
	 <form:select path="rating">
				<option value="G">G</option>
				<option value="PG">PG</option>
				<option value="PG-13">PG-13</option>
				<option value="R">R</option>
				<option value="NC-17">NC-17</option>
							</form:select>
				
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