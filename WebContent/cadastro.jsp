<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="br.com.projetofinal.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.projetofinal.dao.*"%>
<%@ page import="br.com.projetofinal.model.*"%>

<%
	request.setAttribute("produto", new ProdutoDao().list());

	request.setAttribute("categorias", new CategoriaDao().listCategoria());

	request.setAttribute("tamanhos", new TamanhoDao().list());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de produtos</title>
</head>
<body>

	<form action="add" method="post" enctype="multipart/form-data">

		<label>Nome:</label> <input type="text" name="nome"><br>
		<label>Preço:</label> <input type="text" name="preco"><br>
		<label>Imagem:</label> <input type="file" name="imagem"><br>
		<label>Categoria:</label> <select name="categoria">
			<c:forEach items="${categorias}" var="cat">
				<option value="${cat.id}">${cat.categoria}</option>
			</c:forEach>
		</select> 
		<br> 
		<select name="tamanho">
			<c:forEach items="${tamanhos}" var="t">
				<option value="${t.id}">${t.tamanho}</option>
			</c:forEach>
		</select><br> <label>Descrição:</label> <input type="text"
			name="descricao"><br> <input type="submit"
			value="cadastrar" />

	</form>

	<hr>





</body>
</html>