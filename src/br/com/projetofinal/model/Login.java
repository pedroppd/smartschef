package br.com.projetofinal.model;

import java.io.Serializable;

public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String login;
	
	private String senha;
	
	
	
	
	public Login() {
		
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	@Override
	public String toString() {
		return "Login [id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (id != other.id)
			return false;
		return true;
	}




	public Login(int id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	

}
