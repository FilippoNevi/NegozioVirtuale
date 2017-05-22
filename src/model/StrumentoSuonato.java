package model;

import java.util.ArrayList;
import java.util.List;

public class StrumentoSuonato {
	private Musicista musicista;
	private String strumento;
	
	public StrumentoSuonato (Musicista musicista, String strumento) {
		this.musicista = musicista;
		this.strumento = strumento;
	}
	
	public Musicista getMusicista() {
		return musicista;
	}

	public void setMusicista(Musicista musicista) {
		this.musicista = musicista;
	}

	public String getStrumenti() {
		return strumento;
	}

	public void setStrumenti(String strumento) {
		this.strumento = strumento;
	}

	public boolean equals(Object other){
		if (other instanceof StrumentoSuonato){
			
			StrumentoSuonato o = (StrumentoSuonato)other;
			
			if (musicista.getNomeArte().equals(o.musicista.getNomeArte()))
				return true;
		}
		return false;
	}
}
