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
			<c:forEach var="event" items="${pizzaStats}">
				<c:if test="${event.modifiedPizza != null}">
					<p>Pizza <strong>${event.pizza.code} -
						${event.pizza.nom}</strong> modifiée en <strong>${event.modifiedPizza.code} - ${event.modifiedPizza.nom}</strong> le ${event.heure}</p>
				</c:if>
				<c:if test="${event.modifiedPizza == null}">
					<c:if test="${event.type == 'SAVE'}">
						<p>Pizza <strong>${event.pizza.code} -
						${event.pizza.nom}</strong> créée le ${event.heure}</p>
					</c:if>
					<c:if test="${event.type == 'DELETE'}">
						<p>Pizza <strong>${event.pizza.code} -
						${event.pizza.nom}</strong> supprimée le ${event.heure}</p>
					</c:if>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>