package model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe che realizza una Band 
 *
 */

public class Band implements Artista, Serializable {
	private String nomeArte;
	private Generi genere;
	private Date dataNascita;
	
	/**
	 * Costruttore della Band
	 * @param nomeArte nome d'arte della band
	 * @param genere genere principale della band
	 * @param dataNascita data di creazione della band
	 */

	public Band(String nomeArte, Generi genere, Date dataNascita) {
		this.nomeArte = nomeArte;
		this.genere = genere;
		this.dataNascita = dataNascita;
	}
	
	
	@Override
	public String getNomeArte() {
		return nomeArte;
	}

	@Override
	public Generi getGenere() {
		return genere;
	}

	@Override
	public Date getDataNascita() {
		return dataNascita;
	}
	
	@Override
	public String toString(){
		return nomeArte;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Artista){
			Artista a = (Artista)o;
			
			return nomeArte.equals(a.getNomeArte());
		}
		return false;
	}
}
