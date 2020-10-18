<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Search Film Results</title>
</head>
<body>
<div class="container-fluid">
	<h1>Search Film Results</h1>
	<c:out value="${filmID }" />
	<c:if test="${empty film }">No film found</c:if>
	<c:if test="${! empty film }">
		<h2>Film Title: ${film.title }</h2>
		<table class="table table-striped">
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
				<td><h4>Actors:</h4></td>
				<td><c:if test="${empty film.actors}">No Actor Found</c:if>
			<%-- 	<c:if
						test="${not empty film.actors }">${film.actors }</c:if></td> --%>
				<c:forEach var="actor" items="${film.actors }">
				
			<tr>
				<td>Actor ID:</td><td> ${actor.id }</td>
				</tr>
				<tr>
				<td>Name:</td><td>${actor.firstName} ${actor.lastName }</td>
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
	</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>