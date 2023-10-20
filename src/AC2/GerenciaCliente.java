package AC2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciaCliente {
	
	private ArrayList<Cliente> listaClientes; 
	

	
	public GerenciaCliente() {
		this.listaClientes = new ArrayList<Cliente>(); //cria uma array list do tipo cliente 
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void cadastrarCliente(Cliente cliente) {
		
		listaClientes.add(cliente); //adiciona um elemento na array list
	}
	
	public String paraString() {
		
		String Lista = "";
		
		for(int i = 0; i < this.listaClientes.size(); i++) {
			
			Lista += listaClientes.get(i).paraString();
			Lista += "\n";
		}
		
		return Lista;
	}
	
	public GerenciaCliente BuscaCliente(String nome) //metodo para encontrar cliente pelo nome
	{
		
		GerenciaCliente encontrado = new GerenciaCliente(); //cria uma arraylist do tipo gerenciacliente 
		
		for(Cliente cliente: this.listaClientes) //laco de repeticao para cada objeto do tipo cliente 
		{
			if(nome.equalsIgnoreCase(cliente.getNome())) //compara o nome dos objetos com o parametro passado 
			{
				encontrado.cadastrarCliente(cliente); //adiciona o objeto encontrado a arraylist 
			}
		}
		return encontrado; //retorna a arraylist 
	}
	
	public void deleta(String nome) //metodo de deletar o cliente pelo nome 
	{
		GerenciaCliente encontrado = new GerenciaCliente(); //cria uma arraylist do tipo gerenciacliente 
		encontrado=this.BuscaCliente(nome); //aplica o metodo BuscaCliente e guarda na arraylista criada 
		
		
		/* Abaixo primeiro verifica se o tamnaho da arraylist de objetos encontrados e maior que um
		 * se sim, guardas as informacoes em forma de string e mostra pro usuario e pede o id de qual quer excluir
		 * se houver apenas um encontrado exclui direto o primeiro elemento da arraylist de encontrados */
		if( encontrado.getListaClientes().size()>1 ) { 
	
			
			
			String info = "Existe mais do que uma pessoa com o nome buscado. Digite o id da pessoa desejada (o id começa em 0).";
			
			for(Cliente cliente: this.listaClientes) {
				
				info += "\n-----------\n";
				info += cliente.paraString();
				info += "\n-----------\n";
			}
			
			
			
			String strId = JOptionPane.showInputDialog(info); 
			int id = Integer.parseInt(strId);	
			
			this.listaClientes.remove(id);
			JOptionPane.showMessageDialog(null, "Cliente deletado");
			
		}
		else{
			this.listaClientes.remove(0);
			JOptionPane.showMessageDialog(null, "Cliente deletado");
		}
		
	}
	
	
	public GerenciaCliente BuscaClienteDOC(String doc) //metodo para encontrar cliente pelo nome
	{
		
		GerenciaCliente encontrado = new GerenciaCliente();//cria uma arraylist do tipo gerenciacliente 
		ClienteCPF aux = new ClienteCPF();
		ClienteCNPJ aux1 = new ClienteCNPJ();
		
		for(Cliente cliente: this.listaClientes) //laco de repeticao para cada objeto do tipo cliente 
		{
			if(doc.equalsIgnoreCase(aux.getCPF()) || doc.equalsIgnoreCase(aux1.getCNPJ())) //compara o doc dos objetos com o parametro passado 
			{
				encontrado.cadastrarCliente(cliente); //adiciona o objeto encontrado a arraylist 
			}
		}
		return encontrado; //retorna a arraylist 
	

}
	public void deletaDOC(String doc) //metodo de deletar o cliente pelo nome 
	{
		GerenciaCliente encontrado = new GerenciaCliente(); //cria uma arraylist do tipo gerenciacliente 
		encontrado=this.BuscaCliente(doc); //aplica o metodo BuscaCliente e guarda na arraylista criada 
		
		
		/* Abaixo primeiro verifica se o tamnaho da arraylist de objetos encontrados e maior que um
		 * se sim, guardas as informacoes em forma de string e mostra pro usuario e pede o id de qual quer excluir
		 * se houver apenas um encontrado exclui direto o primeiro elemento da arraylist de encontrados */
		if( encontrado.getListaClientes().size()>1 ) { 
	
			
			
			String info = "Existe mais do que uma pessoa com o documento buscado. Digite o id da pessoa desejada (o id começa em 0).";
			
			for(Cliente cliente: this.listaClientes) {
				
				info += "\n-----------";
				info += cliente.paraString();
				info += "\n-----------";
			}
			
			
			
			String strId = JOptionPane.showInputDialog(info); 
			int id = Integer.parseInt(strId);	
			
			this.listaClientes.remove(id);
			
		}
		else{
			this.listaClientes.remove(0);
		}
		
	}
	
	public String BuscaClienteSeq(String nome) //metodo para encontrar cliente pelo nome
	{
		
		GerenciaCliente encontrado = new GerenciaCliente(); //cria uma arraylist do tipo gerenciacliente 
		
		for(Cliente cliente: this.listaClientes) //laco de repeticao para cada objeto do tipo cliente 
		{
			if(cliente.getNome().startsWith(nome)) //compara o nome dos objetos com o parametro passado 
			{
				encontrado.cadastrarCliente(cliente); //adiciona o objeto encontrado a arraylist 
			}
		}
		 String saida =encontrado.paraString();
		
		
		return saida; 
	}
	
	
	
}
