package model;

import java.io.Serializable;

/**
 * Classe che rappresenta una entry del catalogo: associa ad ogni disco, il numero di pezzi presenti in magazzino
 *
 */

public class OccorrenzeDisco implements Serializable{
	
	private Disco disco;
	private int occorrenza;
	
	/**
	 * Crea una nuova occorrenza
	 * @param disco Disco 
	 * @param occorrenza Numero di pezzi del disco in magazzino 
	 */
	public OccorrenzeDisco(Disco disco, int occorrenza){
		this.disco = disco;
		this.occorrenza = occorrenza;
	}
	
	public Disco getDisco(){
		return disco;
	}
	
	public int getOccorrenza(){
		return occorrenza;
	}
	
	public void setOccorrenza(int occorrenza){
		this.occorrenza = occorrenza;
	}
}
