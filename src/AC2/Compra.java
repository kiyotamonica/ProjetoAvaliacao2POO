package AC2;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Compra {
	
	private UUID identificacao;
	private double valorTotal;
	private Date data;
	private double valorPago;
	private String doc;
	private ArrayList<ItemComprado> ItensComprado;
	
	
	
	
	
	public Compra( double valorTotal, Date data, double valorPago, String doc,
			ArrayList<ItemComprado> itensComprado) {
		
		this.identificacao = UUID.randomUUID();
		this.valorTotal = valorTotal;
		this.data = data;
		this.valorPago = valorPago;
		this.doc = doc;
		ItensComprado = itensComprado;
	}
	public Compra()
	{
		
	}
	
	public String imprimir()
	{
		String retorno="";
		retorno +="\nIdentificacao: " + this.getIdentificacao();
		retorno +="\n Documento: " +this.getDoc();
		retorno +="\n Data da compra: " +this.getData();
		retorno +="\n Valor Total da compra: " +this.getValorTotal();
		retorno +="\n Valor pago ate o momento: " +this.getValorPago();
		
		for(ItemComprado item:ItensComprado)
		{
			retorno+=item.imprimir();
		}
		 return retorno;
		}
	
	
	
	
	public UUID getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(UUID identificacao) {
		this.identificacao = identificacao;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public ArrayList<ItemComprado> getItensComprado() {
		return ItensComprado;
	}
	public void setItensComprado(ArrayList<ItemComprado> itensComprado) {
		ItensComprado = itensComprado;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	
}

