package model;

/**
 * Classe che realizza un amministratore del sistema. 
 * Segue il pattern Template: estende la superclasse Utente ed aggiunge funzionalità 
 * Viene costruita secondi il pattern Builder. Tre attributi sono obbligatori: CF, username e password. Gli altri sono opzionali
 *
 */

public class PersonaleAutorizzato extends Utente {
	
	/**
	 * Costruttore che crea un nuovo PersonaleAutorizzato
	 * @param codiceFiscale CF
	 * @param username Username
	 * @param password Password
	 */
	
	public PersonaleAutorizzato (String codiceFiscale, String username, String password) {
		
		this.codiceFiscale = codiceFiscale;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Classe statica che realizza il builder del PersonaleAutorizzato
	 * @author eros
	 *
	 */
	public static class PersonaleAutorizzatoBuilder{
		private PersonaleAutorizzato personale;
		
		/**
		 * Crea un nuovo amministratore
		 * @param codiceFiscale CF
		 * @param username Username 
		 * @param password Password
		 */
		public PersonaleAutorizzatoBuilder(String codiceFiscale, String username, String password){
			personale = new PersonaleAutorizzato(codiceFiscale, username, password);
		}
		
		/**
		 * Metodo che imposta il nome dell'amministratore
		 * @param nome Nome amministratore
		 * @return PersonaleAutorizzatoBuilder
		 */
		public PersonaleAutorizzatoBuilder setNome(String nome){
			personale.nome = nome;
			return this;
		}
		
		/**
		 * Metodo che imposta il cognome dell'amministratore
		 * @param cognome Cognome dell'amministratore
		 * @return PersonaleAutorizzatoBuilder
		 */
		public PersonaleAutorizzatoBuilder setCognome(String cognome){
			personale.cognome = cognome;
			return this;
		}
		
		/**
		 * Metodo che imposta la residenza dell'amministratore
		 * @param residenza Residenza dell'amministratore 
		 * @return PersonaleAutorizzatoBuilder
		 */
		public PersonaleAutorizzatoBuilder setResidenza(String residenza){
			personale.residenza = residenza;
			return this;
		}
		
		/**
		 * Metodo che imposta il telefono di casa dell'amministratore
		 * @param telefonoCasa Telefono di casa dell'amministratore
		 * @return PersonaleAutorizzatoBuilder
		 */
		public PersonaleAutorizzatoBuilder setTelefonoCasa(String telefonoCasa){
			personale.telefonoCasa = telefonoCasa;
			return this;
		}
		
		/**
		 * Metodo che imposta il cellulare dell'amministratore
		 * @param cellulare Cellulare dell'amministratore
		 * @return PersonaleAutorizzatoBuilder
		 */
		public PersonaleAutorizzatoBuilder setCellulare(String cellulare){
			personale.cellulare = cellulare;
			return this;
		}
		
		
		/**
		 * Metodo che costruisce il PersonaleAutorizzato con tutti gli attributi impostati
		 * @return
		 */
		public PersonaleAutorizzato build(){
			return personale;
		}
		
	}
}
