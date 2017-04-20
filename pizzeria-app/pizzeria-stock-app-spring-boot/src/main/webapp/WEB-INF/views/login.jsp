<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="entete.jsp"%>
<title>Connexion</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>Connexion</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Login</label>
					<div class="col-md-4">
						<input id="login" name="login" type="text"
							placeholder="Your login" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="Your password" class="form-control input-md" required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="valider"></label>
					<div class="col-md-4">
						<button id="valider" name="valider" class="btn btn-primary">Connexion</button>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
</body>
</html>