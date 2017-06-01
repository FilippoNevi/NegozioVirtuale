package model;

import java.io.Serializable;

/**
 * Classe astratta che realizza le funzioni comuni a tutti gli Utenti memorizzati nella struttura dati.
 *
 */
public abstract class Utente implements Serializable{
	
	protected String codiceFiscale;
	protected String username;
	protected String password;
	protected String nome;
	protected String cognome;
	protected String residenza;
	protected String telefonoCasa;
	protected String cellulare;
		
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
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

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Due Utenti sono uguali se hanno lo stesso codice fiscale, o se hanno stesso username
	 */
	public boolean equals(Object other){
		
		if (other instanceof Utente){
			Utente utente = (Utente)other;
			
			return codiceFiscale.equalsIgnoreCase(utente.codiceFiscale) || username.equalsIgnoreCase(utente.username);
		}
		return false;
		
	}
}
