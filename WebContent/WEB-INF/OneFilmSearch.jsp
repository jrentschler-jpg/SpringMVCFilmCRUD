<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Film By ID</title>
</head>
<body>
<h1>Search Film By Film ID</h1>
<%-- <c:choose>
	<c:when test="${empty nofilm }">
	<hr>
	<strong>Sorry! Could NOT find anything with that ID.</strong>
	</c:when>
</c:choose> --%>
<p><!--  -->

</p>
<form action="findFilmById.do" method="GET">
Film ID: 
<input class="input" type="number" min="0" name="Film ID" placeholder="Enter in Film ID"/>
<input class="submit" type="submit" value="Get Film by ID" />
</form>




<p>
		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
	</p>

</body>
</html>