<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Début de la barre de navigation -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Barre de navigation pour smartphones -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#maNavBar">
				<span class="icon-bar"></span>
				<!-- à compléter -->
			</button>
			<!-- <a class="btn btn-primary pull-right"
				href="<c:url value='/logout'></c:url>" role="button">Deconnexion</a> -->
		</div>

		<!-- Barre de navigation pour ordinateurs -->
		<div class="collapse navbar-collapse" id="maNavBar">
			<ul id="liste" class="nav navbar-nav">
				<li class="active"><a href="Accueil.html"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>
						Accueil</a></li>
				<li><a href="#"><span
						class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						La Florentina</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><span
						class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						Notre carte<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<!-- à compléter --> Télécharger la carte
						</li>
						<li>
							<!-- à compléter --> Voir la carte
						</li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header"><span
							class="glyphicon glyphicon-fire" aria-hidden="true"></span> Nos
							pizzas</li>
						<li><a href="#">Marguerita <span
								class="label label-success">Produit de la semaine</span></a></li>
						<li><a href="#">Reine</a></li>
						<!-- à compléter -->
					</ul></li>
				<li><a href="javascript:chargeHTML('ContactezNous')"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>
						Contactez-nous</a></li>
			</ul>
			<a id="btnConnexion" class="btn btn-primary pull-right"
				href="<c:url value='/login'></c:url>" role="button">Connexion</a> <a
				id="btnDeconnexion" class="btn btn-primary pull-right"
				href="<c:url value='/logout'></c:url>" role="button">Deconnexion</a>
			<input type="hidden" id="user" value="${user}" />
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<script>
	$(document).ready(function (){
		if($("#user").attr('value') !== ""){
			$("#btnConnexion").hide();
			$("#btnDeconnexion").show();
		} else{
			$("#btnConnexion").show();
			$("#btnDeconnexion").hide();
		}
        if($("#accueil").exist() && $("#btnConnexion").is(':hidden')){
        	$("#btnConnexion").show();
        	$("#btnDeconnexion").hide();
        }
	});
</script>