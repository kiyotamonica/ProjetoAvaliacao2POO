package AC2;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Texto {
	private ArrayList<String> lista = new ArrayList<String>();

	public void importar(String endereco) throws IOException{
		FileReader fr = new FileReader(endereco);
		BufferedReader br = new BufferedReader(fr);
		
		while (br.ready())
		{
		    lista.add(br.readLine());
		}
	}
	
	public void limpaArray() {
		this.lista.clear();
	}
	
	public ArrayList<String> getLista() {
		return lista;
	}

	public void setLista(ArrayList<String> lista) {
		this.lista = lista;
	}
}
