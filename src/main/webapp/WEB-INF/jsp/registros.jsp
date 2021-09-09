<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" lang="pt-br">
	<title>Cadastro de Autor</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
		crossorigin="anonymous">
</head>
<body class="container bg-black bg-gradient text-white">
<h1 class="text-center">Cadastro de Autor</h1>
<form class="row g-3" action="<c:url value="/registros"/>" method="POST">
	<div class="col-md-5">
		<label for="nome">Nome</label>
		<input id="nome" class="form-control" placeholder="Nome do autor" name="nome">
	</div>
	<div class="col-md-5">
		<label for="email">E-mail</label>
		<input id="email" class="form-control" placeholder="E-mail do autor" name="email">
	</div>
	<div class="col-md-2">
		<label for="dataDeNascimento">Data de Nascimento</label>
		<input id="dataDeNascimento" class="form-control" placeholder="dd/mm/aaaa" name="dataDeNascimento">
	</div>
	<div class="form-group">
		<label for="miniCurriculo">Mini Currículo</label>
		<input id="miniCurriculo" class="form-control d-flex" placeholder="Currículo do autor" name="miniCurriculo">
	</div>
	
	<input type="submit" value="Cadastrar" class="d-grid gap-2 col-6 mx-auto mt-3 btn-warning btn-lg">
</form>
	<h1 class="text-center mt-3">Lista de Autores</h1>
	<table class="table table-secondary table-hover table-bordered table-striped">
		<thead>
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>DATA DE NASCIMENTO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registros}" var="r">
				<tr>
					<td>${r.nome}</td>
					<td>${r.email}</td>
					<td>${r.dataDeNascimento}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>