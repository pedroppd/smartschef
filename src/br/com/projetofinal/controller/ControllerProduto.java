package br.com.projetofinal.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetofinal.dao.CategoriaDao;
import br.com.projetofinal.dao.ProdutoDao;
import br.com.projetofinal.dao.TamanhoDao;
import br.com.projetofinal.model.Categoria;
import br.com.projetofinal.model.Produto;
import br.com.projetofinal.model.Tamanho;
import br.com.projetofinal.util.Upload;

@WebServlet({ "/add", "/list" })
@MultipartConfig
public class ControllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerProduto() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			execute(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException {
		Upload up = new Upload();

		if (request.getServletPath().equals("/add")) { // Método para ADICIONAR produtos
			up.setFolderUpload("fotos");

			Produto produto = new Produto();
			
			CategoriaDao daocat = new CategoriaDao();
			TamanhoDao tamanhodao = new TamanhoDao();
			
					
			if (up.formProcess(getServletContext(), request)) {
				int id = Integer.parseInt(up.getForm().get("categoria").toString());
				Categoria categoria = daocat.searchById(id);
				
				int idtamanho =  Integer.parseInt(up.getForm().get("tamanho").toString());
				Tamanho tamanho = tamanhodao.searchById(idtamanho);
				
				produto.setNome(up.getForm().get("nome").toString());
				produto.setPreco(Double.parseDouble(up.getForm().get("preco").toString()));
				produto.setImagem(up.getFiles().get(0));
				produto.setCategoria(categoria);
				produto.setDescricao(up.getForm().get("descricao").toString());
				produto.setTamanho(tamanho);

				ProdutoDao dao = new ProdutoDao();

				try {
					dao.add(produto);
				} catch (ClassNotFoundException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				response.sendRedirect("cadastro.jsp");
			}
			
		} else if (request.getServletPath().equals("/listar")) { // Método para listar todos os produtos
			ProdutoDao dao = new ProdutoDao();
			List produto = dao.list();

			request.setAttribute("produtos", produto);

		}

	}

}
