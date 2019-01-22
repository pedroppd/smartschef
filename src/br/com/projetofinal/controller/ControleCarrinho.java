package br.com.projetofinal.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetofinal.dao.ItemVendaDao;
import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.dao.VendaDao;
import br.com.projetofinal.model.ItemVenda;
import br.com.projetofinal.model.Produto;
import br.com.projetofinal.model.Venda;





@WebServlet("/ControleCarrinho")
public class ControleCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleCarrinho() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Produto> produtos = new ProdutoDao().list();
			request.setAttribute("produtos", produtos);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (!response.isCommitted()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("carrinho.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Na variavel evento enviamos a ação a ser
		// realizada(adicionar,atualizar,limpar,comprar)
		String evento = request.getParameter("evento");
		if (evento != null) {
			if (evento.equals("adicionar")) {
				if (request.getSession().getAttribute("carrinho") == null) {
					HashMap<Integer, ItemVenda> carrinho = new HashMap<Integer, ItemVenda>();
					request.getSession().setAttribute("carrinho", carrinho);
				}
				
				@SuppressWarnings("unchecked")
				HashMap<Integer, ItemVenda> carrinho = (HashMap<Integer, ItemVenda>) request.getSession().getAttribute("carrinho");
				// A variavel produto pega o id do produto a ser utilizado
				Integer produto = Integer.parseInt(request.getParameter("produto"));
				ItemVenda pedido = carrinho.get(produto);
				
				if (pedido == null) {
					
					try {
						ItemVenda ped = new ItemVenda();
						Produto p = new ProdutoDao().searchById(produto);
						ped.setProduto(p);
						ped.setQuantidade(1);
						ped.setPrecoParcial(p.getPreco());
						pedido = ped;
		
					} catch (Exception e) {
						 try {
							throw e;
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
					}
				} else {
					pedido.setQuantidade(pedido.getQuantidade() + 1);
					pedido.setPrecoParcial(pedido.getPrecoParcial() + pedido.getProduto().getPreco());
				}
				
				// Removemos parar atualizar a sessão do carrinho
				carrinho.remove(produto);
				carrinho.put(produto, pedido);
				request.getSession().setAttribute("carrinho", carrinho);

			} else if (evento.equals("mais")) {
				// Esse evento serve para adicionarmos mais 1 a quantidade do produto no
				// carrinho
				@SuppressWarnings("unchecked")
				HashMap<Integer, ItemVenda> carrinho = (HashMap<Integer, ItemVenda>) request.getSession()
						.getAttribute("carrinho");
				if (carrinho != null) {
					Integer produto = Integer.parseInt(request.getParameter("produto"));
					ItemVenda pedido = carrinho.get(produto);
					if (pedido != null) {
						Integer qtd = pedido.getQuantidade();
						pedido.setQuantidade(qtd + 1);
						pedido.setPrecoParcial(pedido.getQuantidade() * pedido.getProduto().getPreco());
						carrinho.remove(produto);
						if (pedido.getQuantidade() > 0) {
							carrinho.put(produto, pedido);
						} else {
							request.getSession().setAttribute("total", 0.0);
							request.getSession().setAttribute("quantidade", 0);
						}
						request.getSession().setAttribute("carrinho", carrinho);

					}
				}

			} else if (evento.equals("menos")) {
				// Esse evento serve para subtrair 1 a quantidade do produto no carrinho
				@SuppressWarnings("unchecked")
				HashMap<Integer, ItemVenda> carrinho = (HashMap<Integer, ItemVenda>) request.getSession()
						.getAttribute("carrinho");
				if (carrinho != null) {
					Integer produto = Integer.parseInt(request.getParameter("produto"));
					ItemVenda pedido = carrinho.get(produto);
					if (pedido != null) {
						Integer qtd = pedido.getQuantidade();
						pedido.setQuantidade(qtd - 1);
						pedido.setPrecoParcial(pedido.getQuantidade() * pedido.getProduto().getPreco());
						carrinho.remove(produto);
						if (pedido.getQuantidade() > 0) {
							carrinho.put(produto, pedido);
						} else {
							request.getSession().setAttribute("total", 0.0);
							request.getSession().setAttribute("quantidade", 0);
						}
						request.getSession().setAttribute("carrinho", carrinho);

					}
				}
			} else if (evento.equals("limpar")) {
				// Aqui excluimos um produto do carrinho
				@SuppressWarnings("unchecked")
				HashMap<Integer, ItemVenda> carrinho = (HashMap<Integer, ItemVenda>) request.getSession()
						.getAttribute("carrinho");
				if (carrinho != null) {
					Integer produto = Integer.parseInt(request.getParameter("produto"));
					carrinho.remove(produto);
					request.getSession().setAttribute("carrinho", carrinho);
					request.getSession().setAttribute("total", 0.0f);
					request.getSession().setAttribute("quantidade", 0);
				}
			}
		}

		processRequest(request, response);
	}

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String evento = request.getParameter("evento");
		if (evento != null) {
		}
		if (evento.equals("compra")) {
			// Nesse evento finalizamos a compra
			HttpSession session = request.getSession();
			String ids[] = request.getParameterValues("id");
			String qtd[] = request.getParameterValues("qtd");
			//Integer identificacao = (Integer) session.getAttribute("identificacao");
			String usuarioAutenticado = (String) session.getAttribute("usuarioAutenticado");
			Double total = Double.parseDouble(session.getAttribute("total").toString());
			String numeroMesa = request.getParameter("numeromesa");
			//total = total.replace(',', '.');
			Double valor = total;
			Date data = new Date(System.currentTimeMillis());
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
			if (valor != null) {
				List<ItemVenda> dados = new ArrayList<ItemVenda>();
				try {
					for (int i = 0; i < ids.length; i++) {
						Produto pd = new ProdutoDao().searchById(Integer.parseInt(ids[i]));
						ItemVenda pedido = new ItemVenda();
						pedido.setQuantidade(Integer.parseInt(qtd[i]));
						pedido.setIdproduto(Integer.parseInt(ids[i]));   
						pedido.setPrecoParcial(pd.getPreco() * Integer.parseInt(qtd[i]));
						dados.add(pedido);
						ItemVendaDao dao = new ItemVendaDao();
						//dao.add(pedido);
					}
					for (ItemVenda p : dados) {
						ItemVendaDao dao = new ItemVendaDao();
						Integer itemvenda = dao.add(p);
						VendaDao cd = new VendaDao();
						Venda compra = new Venda();
						
						compra.setData_compra(fmt.format(data));
						compra.setPrecoTotal(valor);
						compra.setNumeroMesa(numeroMesa);
						compra.setId_itemVenda(itemvenda);
						cd.add(compra);
					}
					session.removeAttribute("carrinho");
					session.removeAttribute("total");
					session.removeAttribute("quantidade");
					request.setAttribute("msg", "<div class='alert alert-success'>Compra efetuada com sucesso!</div>");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}
			} else {
				request.setAttribute("msg", "<div class='alert alert-danger'>Algo deu errado ao efetuar à compra :(!</div>");
				request.getRequestDispatcher("carrinho.jsp").forward(request, response);
			}
		}
		processRequest(request, response);
	}

}
