<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="entete.jsp"%>
<title>Modification d'un ingredient</title>
</head>
<body>
	<div class="container-fluid">
		<form:form class="form-horizontal" method="post"
			modelAttribute="ingredient">
			<div class="form-group">
				<label class="col-md-4 control-label" for="id">Id</label>
				<form:input id="id" name="id" path="id" disabled="true"
					value="${ingredient.id}" />
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom</label>
				<form:input id="nom" name="nom" class="form-control input-md"
					path="nom" value="${ingredient.nom}" />
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="prix">Prix</label>
				<form:input id="prix" name="prix" class="form-control input-md"
					path="prix" value="${ingredient.prix}" />
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="quantite">Quantite</label>
				<form:input id="quantite" name="quantite"
					class="form-control input-md" path="quantite"
					value="${ingredient.quantite}" />
			</div>
			<div class="form-group">
				<form:button class="form-control input-md" type="submit">Valider</form:button>
			</div>

		</form:form>
	</div>
</body>
</html>