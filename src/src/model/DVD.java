package model;

import java.util.List;

public class DVD extends Disco {

	
	public DVD(String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentoSuonato> strumenti) {
		
		super(titolo, tracce, fotografie, prezzo, rilascio, titolare, descrizione, genere, strumenti);
	}
}
