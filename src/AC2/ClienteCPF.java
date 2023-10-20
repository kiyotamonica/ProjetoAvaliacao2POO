package AC2;

//Classe ClienteCPF herda os atributos tanto da classe cliente como os da classe Endereco
public class ClienteCPF extends Cliente {
	
	private String CPF;
	private int qtde;
	
	
	//Constructor passando todos os parametros, tantos os herdados como os da classe atual 
	public ClienteCPF(String rua, int numero, String bairro, String CEP, String cidade, String estado, String nome,String data,String cpf,int qtd) {
		
		super.setRua(rua);
		super.setNumero(numero);
		super.setBairro(bairro);
		super.setCEP(CEP);
		super.setCidade(cidade);
		super.setEstado(estado);
		super.setNome(nome);
		super.setDataCadastro(data);
		this.setCPF(cpf);
		this.setQtde(qtd);
	}
	
	public ClienteCPF() {
		
	}
	
	@Override
	public String paraString() //metodo para string que armazena todos os parametros herdados e da classe atual em unica String 
	{
		String retorna = "";
		retorna += "Rua: " + super.getRua() + "\n";
		retorna += "Numero: " + super.getNumero() +"\n";
		retorna += "Bairro: " + super.getBairro() + "\n";
		retorna += "CEP: " + super.getCEP() + "\n";
		retorna += "Cidade: " + super.getCidade() + "\n";
		retorna += "Estado: " +super.getEstado() + "\n";
		retorna += "Nome do Cliente: " + super.getNome() + "\n";
		retorna += "Data de cadastro: " + super.getDataCadastro() + "\n";
		retorna += "CPF do Cliente:" + this.getCPF() + "\n";
		retorna += "Quantida maxima de parcelas: " + this.getQtde() + "\n";
		
		return retorna;
		
		
	}


	//getters e setters da classe 
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
}
