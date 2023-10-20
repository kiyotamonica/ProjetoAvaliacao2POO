package AC2;

import java.util.ArrayList;

public class GerenciaItemComprado {
	private ArrayList <ItemComprado> listaItem;
	
	public GerenciaItemComprado()
	{
		this.listaItem = new ArrayList <ItemComprado>();
	}
	
	public void cadastrar (ItemComprado item)
	{
		this.listaItem.add(item);
	}

	
	public double Valortotal() {
		double retorno =0;
		for(ItemComprado item:this.listaItem)
		{
			retorno+=item.getValorTotal();
		}
		return retorno;
	}
	
	public String imprimir()//1
	{
		String infoLista = " ";
		
		for(int i = 0; i < this.listaItem.size(); i++) {
			infoLista += "\n";
			infoLista += listaItem.get(i).imprimir();
		}
		
		return infoLista;
		}
	
	public void limpaArray() {
		this.listaItem.clear();
	}
	
	
	public ArrayList<ItemComprado> getListaItem() {
		return listaItem;
	}

	public void setListaItem(ArrayList<ItemComprado> listaItem) {
		this.listaItem = listaItem;
	}
	
	
}
