package model;

import java.io.Serializable;
import java.sql.Date;

public class Band implements Artista, Serializable {
	private String nomeArte;
	private Generi genere;
	private Date dataNascita;

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
	public boolean equals(Object o){
		if (o instanceof Artista){
			Artista a = (Artista)o;
			
			return nomeArte.equals(a.getNomeArte());
		}
		return false;
	}
}
