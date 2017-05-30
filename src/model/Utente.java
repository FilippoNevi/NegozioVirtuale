package model;

import java.io.Serializable;

public abstract class Utente implements Serializable{
	
	private String codiceFiscale;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String residenza;
	private String telefonoCasa;
	private String cellulare;
	
	public Utente(String codiceFiscale, String username, String password, String nome, String cognome, 
			String residenza, String telefonoCasa, String cellulare) {
		
		this.codiceFiscale = codiceFiscale;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.residenza = residenza;
		this.telefonoCasa = telefonoCasa;
		this.cellulare = cellulare;		
	}
	
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getTelefonoCasa() {
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		this.telefonoCasa = telefonoCasa;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	public boolean equals(Object other){
		
		if (other instanceof Utente){
			Utente utente = (Utente)other;
			
			return codiceFiscale.equalsIgnoreCase(utente.codiceFiscale) || username.equalsIgnoreCase(utente.username);
		}
		return false;
		
	}
}
