package AC2;

import java.text.ParseException;

public class Produto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private double preco;
	
	
	public Produto ( int codigo, String nome, String descricao, double preco) {
		
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}
	
	public Produto() {
		
	}
	public boolean vencimento() throws ParseException {
		return false;
	}
	
	public String imprimir() throws ParseException {
		String info = "";
		
		info += "\nCodigo do Produto: " + this.getCodigo();
		info += "\nNome do produto: " + this.getNome();
		info += "\nPreco unitario: " + this.getPreco();
		info += "\nDescricao: "+this.getDescricao();
				
	
		
		return info;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}