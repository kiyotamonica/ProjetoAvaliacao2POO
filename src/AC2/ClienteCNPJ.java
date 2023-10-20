package AC2;

//Classe ClienteCPF herda os atributos tanto da classe cliente como os da classe Endereco
public class ClienteCNPJ extends Cliente {

	private String CNPJ;
	private String RazaoSocial;
	private int prazo;
	
	//Constructor passando todos os parametros, tantos os herdados como os da classe atual 
	public ClienteCNPJ(String rua, int numero, String bairro, String CEP, String cidade, String estado, String nome,
			String data, String cnpj, String razao, int prazo) {
		super.setRua(rua);
		super.setNumero(numero);
		super.setBairro(bairro);
		super.setCEP(CEP);
		super.setCidade(cidade);
		super.setEstado(estado);
		super.setNome(nome);
		super.setDataCadastro(data);
		this.setCNPJ(cnpj);
		this.setRazaoSocial(razao);
		this.setPrazo(prazo);
		
	}
	
	public ClienteCNPJ() {
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
		retorna += "CNPJ do Cliente:" + this.getCNPJ() + "\n";
		retorna += "Razao Social " + this.getRazaoSocial() + "\n";
		retorna += "Prazo Maximo: " + this.getPrazo() + "\n";
		
		return retorna;
	}
	
	//getters e setters da classe 
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
}