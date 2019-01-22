package br.com.projetofinal.model;

import java.io.Serializable;

public class Categoria implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String categoria ="";
	
	
	
	public Categoria() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Categoria(int id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + categoria + "]";
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
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
