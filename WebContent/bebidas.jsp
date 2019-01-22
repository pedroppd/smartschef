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
<!DOCTYPE html>

<%
	request.setAttribute("produto", new ProdutoDao().listDriks());
%>
<html>
<head>
<link href="js/all.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Varela+Round"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" media="all">
<link rel="stylesheet" type="text/css"
	href="resources/css/stylePizzaDoce.css" media="all">
<meta charset="ISO-8859-1">
<title>Pizzas fitness</title>
</head>
<body>

<div>
		<a href="carrinho.jsp">
			<button type="button"
					class=" justify-content-center btn btn-outline-light btn-nav">
					<i class="material-icons md-29 md-light">Carrinho de compras</i>
			</button>
		</a>
	</div>
	
	<br><br>

	<div class="resp-tabs-container ">


		<c:forEach items="${produto}" var="p">

			<div class="col-md-6 ">
				<div class="card-deck text-white bg-dark" style="width: 18rem;">
					<img class="card-img-top" width="100" height="200"
						src="fotos/${p.imagem}" alt="Card image cap">
					<div class="card-body">

						<p class="card-text">${p.nome}</p>
						<p class="card-text">${p.descricao}</p>
						<div class="clearfix">
							<a href="ControleCarrinho?evento=adicionar&produto=${p.id}"
								class="btn btn-outline-danger">Adicionar ao carrinho</a>
						</div>
					</div>
				</div>
			</div><br><br>

		</c:forEach>
	</div>


</body>
</html>