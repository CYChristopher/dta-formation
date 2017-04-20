<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="entete.jsp"%>
<title>Liste des ingrédients</title>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-striped" style="text-align:center;">
			<tr>
				<td>#</td>
				<td>Nom</td>
				<td>Prix</td>
				<td>Quantite</td>
			</tr>
			<c:forEach items="${list}" var="ingredient">
				<tr>
					<td>${ingredient.id}</td>
					<td>${ingredient.nom}</td>
					<td>${ingredient.prix}€</td>
					<td>${ingredient.quantite}</td>
					<td><a
						href="<c:url value='/page/ingredients/${ingredient.id}'></c:url>">Modifier</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>