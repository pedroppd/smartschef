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
import br.com.projetofinal.model.Tamanho;

public class TamanhoDao {
	
	public void add(Tamanho tamanho) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into tamanho (tamanho)values(?)");
			stmt.setString(1, tamanho.getTamanho());
			stmt.execute();

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt);
		}

	}
	
	
	
	public List<Tamanho> list() throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Tamanho> tamanhos = new ArrayList<Tamanho>();
		try {

			stmt = con.prepareStatement("SELECT * from tamanho");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Tamanho tamanho = new Tamanho();
				
				tamanho.setId(rs.getInt("idtamanho"));
				tamanho.setTamanho(rs.getString("tamanho"));
				
				tamanhos.add(tamanho);
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return tamanhos;
	}
	
	
	
	public Tamanho searchById(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Tamanho tamanho = new Tamanho();

		try {
			stmt = con.prepareStatement("SELECT * FROM tamanho where idtamanho=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				tamanho.setId(rs.getInt("idtamanho"));
				tamanho.setTamanho(rs.getString("tamanho"));
			}

		} catch (SQLException ex) {
			throw ex;
		} finally {
			Conexao.closeConnetion(con, stmt, rs);
		}

		return tamanho;

	}
	
	
	
}
