package AC2;

public abstract class Endereco { //Classe Endereco contendo seus atributos 
	
	 private String rua;
	 private int numero;
	 private String bairro;
	 private String CEP;
	 private String cidade;
	 private String estado;
	
	 
	

	 public Endereco(String rua, int numero, String bairro, String cep, String cidade, String estado) {
		
	}

	 public Endereco()
	 {
		 
	 }


	 
	public abstract String paraString();
	

		
	
	//getters e setters da classe 
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cep) {
		CEP = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
