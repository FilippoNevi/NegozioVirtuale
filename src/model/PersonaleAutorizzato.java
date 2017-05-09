package model;

public class PersonaleAutorizzato extends Utente {
	
	public PersonaleAutorizzato (String codiceFiscale, String username, String password, String nome, String cognome, 
			String residenza, String telefonoCasa, String cellulare) {
		
		super(codiceFiscale, username, password, nome, cognome, 
				residenza, telefonoCasa, cellulare);
	}
}
