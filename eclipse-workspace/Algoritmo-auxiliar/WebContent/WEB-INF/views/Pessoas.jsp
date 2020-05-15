<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pessoas</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>Nome</th>
				<th>email</th>
				<th>Data</th>
			</tr>
			<c:forEach var="p" items="${listPessoas}">
				<tr>
					<td>${p.nome}</td>
					<td>${p.email}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dataNasc}" /></td>
					<td><a href="pessoaDetail/${p.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="pessoaSave" method="POST" modelAttribute="pessoa">
			<p>
				Nome:
				<form:input path="pessoa.nome" />
				
			</p>

			<p>
				E-Mail:
				<form:input path="pessoa.email" />
				
			</p>

			<p>
				Data de Nascimento:
				<form:input path="pessoa.dataNasc" />
			</p>

			<input type="submit" value="Adicionar" />

		</form>
	</div>


</body>

</html>