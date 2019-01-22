package br.com.projetofinal.model;

import java.io.Serializable;

public class Produto implements Serializable{
	
	




	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String nome;
	
	private Double preco;
	 
	private String imagem;
	
	private Categoria categoria = new Categoria();
	
	private String descricao;

	private Tamanho tamanho = new Tamanho();

	

	


	
	

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	

	public Produto() {
		
	}
	
	
	
	
	public Produto(int id, String nome, Double preco, String imagem, Categoria categoria, String descricao,
			Tamanho tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", imagem=" + imagem + ", categoria="
				+ categoria + ", descricao=" + descricao + ", tamanho=" + tamanho + "]";
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	
	
	

}
