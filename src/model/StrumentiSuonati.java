package model;

import java.util.List;

public class StrumentiSuonati {
	private Musicista musicista;
	private List<String> strumenti;
	
	public StrumentiSuonati (Musicista musicista, List<String> strumenti) {
		this.musicista = musicista;
		this.strumenti = strumenti;
	}
}
