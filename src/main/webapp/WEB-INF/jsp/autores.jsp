<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>AUTORES</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
	<h1 class="text-center">CADASTRO DE AUTOR</h1>
	<form action="<c:url value="/autores"/>" method="POST">
		<div class="form-group">
			<label for="nome">Nome</label>
			<input id="nome" class="form-control" name="nome">
		</div>
		<div class="form-group">
			<label for="email">EMail</label>
			<input id="email" class="form-control" name="email">
		</div>
		<div class="form-group">
			<label for="dataNascimento">Data de Nascimento</label>
			<input id="dataNascimento" class="form-control" name="dataNascimento">
		</div>
		<div class="form-group">
			<label for="curriculo">Currículo</label>
			<input id="curiculo" class="form-control" name="curriculo">
		</div>
		
		<input type="submit" value="Gravar" class="mt-2 btn-primary">
	</form>

	<h1 class="text-center">LISTA DE AUTORES</h1>
	<table class="table table-hover table-striped table-bordered" >
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Data de Nascimento</th>
				<th>Curriculo</th>			
			</tr>			
		</thead>
		<tbody>
			<c:forEach items="${autores}" var="a">
				<tr>
					<td>${a.nome}</td>
					<td>${a.email}</td>
					<td>${a.dataNascimento}</td>
					<td>${a.curriculo}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>