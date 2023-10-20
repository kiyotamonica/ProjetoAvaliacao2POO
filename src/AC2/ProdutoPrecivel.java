package AC2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ProdutoPrecivel extends Produto {
	
	private String dataValidade;
	
	
	public ProdutoPrecivel( int codigo, String nome, String descricao, double preco, String validade) {
		
		super.setCodigo(codigo);
		super.setNome(nome);
		super.setDescricao(descricao);
		super.setPreco(preco);
		this.setDataValidade(validade);
	}
	
	
	
	public ProdutoPrecivel() {
		
	}
	
	@Override
	public boolean vencimento() throws ParseException
	{
		boolean retorno = false;
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //seta o formata da data para dd/mm/yyyy
		Date data = formato.parse(this.getDataValidade()); //transforma string para tipo date
		LocalDate dataValidade = data.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();//transforma para o tipo LocalDate
		
		
		LocalDate dataAtual = LocalDate.now(); //cria uma variavel do tipo LocalDate com a data atual fornecida pelo sistema
		
		if(dataValidade.isBefore(dataAtual)) // compara se a data de validade e antes da data atual
				{ 
				retorno = true; //retorno = true significa que esta vencido
				}
	
	
		return retorno;
		
	}
	
	@Override
	public String imprimir() throws ParseException {
		
		String info = ""; 
		
		info += "\nCodigo do Produto: " + this.getCodigo();
		info += "\nNome do produto: " + this.getNome();
		info += "\nPreco unitario: " + this.getPreco();
		info += "\nDescricao: " + this.getDescricao();
		info += "\nData de validade: "	+ this.getDataValidade();
		boolean aux=this.vencimento();
		if(aux == false)
		{
			info+="\nProduto nao vencido";
		}
		else
		{
			info+="\nProduto vencido";
		}
		
		
		return info;
	}
	
	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}