package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.Categoria;
import br.com.projetofinal.model.Produto;

public class CategoriaDao {

	@SuppressWarnings("finally")
	public List<Categoria> listCategoria() throws ClassNotFoundException{
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Categoria>categorias = new ArrayList<>();
		
			try {

				stmt = con.prepareStatement("SELECT * FROM categoria");
				rs = stmt.executeQuery();
				
				

				while (rs.next()) {
					Categoria c = new Categoria();
					
					c.setId(rs.getInt("idcategoria"));
					c.setCategoria(rs.getString("categoria_nome"));
				
					categorias.add(c);
				}
			
		}catch(SQLException ex) {
			throw ex;
		}finally {
			return categorias;
		}

}
	
	
	
	public Categoria searchById(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Categoria p = new Categoria();

		try {
			stmt = con.prepareStatement("SELECT * FROM categoria where idcategoria=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				p.setId(rs.getInt("idcategoria"));
				p.setCategoria(rs.getString("categoria_nome"));
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return p;

	}
}

