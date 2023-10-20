package AC2;

public class ItemComprado {
	

	private int QtdeItens;
	private String nome;
	private double precoUnitario;
	private double valorTotal;
	
	
	public ItemComprado(int qtd, String nome, double preco, double valor) {
		
		this.setQtdeItens(qtd);
		this.setNome(nome);
		this.setPrecoUnitario(preco);
		this.setValorTotal(valor);
		
		
	}
	
	public String imprimir()
	{
		String imprime ="";
		imprime +="\nNome do produto: " +this.getNome();
		imprime +="\nQuantidade do produto: " + this.getQtdeItens();
		imprime +="\nPreco Unitario: "+ this.getPrecoUnitario();
		imprime +="\nValor Total do item pedido: " + this.getValorTotal();
		return imprime;
	}
	
	
	
	public int getQtdeItens() {
		return QtdeItens;
	}
	public void setQtdeItens(int qtdeItens) {
		QtdeItens = qtdeItens;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
