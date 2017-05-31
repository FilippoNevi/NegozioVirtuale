package model;

public class PersonaleAutorizzato extends Utente {
	
	public PersonaleAutorizzato (String codiceFiscale, String username, String password) {
		
		this.codiceFiscale = codiceFiscale;
		this.username = username;
		this.password = password;
	}
	
	public static class PersonaleAutorizzatoBuilder{
		private PersonaleAutorizzato personale;
		
		public PersonaleAutorizzatoBuilder(String codiceFiscale, String username, String password){
			personale = new PersonaleAutorizzato(codiceFiscale, username, password);
		}
		
		public PersonaleAutorizzatoBuilder setNome(String nome){
			personale.nome = nome;
			return this;
		}
		
		public PersonaleAutorizzatoBuilder setCognome(String cognome){
			personale.cognome = cognome;
			return this;
		}
		
		public PersonaleAutorizzatoBuilder setResidenza(String residenza){
			personale.residenza = residenza;
			return this;
		}
		
		public PersonaleAutorizzatoBuilder setTelefonoCasa(String telefonoCasa){
			personale.telefonoCasa = telefonoCasa;
			return this;
		}
		
		public PersonaleAutorizzatoBuilder setCellulare(String cellulare){
			personale.cellulare = cellulare;
			return this;
		}
		
		public PersonaleAutorizzato build(){
			return personale;
		}
		
	}
}
