package br.com.projetofinal.model;

import java.io.Serializable;

public class Tamanho implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String tamanho;
	
	
	
	public Tamanho() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTamanho() {
		return tamanho;
	}



	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	@Override
	public String toString() {
		return "Tamanho [id=" + id + ", tamanho=" + tamanho + "]";
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
		Tamanho other = (Tamanho) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public Tamanho(int id, String tamanho) {
		super();
		this.id = id;
		this.tamanho = tamanho;
	}
	
	

	
}
