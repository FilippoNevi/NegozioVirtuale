package model;

public abstract class Utente {
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
}
