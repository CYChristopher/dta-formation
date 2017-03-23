<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="entete.jsp"%>
<title>Ajouter une pizza</title>
</head>
<body>
	<div class="container-fluid">
		<form class="form-horizontal" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Ajouter une pizza</legend>

				<%@include file="formPizza.jsp"%> 

			</fieldset>
		</form>
	</div>
	
	<%@include file="scriptImage.html"%>
</body>
</html>