package model;

import java.util.List;

public class CD extends Disco {
	
	
	public CD(String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentoSuonato> strumenti) {
		
		super(titolo, tracce, fotografie, prezzo, rilascio, titolare, descrizione, genere, strumenti);
	}
}
