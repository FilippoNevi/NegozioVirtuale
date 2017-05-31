package model;

public class Cliente extends Utente{
	
public Cliente (String codiceFiscale, String username, String password) {
		
		this.codiceFiscale = codiceFiscale;
		this.username = username;
		this.password = password;
	}
	
	public static class ClienteBuilder{
		private Cliente cliente;
		
		public ClienteBuilder(String codiceFiscale, String username, String password){
			cliente = new Cliente(codiceFiscale, username, password);
		}
		
		public ClienteBuilder setNome(String nome){
			cliente.nome = nome;
			return this;
		}
		
		public ClienteBuilder setCognome(String cognome){
			cliente.cognome = cognome;
			return this;
		}
		
		public ClienteBuilder setResidenza(String residenza){
			cliente.residenza = residenza;
			return this;
		}
		
		public ClienteBuilder setTelefonoCasa(String telefonoCasa){
			cliente.telefonoCasa = telefonoCasa;
			return this;
		}
		
		public ClienteBuilder setCellulare(String cellulare){
			cliente.cellulare = cellulare;
			return this;
		}
		
		public Cliente build(){
			return cliente;
		}
	}
}
