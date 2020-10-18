
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
</head>
<body>

	<h2>Which field would you like to edit for this film?</h2>
	<br>

<form:form action="editFilm.do" method="POST" modelAttribute="film">
			ID:<form:input path="id" value="${film.id }" readonly="true" />
			<br>
			Title:<form:input path="title" value="${film.title }" />
			<br>
			Description:<form:input path="decsription"
				value="${film.decsription }" />
			<br> 
			Release Year:<form:input path="releaseYear"
				value="${film.releaseYear }" />
			<form:errors path="releaseYear" />
			<br>
			Rental Duration:<form:input path="rentalDuration"
				value="${film.rentalDuration }" />
			<br> 
			Rental Rate:<form:input path="rentalRate"
				value="${film.rentalRate }" />
			<br>
			Length:<form:input path="filmLength" value="${film.filmLength }" />
			<br>
			Replacement Cost:<form:input path="replacementCost"
				value="${film.replacementCost }" />
			<br>
			Language:   <form:select path="languageId">
				<option value="1">English</option>
				<option value="2">Italian</option>
				<option value="3">Japanese</option>
				<option value="4">Mandarin</option>
				<option value="5">French</option>
				<option value="6">German</option>
			</form:select>
			<br>
			Rating:     <form:select path="rating">
				<option value="G">G</option>
				<option value="PG">PG</option>
				<option value="PG13">PG-13</option>
				<option value="R">R</option>
				<option value="NC17">NC-17</option>
			</form:select>
			<br>
			Categories:  <form:select path="category">
				<option value="1">Action</option>
				<option value="2">Animation</option>
				<option value="3">Children</option>
				<option value="4">Classics</option>
				<option value="5">Comedy</option>
				<option value="6">Documentary</option>
				<option value="7">Drama</option>
				<option value="8">Family</option>
				<option value="9">Foreign</option>
				<option value="10">Games</option>
				<option value="11">Horror</option>
				<option value="12">Music</option>
				<option value="13">New</option>
				<option value="14">Sci-Fi</option>
				<option value="15">Sports</option>
				<option value="16">Travel</option>
			</form:select>
			<br>
			Special Features:<br>
			<form:checkbox path="specialFeatures" value="Trailers" />Trailers<br>
			<form:checkbox path="specialFeatures" value="Commentaries" />Commentary<br>
			<form:checkbox path="specialFeatures" value="Behind the Scenes" />Behind the Scenes<br>
			<form:checkbox path="specialFeatures" value="Deleted Scenes" />Deleted Scenes<br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<!-- <input type="submit"> -->
		</form:form>


</body>
</html>