package model;

import java.sql.Date;
/**
 * 
 * Interfaccia che astrae le funzioni principali che accomunano tutti gli artisti (Musicisti e non)
 *
 */

public interface Artista{
	
	/**
	 * Funzione che ritorna il nome d'arte dell'artista
	 * @return il nome d'arte
	 */
	public String getNomeArte();
	
	/**
	 * Funzione che ritorna il genere principare dell'artista
	 * @return il genere
	 */
	public Generi getGenere();
	
	/**
	 * Funzione che restituisce la data (sql.Date) di nascita dell'artista
	 * @return data di nascita
	 */
	public Date getDataNascita();
}
