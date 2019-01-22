package br.com.projetofinal.model;

public class Venda {
	
	
	
	private int id,  id_itemVenda;
	
	private Double precoTotal;
    
    private ItemVenda itemVenda = new ItemVenda();
    
    private String data_compra;
    
    private String numeroMesa;
    
    
    public Venda() {
    	
    }

    
    
    


    public void setId_itemVenda(int id_itemVenda) {
		this.id_itemVenda = id_itemVenda;
	}





	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public Double getPrecoTotal() {
		return precoTotal;
	}





	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}





	public String getData_compra() {
		return data_compra;
	}





	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}





	public String getNumeroMesa() {
		return numeroMesa;
	}





	public void setNumeroMesa(String numeroMesa) {
		this.numeroMesa = numeroMesa;
	}





	public int getId_itemVenda() {
		return id_itemVenda;
	}





	public ItemVenda getItemVenda() {
		return itemVenda;
	}





	public Venda(int id, int id_itemVenda, Double precoTotal, ItemVenda itemVenda, String data_compra,
			String numeroMesa) {
		super();
		this.id = id;
		this.id_itemVenda = id_itemVenda;
		this.precoTotal = precoTotal;
		this.itemVenda = itemVenda;
		this.data_compra = data_compra;
		this.numeroMesa = numeroMesa;
	}




	
    
	
    
    
    
	
	

}
