package br.com.projetofinal.TestConexao;

import java.sql.Connection;

import br.com.projetofinal.conexao.Conexao;

public class TestConexao {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = Conexao.getConnection();
		
		if(con!=null) {
			System.out.println("Conectado com sucesso!");
		}else {
			System.out.println("Não foi possivel estabelecer a conexão!");
		}
	}

}
