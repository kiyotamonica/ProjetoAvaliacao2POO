package AC2;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciaProduto {
private ArrayList<Produto> listaProdutos;
	
	public GerenciaProduto() {
		this.listaProdutos = new ArrayList<Produto>();
	}
	
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
		
	}
	
	public String imprimir() throws ParseException {
		
		String infoLista = " ";
		
		for(int i = 0; i < this.listaProdutos.size(); i++) {
			infoLista += "\n";
			infoLista += listaProdutos.get(i).imprimir();
		}
		
		return infoLista;
		}
	
	public String buscaProduto(String nome) throws ParseException {
		String retorno="";
		for(Produto produto : this.listaProdutos) {
			if(nome.equalsIgnoreCase(produto.getNome())) {
				  retorno+=produto.imprimir();			}
		}
		return retorno;
	}
		public String buscaProdutoVencido() throws ParseException {
			String retorno="";
			for(Produto produto : this.listaProdutos) {
				if(produto.vencimento()==true) {
					 retorno+=produto.imprimir();				
					 retorno+="\n-----------\n";
				}
			}
		return retorno;
	}
		public double buscaPrecoUnitario(String nome) throws ParseException {
			double retorno = 0;
			for(Produto produto : this.listaProdutos) {
				if(nome.equalsIgnoreCase(produto.getNome())) {
					 retorno= produto.getPreco();  
				}
			}
			return retorno;
		}

	
	
}
	
	

