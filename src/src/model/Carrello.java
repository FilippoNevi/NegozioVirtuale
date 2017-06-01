package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrello implements Iterable<Disco>, Serializable{

	private Cliente cliente;
	private List<Disco> acquisti;
	
	public Carrello(Cliente cliente){
	
		this.cliente = cliente;
		this.acquisti = new ArrayList<>();
	}

	@Override
	public Iterator<Disco> iterator() {
		return acquisti.iterator();
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public boolean addDisco(Disco disco){
		if (acquisti.contains(disco))
			return false;
		acquisti.add(disco);
		return true;
	}
	
	public Disco getDisco(int index){
		return acquisti.get(index);
	}
	public void removeDisco(Disco disco){
		acquisti.remove(disco);
	}
	public boolean equals(Object other){		//due carrelli sono uguali se appartengono allo stesso cliente
		
		if (other instanceof Carrello){
			Carrello c = (Carrello)other;
			
			return this.cliente.equals(c.cliente);

		}
		return false;
	}
}
