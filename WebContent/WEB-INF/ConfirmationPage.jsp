<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Film Results</title>
</head>
<body style="background-color:GREENYELLOW;">
	<c:choose>
		<c:when test="${! empty film }">
			<h1>Film Newly Created</h1>
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
				<tr>
					<td>Language ID:</td>
					<td>${film.languageId }</td>
				</tr>
				<tr>
					<td>Rental Duration:</td>
					<td>${film.rentalDuration }:</td>

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

			</table>
		</c:when>
 	<c:otherwise>
 	<br>
		<h3>This film has successfully been deleted!!</h3> 
	</c:otherwise> 
		
	</c:choose>

<br>


	<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>
</body>