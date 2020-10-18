<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Film Results</title>
</head>
<body>
	<h1>Search Film Results</h1>
	<c:out value="${filmID }" />
	<c:if test="${empty film }">No film found</c:if>
	<c:if test="${! empty film }">
		<h2>Film Title: ${film.title }</h2>
		<table>
			<tr>
				<td>Film ID:</td>
				<td>${film.id }</td>

			</tr>
			<tr>
				<td>Film Description:</td>
				<td>${film.decsription }</td>

			</tr>
			<tr>
				<td>Release Year:</td>
				<td>${film.releaseYear }</td>

			</tr>
			<c:choose>
				<c:when test="${film.languageId == 0}">
					<tr>
						<td>Language:</td>
						<td>${film.language }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>Language ID:</td>
						<td>${film.languageId }:</td>

					</tr>
				</c:otherwise>
			</c:choose>
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
				<td>${film.category }</td>

			</tr>
			
			<tr>
				<td>Actors:</td>
				<td><c:if test="${empty film.actors}">No Actor Found</c:if>
			<%-- 	<c:if
						test="${not empty film.actors }">${film.actors }</c:if></td> --%>
				<c:forEach var="actor" items="${film.actors }">
				
			
				<td>Actor ID: ${actor.id } <br> Name: ${actor.firstName } ${actor.lastName }</td>
			</tr>

</c:forEach>

		</table>
		
		
		<form action="getNewFilmInfo.do" method="GET">
			<button type="submit" name="filmId" value="${film.id }">Update
				Film Information</button>
		</form>
		<form action="deleteFilm.do" method="GET">
			<button type="submit" name="filmId" value="${film.id }">Delete
				Film</button>
		</form>
	</c:if>
	<br>
	<br>
	<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>

</body>
</html>