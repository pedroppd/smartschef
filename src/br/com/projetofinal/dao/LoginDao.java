package br.com.projetofinal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projetofinal.conexao.Conexao;
import br.com.projetofinal.model.Login;

public class LoginDao {
	
	public void add(Login login) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into login (login, senha) values (?,?)");
			stmt.setString(1, login.getLogin());
			stmt.setString(2, login.getSenha());
			stmt.execute();
		}catch(Exception ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt);
		}
	}
	
	public boolean autenticacao(String login, String senha) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement stmt = null;
	    ResultSet rs=null;
	    boolean check = false;
		
		try {
			 stmt = con.prepareStatement("SELECT * FROM login WHERE login=? AND senha=?");
	         stmt.setString(1, login);
	         stmt.setString(2, senha);
	         
	         rs=stmt.executeQuery();
	         
	         if (rs.next()) {
	             check = true;
	         }
			
		}catch(Exception ex) {
			throw ex;
		}finally {
			Conexao.closeConnetion(con, stmt, rs);
		}
		return check;
	}
	
	
	
	
	
	
	

}
