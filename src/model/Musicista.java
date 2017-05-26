package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Classe che implementa un Musicista
 *
 */

public class Musicista implements Artista, Serializable{
	
	private String nomeArte;
	private Generi genere;
	private Date dataNascita;
	private List<String> strumenti;
	
	/**
	 * Costruttore che genera un nuovo musicista
	 * @param nomeArte nome d'arte del musicista
	 * @param genere genere principale del musicista
	 * @param dataNascita data in cui il musicista è nato
	 * @param strumenti lista dei principali strumenti suonati
	 */
	
	public Musicista(String nomeArte, Generi genere, Date dataNascita, List<String> strumenti) {
		this.nomeArte = nomeArte;
		this.genere = genere;
		this.dataNascita = dataNascita;
		this.strumenti = strumenti;
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

	/**
	 * Metodo che ritorna la lista degli strumenti suonati dall'artista
	 * @return strumenti strumenti suonati dal musicista
	 */
	public List<String> getStrumenti() {
		return strumenti;
	}
	
	@Override
	public boolean equals(Object other){
		if (other instanceof Artista){
			
			Artista a = (Artista)other;
			return nomeArte.equals(a.getNomeArte());
		}
		return false;
	}
}
