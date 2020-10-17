<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Film</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty film }">
			<h1>Film Created</h1>
			<table>
				<tr>
					<td>Film ID:</td>
					<td>${film.filmId }</td>
				</tr>
				<tr>
					<td>Film Description:</td>
					<td>${film.decsription }</td>

				</tr>
				<tr>
					<td>Release Year:</td>
					<td>${film.releaseYear }</td>

				</tr>
				<tr>
					<td>Language:</td>
					<td>${film.language }</td>
				</tr>
				<tr>
					<td>Rental Duration:</td>
					<td>${film.rentalDuration }:</td>

				</tr>
				<tr>
					<td>Rental Rate:</td>
					<td>${film.rentalRate }:</td>

				</tr>
				<tr>
					<td>Rental Length:</td>
					<td>${film.filmLength }:</td>

				</tr>
				<tr>
					<td>Replacement Cost:</td>
					<td>${film.replacementCost }:</td>

				</tr>
				<tr>
					<td>Rating:</td>
					<td>${film.rating }</td>

				</tr>
				<tr>
					<td>Special Features:</td>
					<td>${film.specialFeatures }</td>

				</tr>
				<tr>
					<td>Category:</td>
					<td><c:if test="${empty film.category">No Category Found</c:if>
						<c:if test="${not empty film.category }">${film.findFilmsByCategory }</c:if></td>

				</tr>
				<tr>
					<td>Actors:</td>
					<td><c:if test="${empty film.actors">No Actor Found</c:if>
						<c:if test="${not empty film.actors }">${film.actors }</c:if></td>

				</tr>

			</table>
		</c:when>
	</c:choose>

	<c:otherwise>
		Error: No Film Found.
	</c:otherwise>



	<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>
</body>
</html>