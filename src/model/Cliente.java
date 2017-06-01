package model;

/**
 * Classe che realizza un Cliente. 
 * Segue il pattern Template: estende la superclasse Utente ed aggiunge funzionalità 
 * Viene costruita secondo il pattern Builder. Tre attributi sono obbligatori: CF, username e password. Gli altri sono opzionali
 *
 */
public class Cliente extends Utente{
	
	
	/**
	 * Costruttore che consente la creazione di un nuovo Cliente
	 * @param codiceFiscale CF del cliente
	 * @param username Username
	 * @param password Password
	 */
	public Cliente (String codiceFiscale, String username, String password) {
		
		this.codiceFiscale = codiceFiscale;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Classe statica che realizza il builder del cliente
	 *
	 */
	public static class ClienteBuilder{
		private Cliente cliente;
		
		/**
		 * Costruttore che riceve in input i tre parametri obbligatori
		 * @param codiceFiscale CF del cliente
		 * @param username Username
		 * @param password Password
		 */
		
		public ClienteBuilder(String codiceFiscale, String username, String password){
			cliente = new Cliente(codiceFiscale, username, password);
		}
		
		/**
		 * Imposta il nome del Cliente
		 * @param nome Nome del cliente
		 * @return ClienteBuilder 
		 */
		public ClienteBuilder setNome(String nome){
			cliente.nome = nome;
			return this;
		}
		
		/**
		 * Impsta il cognome del Cliente
		 * @param cognome Cognome del cliente
		 * @return ClienteBuilder
		 */
		public ClienteBuilder setCognome(String cognome){
			cliente.cognome = cognome;
			return this;
		}
		
		/**
		 * Imposta la residenza del Cliente
		 * @param residenza Residenza del cliente
		 * @return ClienteBuilder
		 */
		public ClienteBuilder setResidenza(String residenza){
			cliente.residenza = residenza;
			return this;
		}
		
		/**
		 * Imposta il telefono di casa del Cliente
		 * @param telefonoCasa Telefono di casa del cliente
		 * @return ClienteBuilder
		 */  
		public ClienteBuilder setTelefonoCasa(String telefonoCasa){
			cliente.telefonoCasa = telefonoCasa;
			return this;
		}
		
		/**
		 * Imposta il cellulare del Cliente
		 * @param cellulare Cellulare del cliente
		 * @retunr ClienteBuilder
		 */
		public ClienteBuilder setCellulare(String cellulare){
			cliente.cellulare = cellulare;
			return this;
		}
		
		/**
		 * Costruisce un nuovo cliente con i parametri impostati
		 * @retunr Il nuovo Cliente
		 */
		public Cliente build(){
			return cliente;
		}
	}
}
