package model;

import java.util.ArrayList;
import java.util.List;

public class StrumentiSuonati {
	private Musicista musicista;
	private List<String> strumenti;
	
	public StrumentiSuonati (Musicista musicista, List<String> strumenti) {
		this.musicista = musicista;
		this.strumenti = strumenti;
	}
	
	public boolean equals(Object other){
		if (other instanceof StrumentiSuonati){
			
			StrumentiSuonati o = (StrumentiSuonati)other;
			
			if (musicista.getNomeArte().equals(o.musicista.getNomeArte()))
				return true;
		}
		return false;
	}
	
	public void add(String strumento){
		if (strumenti == null)
			strumenti = new ArrayList<>();
		strumenti.add(strumento);
	}
}
