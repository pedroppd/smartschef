package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.Venda;

public class VendaDao {
	
	
	public boolean add(Venda venda) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();  
		boolean success = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into venda (precoTotal_venda, data_venda, itemvenda_iditem_venda, numero_mesa) values (?,?,?,?)");
			stmt.setDouble(1, venda.getPrecoTotal());
		    stmt.setString(2, venda.getData_compra());
		    stmt.setInt(3, venda.getId_itemVenda());
			stmt.setString(4, venda.getNumeroMesa());
			stmt.execute();
			success = true;

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt);
		}
		return success;

	}
/*
	public List<Venda> list() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Venda> venda = new ArrayList<Venda>();
		try {

			stmt = con.prepareStatement("SELECT * FROM venda");
			rs = stmt.executeQuery();
			
			

			while (rs.next()) {
			Venda v = new Venda();
				
				v.setId(rs.getInt("idvenda"));
			
		        v.getItemVenda().setId(rs.getInt("iditemVenda"));
				v.setPrecoTotal(rs.getDouble("precoTotal_venda"));
				
				venda.add(v);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return venda;
	}
	
	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
		stmt = con.prepareStatement("delete from venda where idvenda=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	
	
	public void update(Venda v) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("UPDATE venda SET precoTotal_venda=?, iditemVenda=?  WHERE idvenda=?");
			stmt.setDouble(1, v.getPrecoTotal());
			stmt.setLong(2, v.getItemVenda().getId());
			stmt.setLong(3, v.getId());
			
			
			stmt.execute();
			
		}catch(SQLException ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
		
		
	}
	
	
*/

}
