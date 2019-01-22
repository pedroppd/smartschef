package br.com.projetofinal.model;

import java.io.Serializable;

public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id, idproduto;
	
	private Double precoParcial;
	
	private int quantidade;
	
	private Produto produto = new Produto();
	
	
	public ItemVenda() {
	
	}


	


	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getPrecoParcial() {
		return precoParcial;
	}


	public void setPrecoParcial(Double precoParcial) {
		this.precoParcial = precoParcial;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	

	public ItemVenda(Integer id, Double precoParcial, Integer quantidade, Produto produto) {
		super();
		this.id = id;
		this.precoParcial = precoParcial;
		this.quantidade = quantidade;
		this.produto = produto;
	}


	public Integer getIdproduto() {
		return idproduto;
	}


	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}


	@Override
	public String toString() {
		return "ItemVenda [id=" + id + ", idproduto=" + idproduto + ", precoParcial=" + precoParcial + ", quantidade="
				+ quantidade + ", produto=" + produto + "]";
	}





	
	
	
	
	

}
