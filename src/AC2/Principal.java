package AC2;
import java.awt.HeadlessException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws HeadlessException, ParseException, IOException {
int opcao = 0;
		
		GerenciaCliente gerCliente = new GerenciaCliente();
		GerenciaProduto gerProduto = new GerenciaProduto();
		GerenciaItemComprado gerItem = new GerenciaItemComprado();
		GerenciaCompra gerCompra = new GerenciaCompra();
		Texto auxTexto = new Texto();
		
		
		 auxTexto.importar("C:\\Users\\edubn\\OneDrive\\Documentos\\Eclipse\\AC2_1\\BaseDados\\Clientes.txt");
		for(int i=0;i<50;i+=10) {
			String rua = auxTexto.getLista().get(i);
			int numero = Integer.parseInt(auxTexto.getLista().get(i+1));
			String bairro = auxTexto.getLista().get(i+2);
			String cep = auxTexto.getLista().get(i+3);
			String cidade = auxTexto.getLista().get(i+4);
			String estado = auxTexto.getLista().get(i+5);
			String nome = auxTexto.getLista().get(i+6);
			String data = auxTexto.getLista().get(i+7);
			String cpf = auxTexto.getLista().get(i+8);
			int parcelas = Integer.parseInt(auxTexto.getLista().get(i+9));
			ClienteCPF cliente = new ClienteCPF(rua,numero,bairro,cep,cidade,estado,nome,data,cpf,parcelas);
			gerCliente.cadastrarCliente(cliente);
		}
		 auxTexto.limpaArray();
		 
		auxTexto.importar("C:\\Users\\edubn\\OneDrive\\Documentos\\Eclipse\\AC2_1\\BaseDados\\Produtos.txt");
		 for(int i = 0;i<25;i+=5)
		 {
			 int codigo = Integer.parseInt(auxTexto.getLista().get(i));
			 String nome = auxTexto.getLista().get(i+1);
			 String descricao = auxTexto.getLista().get(i+2);
			 double preco = Double.parseDouble(auxTexto.getLista().get(i+3));
			 String dataValidade = auxTexto.getLista().get(i+4);
			 ProdutoPrecivel produto = new ProdutoPrecivel (codigo, nome, descricao,preco,dataValidade);
				gerProduto.cadastrarProduto(produto);
		 }
		 auxTexto.limpaArray();
		 
		 auxTexto.importar("C:\\Users\\edubn\\OneDrive\\Documentos\\Eclipse\\AC2_1\\BaseDados\\Compras.txt");
		for(int i=0;i<25;i+=5) {
		 String nome=auxTexto.getLista().get(i);
		 int qtd = Integer.parseInt(auxTexto.getLista().get(i+1));
		 double preco = gerProduto.buscaPrecoUnitario(nome);
		 double valorTotal= qtd*preco;
			ItemComprado itemComprado1 = new ItemComprado(qtd,nome,preco,valorTotal);
			gerItem.cadastrar(itemComprado1);
			double ValorTotaldaCompra = gerItem.Valortotal();
			String doc = auxTexto.getLista().get(i+2);
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = formato.parse(auxTexto.getLista().get(i+3)); 
			
			double valorPago = Double.parseDouble(auxTexto.getLista().get(i+4));
			Compra compra = new Compra(ValorTotaldaCompra,data,valorPago,doc,gerItem.getListaItem());
			gerCompra.cadastra(compra);
			gerItem.limpaArray();
		}
		 auxTexto.limpaArray();
		 
		JOptionPane.showMessageDialog(null,"      Organizações Tabajara\nSistema de controle de compras.");
		
		
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,"\n1. Cadastro de Clientes."
					+ "\n2. Deletar cliente (Por CPF ou CNPJ)."
					+ "\n3. Deletar cliente pelo nome."
					+ "\n4. Cadastrar produto."
					+ "\n5. Efetuar compra."
					+ "\n6. Atualizar status de pagamento"
					+ "\n7. Relatorios"
					+ "\n8. Sair"
					+ "\n\nDigite a opcao desejada: "));
			
			
			switch(opcao) {
			case 1:
				int opPessoa = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja cadastrar uma PJ ou PF?\n1. PJ\n2. PF"));
					
				if(opPessoa == 1) {
					String nome = JOptionPane.showInputDialog("Nome fantasia do cliente ");
					String cnpj = JOptionPane.showInputDialog("Digite o CNPJ do cliente: ");
					String razao =JOptionPane.showInputDialog("Digite a Razao Social do clinete: ");
					int prazo = Integer.parseInt(JOptionPane.showInputDialog("Digite o prazo maximo: "));
					String data = JOptionPane.showInputDialog("Data de Cadastro (dd/mm/aaaa)");
					String rua = JOptionPane.showInputDialog("Digite a rua do endereco: ");
					int numero =Integer.parseInt(JOptionPane.showInputDialog("Numero: "));
					String bairro = JOptionPane.showInputDialog("Digite o bairro: ");
					String cep = JOptionPane.showInputDialog("Digite o cep: ");
					String cidade = JOptionPane.showInputDialog("Digite a cidade: ");
					String estado = JOptionPane.showInputDialog("Digite o estado: ");
					
					ClienteCNPJ cliente = new ClienteCNPJ(rua, numero, bairro, cep, cidade, estado, nome, data,cnpj,razao,prazo);
					gerCliente.cadastrarCliente(cliente);
					
					JOptionPane.showMessageDialog(null, cliente.paraString());
					
	
					
					
				}
				
				else if(opPessoa == 2) {
					String nome = JOptionPane.showInputDialog("Nome completo do cliente: ");
					String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente: ");
					int qtdParcelas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de parcelas:"));
					String data = JOptionPane.showInputDialog("Data de Cadastro (dd/mm/aaaa)");
					String rua = JOptionPane.showInputDialog("Digite a rua do endereco: ");
					int numero =Integer.parseInt(JOptionPane.showInputDialog("Numero: "));
					String bairro = JOptionPane.showInputDialog("Digite o bairro: ");
					String cep = JOptionPane.showInputDialog("Digite o cep: ");
					String cidade = JOptionPane.showInputDialog("Digite a cidade: ");
					String estado = JOptionPane.showInputDialog("Digite o estado: ");
				
					ClienteCPF cliente = new ClienteCPF(rua,numero,bairro,cep,cidade,estado,nome,data,cpf,qtdParcelas);
					gerCliente.cadastrarCliente(cliente);
					
					
					JOptionPane.showMessageDialog(null, cliente.paraString());
					
					 
				}
				break;
			case 2:
				String aux = JOptionPane.showInputDialog("Digite o documento do cliente que quer deletar(CPF ou CNPJ:  ");
				gerCliente.deletaDOC(aux);
				break;
			case 3:
			String aux1 = JOptionPane.showInputDialog("Digite o nome do cliente que quer deletar:  ");
				gerCliente.deleta(aux1);
				break;
				
			case 4:
				int opProduto=Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja cadastrar um produto nao perecivel ou um perecivel\n1. Nao perecivel\n2. Perecivel"));
				
				if (opProduto==1) {
				int  codigoProduto =  Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
				String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
				String descricao = JOptionPane.showInputDialog("Digite a descricao do produto:");
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco unitario do produto:"));				
				
				Produto produto = new Produto(codigoProduto, nomeProduto, descricao,preco);
				gerProduto.cadastrarProduto(produto);
				
		
				
				}
				
				if(opProduto == 2) {
					int  codigoProduto =  Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
					String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
					String descricao = JOptionPane.showInputDialog("Digite a descricao do produto:");
					double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco unitario do produto:"));
					String dataValidade = JOptionPane.showInputDialog("Insira a data de validade(dd/mm/aaaa): ");
					
					ProdutoPrecivel produto = new ProdutoPrecivel (codigoProduto, nomeProduto, descricao,preco,dataValidade);
					gerProduto.cadastrarProduto(produto);
			
					
				}
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, gerProduto.imprimir());
				String opCompra=null;
				int op1=0;
				
				
				do {
					
					String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
					int qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto desejado:"));
					double preco = gerProduto.buscaPrecoUnitario(nome);
					double valorTotal= qtd*preco;
					ItemComprado itemComprado = new ItemComprado(qtd,nome,preco,valorTotal);
					gerItem.cadastrar(itemComprado);
					
					
					JOptionPane.showMessageDialog(null, itemComprado.imprimir());
					
					op1=JOptionPane.showConfirmDialog(null, "Deseja continuar a compra?");
					
				}while(op1==0);
					
				
					JOptionPane.showMessageDialog(null, gerItem.imprimir(),"Carrinho",JOptionPane.PLAIN_MESSAGE);
				
				
					double ValorTotaldaCompra = gerItem.Valortotal();
					String doc = JOptionPane.showInputDialog("Digite o documento(CPF ou CNPJ)");
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
					Date data = formato.parse(JOptionPane.showInputDialog("Digite a data da compra (dd/mm/aaaa)")); 
					
					double valorPago = Double.parseDouble(JOptionPane.showInputDialog("Qual sera o valor a ser pago?" + "\nO valor total da compra foi de: " + ValorTotaldaCompra));
					Compra compra = new Compra(ValorTotaldaCompra,data,valorPago,doc,gerItem.getListaItem());
					gerCompra.cadastra(compra);
					gerItem.limpaArray();
					JOptionPane.showMessageDialog(null, compra.imprimir(),"Compra concluida", JOptionPane.PLAIN_MESSAGE);
				break;
			
			case 6:
				String docAux= JOptionPane.showInputDialog("Digite o documento da compra: ");
				int i =gerCompra.buscaCompra(docAux);
				double novoValor = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja abater da compra"));
				gerCompra.atualiza(i, novoValor);
				break;
				
			case 7:
				int opRelatorio= Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione a opcao desejada:\n1. Relação de todos os Clientes que possuem o nome iniciado por uma determinada sequência de caracteres"
		                + "\n2. Relaçao de todos os Produtos."
		                + "\n3. Busca um produto pelo nome"
		                + "\n4. Relação de produtos pereciveis e com data de validade vencida."
		                + "\n5. Relação de todas as compras."
		                + "\n6. Busca de uma compra pelo número do documento."
		                + "\n7. Relação de todas as compras que não foram pagas ainda."
		                + "\n8. Relação das 10 últimas compras pagas."
		                + "\n9. Apresentação das informações da compra mais cara."
		                + "\n10. Apresentacao das informacoes da compra mais barata."
		                + "\n11. Relacao do valor total de compras feitas em cada mes nos ultimos 12 meses."));
				
				if (opRelatorio==1) {
					String seq = JOptionPane.showInputDialog("Digite a sequencia de caracteres:  ");
					JOptionPane.showMessageDialog(null,gerCliente.BuscaClienteSeq(seq));
				}
				if (opRelatorio==2) {
					JOptionPane.showMessageDialog(null,gerProduto.imprimir());
				}
				if (opRelatorio==3) {
					String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
					JOptionPane.showMessageDialog(null, gerProduto.buscaProduto(nomeProduto));
                }	
				if(opRelatorio==4) {
					JOptionPane.showMessageDialog(null, gerProduto.buscaProdutoVencido());
				}
				if(opRelatorio==5) {
					JOptionPane.showMessageDialog(null, gerCompra.imprimir());
				}
				if(opRelatorio==6)	{
					String docAux1= JOptionPane.showInputDialog("Digite o documento da compra: ");
					JOptionPane.showMessageDialog(null, gerCompra.buscaCompra1(docAux1));
				}
				if(opRelatorio==7) {
					JOptionPane.showMessageDialog(null,gerCompra.comprasNaoPagas());
				}
				if(opRelatorio==8) {
					JOptionPane.showMessageDialog(null, gerCompra.contasPagas());
				}
				if(opRelatorio==9) {
					JOptionPane.showMessageDialog(null, gerCompra.maisCara());
				}
				if(opRelatorio==10)
				{
					JOptionPane.showMessageDialog(null, gerCompra.maisBarata());
				}
				if(opRelatorio==11) {
					JOptionPane.showMessageDialog(null,gerCompra.data());
				}
				
				break;
			}
		}while(opcao != 8); 
	}
}