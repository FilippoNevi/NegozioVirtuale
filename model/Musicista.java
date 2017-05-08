package model;

import java.sql.Date;
import java.util.List;

public class Musicista implements Artista {
	
	private String nomeArte;
	private Generi genere;
	private Date dataNascita;
	private List<String> strumenti;
	
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

	public List<String> getStrumenti() {
		return strumenti;
	}
}
