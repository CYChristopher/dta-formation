<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="entete.jsp"%>
<title>Se connecter</title>
</head>
<body>
	<div class="container-fluid">
		<div class="alert alert-danger">
			<b>Attention!</b> ${msg}
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
		</div>
		<form class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Connexion</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email"></label>
					<div class="col-md-4">
						<input id="email" name="email" type="email"
							placeholder="Votre login" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password"></label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="Votre mot de passe" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="valider"></label>
					<div class="col-md-4">
						<button id="valider" type="submit" name="valider" class="btn btn-success">Se
							connecter</button>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>