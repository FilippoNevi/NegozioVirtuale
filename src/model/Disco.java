package model;

import java.sql.Date;
import java.util.List;

public abstract class Disco {
	private int id;
	private String titolo;
	private List<String> tracce;
	private List<String> fotografie; 
	private float prezzo;
	private Date rilascio;
	private Artista titolare;
	private String descrizione;
	private Generi genere;
	private List<StrumentiSuonati> strumenti;
	
	public Disco(int id, String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentiSuonati> strumenti) {
		
		this.id = id;
		this.titolo = titolo;
		this.tracce = tracce;
		this.fotografie = fotografie;
		this.prezzo = prezzo;
		this.rilascio = rilascio;
		this.titolare = titolare;
		this.descrizione = descrizione;
		this.genere = genere;
		this.strumenti = strumenti;
	}
}

