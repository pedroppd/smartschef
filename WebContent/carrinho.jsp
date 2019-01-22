<%@page import="br.com.projetofinal.model.*"%>
<%@page import="br.com.projetofinal.dao.*"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.DecimalFormat"%>
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

<meta charset="ISO-8859-1">
</head>

<body>
<%
ItemVenda itemVenda = new ItemVenda();
	
	request.setAttribute("quantidade", itemVenda.getQuantidade());
	DecimalFormat f = new DecimalFormat("00.00");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container" style="margin-top: 200px">
	${msg}

	<form action="ControleCarrinho?evento=compra" method="post"
		name="carrinho">
		<h4 class="center_title_bar">Carrinho de Compras</h4>
		<table class="table table-striped">
			<tr>
				<th>Produto</th>
				<th>Quant.</th>
				<th>Total</th>
				<th>Numero Mesa</th>
				<th>Adicionar</th>
				<th>Remover</th>
				<th>Cancelar</th>
			</tr>
			<%
			
				HashMap<Integer, ItemVenda> carrinho = (HashMap<Integer, ItemVenda>) request.getSession().getAttribute("carrinho");
				
				ItemVenda p = null;
				Integer quantidade = 0;
				Double somaTotal = 0.0;
				Double filtroDecimais = 0.0;
				
				if (carrinho != null) {
					Set<Integer> chaves = carrinho.keySet();
					for (Integer chave : chaves) {
						p = carrinho.get(chave);
						somaTotal += p.getPrecoParcial();
						filtroDecimais = somaTotal;
						quantidade += p.getQuantidade();
						
						session.setAttribute("total", filtroDecimais);
						session.setAttribute("quantidade", quantidade);
			%>
			<tr>
				<td><a
					href="detalhes.html?id=<%out.println(p.getProduto().getId());%>">
						<%
							out.println(p.getProduto().getNome());
						%>
				</a></td>
				<td>
					<%
						out.println(p.getQuantidade());
					%>
				</td>
				<td>
					<%
						out.println("R$" + f.format(p.getPrecoParcial()));
					%>
				</td>
				
				<td>
					<input type="text" placeholder="digite o numero da mesa" name="numeromesa"/>
				</td>
				<td><a
					href="ControleCarrinho?evento=mais&produto=<%out.println(p.getProduto().getId());%>"><h4>+</h4></a></td>
				<td><a
					href="ControleCarrinho?evento=menos&produto=<%out.println(p.getProduto().getId());%>"><h4>-</h4></a></td>
				<td><a
					href="ControleCarrinho?evento=limpar&produto=<%out.println(p.getProduto().getId());%>">Cancelar</a></td>
			</tr>
			<%
				out.println("<input name='id' type='hidden' value='" + p.getProduto().getId() + "'/>");
						out.println("<input name='qtd' type='hidden' value='" + p.getQuantidade() + "'/>");
					}
				}
				if (carrinho == null || carrinho.isEmpty()) {
			%>
			<td class="produto">--</td>
			<td class="qtd"><input class="quantidade" type="text"
				disabled="disabled" name="quantidade" size="2" value="--"></td>
			<td>--</td>
			<td class="total">--</td>
			<td class="cancel">--</td>
			<%
				}
			%>
		</table>
		<br>
		<br>
		<%
			if (session.getAttribute("total") != null) {
		%>
		<strong class="pagamentoTotal">Total a pagar: <%
			out.println("R$ " + session.getAttribute("total"));
		%></strong>
		<%
			}
		%>
		<a href="cardapio.jsp"
			class="btn btn-danger" style="margin-left: 220px">Cardápio</a>
		<input type="submit" class="btn btn-danger" value="Finalizar Compra"
			style="margin-left: 180px" /> 
	</form>
</div>

</body>
</html>