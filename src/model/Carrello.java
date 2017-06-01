package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe che realizza un carrello. Un carrello è univoco per ogni cliente e contiene un riferimento al cliente stesso
 * ed una lista di Dischi che il cliente intende acquistare. 
 * Classe realizzata secondo il pattern Iterator (vedere metodo iterable)
 *
 */

public class Carrello implements Iterable<Disco>, Serializable{

	private Cliente cliente;			//Cliente del carrello	
	private List<Disco> acquisti;		//Lista di acquisti
	
	/**
	 * Costruttore che costruisce un carrello vuoto
	 * @param cliente Cliente possessore del carrello spesa
	 */
	public Carrello(Cliente cliente){
	
		this.cliente = cliente;
		this.acquisti = new ArrayList<>();
	}
	
	/**
	 * Metodo che consente l'iterazione del carrello sui dischi che contiene
	 */
	@Override
	public Iterator<Disco> iterator() {
		return acquisti.iterator();
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	/**
	 * Metodo che aggiunge un disco da acquistare nel carrello
	 * @param disco Disco che il cliente intende acquistare
	 * @return true se il disco non è presente nel carrello (e lo aggiunge), false se è già stato inserito
	 */
	public boolean addDisco(Disco disco){
		if (acquisti.contains(disco))
			return false;
		acquisti.add(disco);
		return true;
	}
	
	/**
	 * Ritorna il disco nel carrello con indice i	
	 * @param index Indice del disco
	 * @return Disco 
	 */
	public Disco getDisco(int index){
		return acquisti.get(index);
	}
	
	public void removeDisco(Disco disco){
		acquisti.remove(disco);
	}
	
	/**
	 * Due carrelli sono uguali se appartengono allo stesso cliente
	 */
	public boolean equals(Object other){		
		
		if (other instanceof Carrello){
			Carrello c = (Carrello)other;
			
			return this.cliente.equals(c.cliente);

		}
		return false;
	}
}
