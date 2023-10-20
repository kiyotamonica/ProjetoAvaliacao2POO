package AC2;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class GerenciaCompra {
	private ArrayList<Compra> listaCompra;

	
	
	public void cadastra(Compra compra)
	{
		listaCompra.add(compra);
	}
	
	
	public GerenciaCompra() {
		this.listaCompra = new ArrayList<Compra>();
	}

	
	
	public String imprimir()
	{
		String infoLista = " ";
		
		for(int i = 0; i < this.listaCompra.size(); i++) {
			infoLista += "\n";
			infoLista += listaCompra.get(i).imprimir();
		}
		
		return infoLista;
		}

	public int buscaCompra(String doc) throws ParseException {
		int i =0;
		for(Compra compra : this.listaCompra) {
			if(doc.equalsIgnoreCase(compra.getDoc())) {
				 
				 i = listaCompra.indexOf(compra);
			}
		}
		return i;
	}
	
	public String buscaCompra1(String doc) throws ParseException {
		String retorno = "";
		for(Compra compra : this.listaCompra) {
			if(doc.equalsIgnoreCase(compra.getDoc())) {
				 retorno+=compra.imprimir();
				
			}
		}
		return retorno;
	}
	
	
	
	public void atualiza(int a, double valor) {
		listaCompra.get(a).setValorPago(  listaCompra.get(a).getValorPago()+valor     );
		JOptionPane.showMessageDialog(null, "Valor abatido com sucesso\n Novo valor pago ate momento: "+listaCompra.get(a).getValorPago());
		
	}
	
	public String comprasNaoPagas() {
		String retorno = "";
		for(Compra compra : this.listaCompra)
		{
			if(compra.getValorTotal()>compra.getValorPago()) {
				retorno+=compra.imprimir();			}
		}
		return retorno;
	}
	
	
	public String contasPagas() {
		String retorno="";

		if(this.listaCompra.size()<=10) {
			for(int i=0;i<this.listaCompra.size();i++) {
				if(this.listaCompra.get(i).getValorTotal()==this.listaCompra.get(i).getValorPago())
				{
					retorno+=this.listaCompra.get(i).imprimir();
				}
			}
		}
		else {
			for(int i=0;i<10;i++) {
				if(this.listaCompra.get(i).getValorTotal()==this.listaCompra.get(i).getValorPago())
				{
					retorno+=this.listaCompra.get(i).imprimir();
				}
			}
		}
		
		
		return retorno;
	}
		
		public String maisCara() {
			String retorno=this.listaCompra.get(0).imprimir();
			for(int i=1;i<this.listaCompra.size();i++)
			{
				if(this.listaCompra.get(i).getValorTotal()>this.listaCompra.get(0).getValorTotal())
				{
					retorno = this.listaCompra.get(i).imprimir();
				}
			}
			return retorno;
	}

		public String maisBarata() {
			String retorno=this.listaCompra.get(0).imprimir();
			for(int i=1;i<this.listaCompra.size();i++)
			{
				if(this.listaCompra.get(i).getValorTotal()<this.listaCompra.get(0).getValorTotal())
				{
					retorno = this.listaCompra.get(i).imprimir();
				}
			}
			return retorno;
	}
		
	public ArrayList<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	@SuppressWarnings("deprecation")
	public String data() {
		LocalDate localDataAtual=null;
		LocalDate localDataMenosDozeMeses = null;
		 Date dataMenosDozeMeses = null;
		 String retorno="";
		double ValorTotalMes=0;
		
		 for(int j=0;j<12;j++)
		 {
			 localDataAtual=LocalDate.now(); //pega a data atual do servidor 
			 localDataMenosDozeMeses=localDataAtual.minusMonths(j); //pega data atual do servido menos j numeros de menos 
			 dataMenosDozeMeses = Date.from(localDataMenosDozeMeses.atStartOfDay(ZoneId.systemDefault()).toInstant()); //converte de LocalDate pra Date
			 int mes=dataMenosDozeMeses.getMonth()+1; //guarda o mes depois da subtracao numa variavel
				 
				 retorno+="\nMes:" + String.valueOf(mes)+"\n"; 
				 
		 for(int i=0;i<this.listaCompra.size();i++) {//laco de repeticao do tamanho do array de compras
			 if(  this.listaCompra.get(i).getData().getMonth()==dataMenosDozeMeses.getMonth()  && this.listaCompra.get(i).getData().getYear() == dataMenosDozeMeses.getYear())  {
				/* No If compara se o mes da compra e igual ao menos data data atual menos j numero de vezes e tbm se o ano dessas duas datas sao iguais*/ 
				ValorTotalMes=ValorTotalMes+this.listaCompra.get(i).getValorTotal();//pega o valor da compra e vai somando e guarda numa variavel 
			 }
			 
			 }
		 retorno+="Valor das compras desse mes foi de "+ ValorTotalMes; //guardo o valor somado numa string para retorna para o programa
		 ValorTotalMes=0; //zera a variavel soma para que os valores nao se acumulem de um mes para o outro
		 }
		
		return retorno;
	}
	
	
	
	
}
 