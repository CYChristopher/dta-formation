<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="entete.jsp"%>
<title>Pizzeria La Florentina</title>
</head>
<body id="accueil">
	<div class="container-fluid">
		<div class="row">
			<div id="monCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#monCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#monCarousel" data-slide-to="1"></li>
					<li data-target="#monCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

					<div class="item active">
						<img src="Images/Carousel/Carousel1.jpg" alt="Pizzeria">
						<div class="carousel-caption">
							<h1>La Florentina</h1>
							<p>L'italie est dans votre pizza !</p>
						</div>
					</div>
					<div class="item">
						<img src="Images/Carousel/Carousel2.jpg" alt="Pizzas">
						<div class="carousel-caption">
							<h1>Nos pizzas</h1>
							<p>Il y en a pour tout les goût :-)</p>
						</div>
					</div>
					<div class="item">
						<img src="Images/Carousel/Carousel3.jpg" alt="Four">
						<div class="carousel-caption">
							<h1>Four à bois</h1>
							<p>Quoi de mieux qu'un four à bois pour faire de bonnes
								pizzas ?</p>
						</div>
					</div>
				</div>

				<!-- Flèches de contrôle -->
				<a class="left carousel-control" href="#monCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Précédent</span>
				</a> <a class="right carousel-control" href="#monCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Suivant</span>
				</a>
			</div>
			<%@include file="navbar.jsp"%>
		</div>
	</div>
</body>
</html>