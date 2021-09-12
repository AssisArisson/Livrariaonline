<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Autores</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>	
<body class="container">
	<form action="<c:url value="/autores"/>" method="post">
		<div class="form-group">	
		<h1 class ="text-center">Cadastro de Autor</h1>
			<div class="col-md-6 mb-3">
			<label for="nome">Nome</label>
			<input id="nome" class="form-control" name="nome">		
		</div>
		<div class="form-group">
			<div class="col-md-5 mb-3">
			<label for="email">Email</label>
			<input id="email" class="form-control" name="email">		
		</div>
		<div class="form-group">
			<div class="col-md-2 mb-3">
			<label for="data">Data de Nascimento</label>
			<input id="data" class="form-control" name="data">		
		</div>
		<div class="form-group">
			<label for="curriculo">Mini Curriculo</label>
			<textarea id="curriculo" class="form-control" name="curriculo"></textarea>	
		</div>
		<input type="submit" value="Gravar" class="mt-2 btn-dark">
	</form>
	<h1 class ="text-center">Lista de Autores</h1>
	<table class="table table-hover table-striped table-bordered table-dark">
		<thead>
			<tr>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>DATA DE NASCIMENTO</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items= "${autores}" var= "a">
				<tr>
					<td>${a.nome}</td>
					<td>${a.email}</td>
					<td>${a.data}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>