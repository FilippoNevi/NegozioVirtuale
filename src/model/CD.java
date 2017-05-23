package model;

import java.sql.Date;
import java.util.List;

public class CD extends Disco {
	
	
	public CD(int id, String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentoSuonato> strumenti) {
		
		super(id, titolo, tracce, fotografie, prezzo, rilascio, titolare, descrizione, genere, strumenti);
	}
}
