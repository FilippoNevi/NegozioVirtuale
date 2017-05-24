package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StrumentoSuonato implements Serializable{
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

	public String getStrumento() {
		return strumento;
	}

	public void setStrumento(String strumento) {
		this.strumento = strumento;
	}

	
}
