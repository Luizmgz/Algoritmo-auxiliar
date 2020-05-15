<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pessoa</title>
</head>
<body>


	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="/ProjetoBasico/pessoaUpdate" method="POST" modelAttribute="pessoa">
			<form:hidden path="pessoa.id" />
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

			<input type="submit" value="Salvar" />

		</form>
	</div>

	<a href="/ProjetoBasico/pessoas"> Voltar</a>
</body>
</html>