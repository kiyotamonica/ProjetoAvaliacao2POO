package AC2;

public abstract class Cliente extends Endereco { // Classe cliente herdando os atributos da classe Endereco 
	
	private String nome;
	private String dataCadastro;
	
	//Constructor com os atributos tanto da classe endereco como os da classe cliente
	public Cliente(String rua,int numero,String bairro,String CEP, String cidade, String estado,String nome, String data ) 
	{
		super(rua, numero, bairro, CEP, cidade, estado);
		this.setNome(nome);
		this.setDataCadastro(data);
		
	}
	 public Cliente()
	 {
		 
	 }


	@Override
	 public abstract String paraString();
	
	
	
	
	//getters e setters da classe 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
