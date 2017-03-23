<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="entete.jsp"%>
<title>Informations techniques</title>
</head>
<body>
	<div class="container-fluid">
		<div id="contenu">
		<c:forEach var="time" items="${times}">
		<p>Temps d'exécution pour la requête ${time} ms</p>
		</c:forEach>
			<p>
				<strong>Nombres de sessions ouvertes en cours : </strong>${compteur}</p>
		</div>
	</div>
</body>
</html>