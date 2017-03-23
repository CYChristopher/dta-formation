<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="entete.jsp"%>
<title>Liste des pizzas</title>
</head>
<body>

	<div class="container-fluid">
		<div id="contenu">
			<div class="page-header">
				<h1>Les pizzas du moment <a class="btn btn-success pull-right"
					href="<c:url value='/pizzas/new'></c:url>" role="button">Ajouter</a></h1>
			</div>
			<div id="pizzasDuMoment" class="row">
				<c:forEach var="pizza" items="${pizzas }">
					<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
						<div class="thumbnail">
							<a href="#" class="link tooltip-link" data-toggle="tooltip"
								data-original-title="${pizza.nom}"> <img
								src="<c:url value='/${pizza.urlImage}'></c:url>"
								alt="${pizza.nom}">
							</a>
							<div class="caption">
								<h3>${pizza.nom}</h3>
								<p>- ${pizza.categorie.toString()} -</p>
								<p>${pizza.description}</p>
								<p>${pizza.prix}€</p>
								<p>
									<a class="btn btn-warning pull-left"
										href="<c:url value='/pizzas/edit?code=${pizza.code}'></c:url>"
										role="button">Editer</a> <a class="btn btn-danger pull-right"
										href="<c:url value='/pizzas/delete?code=${pizza.code}'></c:url>"
										role="button">Supprimer</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Fonctions JavaScript -->
	<script>
		$(function() {
			// Gestion des tooltips des pizzas du moment
			$(".tooltip-link")
					.tooltip(
							{
								title : "<div style='background-color:white; border: 1px solid black'><img src='http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png' style='width:24px;'>Pizza</i></div>",
								html : true,
								template : '<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-head"><h2><img src="http://icons.iconarchive.com/icons/sonya/swarm/256/Pizza-icon.png" style="width:24px;"> Info</h2></div><div class="tooltip-inner"></div></div>'
							});
		});
	</script>
</body>
</html>