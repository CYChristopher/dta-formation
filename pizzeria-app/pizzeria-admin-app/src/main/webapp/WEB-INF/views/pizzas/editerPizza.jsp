<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="entete.jsp"%>
<title>Modifier pizza</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Modifier une pizza</legend>

				<%@include file="formPizza.jsp"%> 

			</fieldset>
		</form>
	</div>
	
	<%@include file="scriptImage.html"%>
	
</body>
</html>