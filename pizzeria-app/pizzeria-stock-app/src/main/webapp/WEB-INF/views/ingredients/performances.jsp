<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="entete.jsp"%>
<title>Performances</title>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-striped" style="text-align: center;">
			<tr>
				<td>#</td>
				<td>Service</td>
				<td>Date</td>
				<td>Durée</td>
			</tr>
			<c:forEach items="${list}" var="performance">
				<tr>
					<td>${performance.id}</td>
					<td>${performance.service}</td>
					<td>${performance.dateTime}</td>
					<td>${performance.tempsExecution} ms</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>