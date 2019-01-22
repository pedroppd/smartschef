package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.ItemVenda;


public class ItemVendaDao {
	

	public Integer add(ItemVenda p) throws Exception {
		Integer id = null;
		Connection conn = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("insert into itemvenda (produto_idproduto, preco_parcial, quantidade_itemVenda) values (?,?,?)", stmt.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getIdproduto());
			stmt.setDouble(2, p.getPrecoParcial());
			stmt.setInt(3, p.getQuantidade());
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.closeConnetion(conn, stmt);
		}
		return id;
	}

	public List<ItemVenda> list() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ItemVenda> itemvenda = new ArrayList<ItemVenda>();
		try {

			stmt = con.prepareStatement("SELECT * FROM itemvenda");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
			ItemVenda item = new ItemVenda();
				
				item.setId(rs.getInt("iditemVenda"));
				item.getProduto().setId(rs.getInt("produto_idproduto"));
				item.setPrecoParcial(rs.getDouble("valor"));
				item.setQuantidade(rs.getInt("quantidade"));
				
				itemvenda.add(item);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return itemvenda;
	}
	
	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
		stmt = con.prepareStatement("delete from itemvenda where iditemVenda=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	
	
	public void update(ItemVenda i) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE itemvenda SET produto_idproduto=?, valor=?, quantidade=?  WHERE iditemVenda=?");
			stmt.setLong(1, i.getProduto().getId());
			stmt.setDouble(2, i.getPrecoParcial());
			stmt.setInt(3, i.getQuantidade());
			stmt.setLong(4, i.getId());
			
			stmt.execute();
			
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	

}
