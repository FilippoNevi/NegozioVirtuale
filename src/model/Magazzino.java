package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Magazzino {
	
	private static final String URL = "jdbc:sqlite:DB/magazzino.db";
	private Connection c;
	
	public Magazzino(){
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(URL);
			
			Statement stmt = c.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS DISCO( " +
						   		"Id integer PRIMARY KEY AUTOINCREMENT, "
						   	  + "Titolo text, "
						   	  + "Prezzo real, "
						   	  + "Rilascio text, "
						   	  + "Titolare text, "
						   	  + "Descrizione text, "
						   	  + "Genere text, "
						   	  + "Strumenti integer, "
						   	  + "Tipologia text);";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS MUSICISTA( "
					+ "NomeArte text PRIMARY KEY, "
					+ "Genere text, "
					+ "DataNascita text, "
					+ "Strumenti integer);";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS UTENTE( "
					+ "CodiceFiscale text PRIMARY KEY, "
					+ "Username text, "
					+ "Password text, "
					+ "Nome text, "
					+ "Cognome text, "
					+ "Residenza text, "
					+ "TelefonoCasa text, "
					+ "Cellulare text, "
					+ "Autorizzazione integer);";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS TRACCE( "
					+ "IdDisco integer, "
					+ "NomeTraccia text, "
					+ "PRIMARY KEY(IdDisco, NomeTraccia));"; 
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS FOTOGRAFIE( "
					+ "IdDisco integer, "
					+ "Url text, "
					+ "PRIMARY KEY(IdDisco, Url));";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS STRUMENTI_SUONATI( "
					+ "Musicista text, "
					+ "Strumento text,"
					+ "PRIMARY KEY(Musicista, Strumento));";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS STRUMENTI_DISCO( "
					+ "IdDisco integer, "
					+ "Musicista text, "
					+ "Strumento text,"
					+ "PRIMARY KEY(IdDisco, Musicista, Strumento));";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS VENDITE( "
					+ "CFCliente text, "
					+ "Disco integer, "
					+ "PrezzoTot real, "
					+ "Data text, "
					+ "IP text, "
					+ "Pagamento text, "
					+ "Consegna text, "
					+ "PRIMARY KEY(CFCliente, Disco, Data));";
			
			stmt.executeUpdate(query);
			
			query = "CREATE TABLE IF NOT EXISTS MAGAZZINO( "
					+ "Disco integer PRIMARY KEY, "
					+ "Pezzi integer);";
			
			stmt.executeUpdate(query);
			stmt.close();

			c.close();
			
			
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
	
	
	public List<OccorrenzeDisco> viewCatalogo(){
		try{
			
			c = DriverManager.getConnection(URL);
			
			String sql = "SELECT * "
						+"FROM DISCO, MAGAZZINO "
						+"WHERE DISCO.Id = MAGAZZINO.Disco;";
			
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			stmt.close();
			c.close();
			
			List<OccorrenzeDisco> dischi = new ArrayList<>(); 
			
			while(rs.next()){
				
				int id = rs.getInt("Id");
				String  titolo = rs.getString("Titolo");
				float prezzo = rs.getFloat("Prezzo");
				String  rilascio = rs.getString("Rilascio");
				String titolare = rs.getString("Titolare");
				String descrizione= rs.getString("Descrizione");
				String genere = rs.getString("Genere");
				int strumenti = rs.getInt("Strumenti");
				String tipologia = rs.getString("Tipologia");
				int pezzi = rs.getInt("Pezzi");
				
				Disco d;
				
				if (tipologia.equals("CD")){
					d = new CD(id, titolo, getTracce(id), getFotografie(id), prezzo, Date.valueOf(rilascio), 
			        		getTitolare(titolare), descrizione, Generi.valueOf(genere), getStrumentiDisco(id));
				}
				else
					d = new DVD(id, titolo, getTracce(id), getFotografie(id), prezzo, Date.valueOf(rilascio), 
			        		getTitolare(titolare), descrizione, Generi.valueOf(genere), getStrumentiDisco(id));
				
				dischi.add(new OccorrenzeDisco(d, pezzi));
				
			}
			
			return dischi;
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public List<String> getTracce(int idDisco){
		
		try{
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT NomeTraccia "
						+"FROM TRACCE "
						+"WHERE IdDisco = " + idDisco;
			
			ResultSet result = stmt.executeQuery(sql);
			
			List<String> tracce = new ArrayList<>();
			
			while(result.next()){
				tracce.add(result.getString("NomeTraccia"));
			}
			
			stmt.close();
			c.close();
			
			return tracce;
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public List<String> getFotografie(int idDisco){
		
		try{
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT Url "
						+"FROM FOTOGRAFIE "
						+"WHERE IdDisco = " + idDisco;
			
			ResultSet result = stmt.executeQuery(sql);
			
			List<String> fotografie = new ArrayList<>();
			
			while(result.next()){
				fotografie.add(result.getString("Url"));
			}
			
			stmt.close();
			c.close();
			
			return fotografie;
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public List<StrumentiSuonati> getStrumentiDisco(int idDisco){
		
		
		try{
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT Strumento, Musicista "
						+"FROM STRUMENTI_DISCO "
						+"WHERE IdDisco = " + idDisco + " SORT BY MUSICISTA;";
			
			ResultSet result = stmt.executeQuery(sql);
			List<StrumentiSuonati> strumenti = new ArrayList<>();
			
			while(result.next()){
				StrumentiSuonati s = new StrumentiSuonati((Musicista)getTitolare(result.getString("Musicista")), null);
				if (strumenti.contains(s)){
					
					int index = strumenti.indexOf(s);
					strumenti.get(index).add(result.getString("Strumento"));
				}
			}
			
			
			stmt.close();
			c.close();
			
			return strumenti;
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public Artista getTitolare(String titolare){
		
		try{
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT * "
						+"FROM MUSICISTA "
						+"WHERE NomeArte = '" + titolare+ "';";
			
			ResultSet result = stmt.executeQuery(sql);
			
			Artista artista;
			
			String nomeArte = result.getString("NomeArte");
			Generi genere = Generi.valueOf(result.getString("Genere"));
			Date data = Date.valueOf(result.getString("DataNascita"));
			int strumenti = result.getInt("Strumenti");
			
			if (result.wasNull())
				artista = new Band(nomeArte, genere, data);
			
			else
				artista = new Musicista(nomeArte, genere, data, getStrumentiMusicista(nomeArte));
			
			stmt.close();
			c.close();
			
			return artista;
			
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public List<String> getStrumentiMusicista(String musicista){
		
		try{
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT Strumento "
						+"FROM STRUMENTI_SUONATI "
						+"WHERE Musicista = '" + musicista + "';";
			
			ResultSet result = stmt.executeQuery(sql);
			
			List<String> strumenti = new ArrayList<>();
			
			while(result.next()){
				strumenti.add(result.getString("Strumento"));
			}
			
			stmt.close();
			c.close();
			
			return strumenti;
		}catch(Exception e){
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		     return null;
		}
	}
	
	public boolean addUtente(Utente u){
		try {
			
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "INSERT INTO UTENTE VALUES	( "
						+ "'" + u.getCodiceFiscale() + "', "
						+ "'" + u.getUsername() + "', "
						+ "'" + u.getPassword() + "', "
					    + "'" + u.getNome() + "', "
					    + "'" + u.getCognome() + "', "
					    + "'" + u.getResidenza() + "', "
					    + "'" + u.getTelefonoCasa() + "', "
					    + "'" + u.getCellulare() + "', ";
			
			if (u instanceof PersonaleAutorizzato){
				sql += "1);";
			}
			else
				sql += "0);";
			
			stmt.executeUpdate(sql);
			
			return true;
			
		}catch(SQLException e){
			return false;
		}
	}
	
	public Utente getUtente(String username, String password){
		try{
			
			c = DriverManager.getConnection(URL);
			Statement stmt = c.createStatement();
			
			String sql = "SELECT * "
						+ "FROM UTENTE "
						+ "WHERE Username = '" + username + "' AND Password = '" + password + "';";
			
			ResultSet res = stmt.executeQuery(sql);
			
			Utente u = null;
			
			if (res.next()){  //c'è un risultato
				if (res.getInt("Autorizzazione") == 1){
					u = new PersonaleAutorizzato(res.getString("CodiceFiscale"), 
							res.getString("Username"),
							res.getString("Password"), 
							res.getString("Nome"), 
							res.getString("Cognome"), 
							res.getString("Residenza"), 
							res.getString("TelefonoCasa"), 
							res.getString("Cellulare"));
				}
				else{
					u = new Cliente(res.getString("CodiceFiscale"), 
							res.getString("Username"),
							res.getString("Password"), 
							res.getString("Nome"), 
							res.getString("Cognome"), 
							res.getString("Residenza"), 
							res.getString("TelefonoCasa"), 
							res.getString("Cellulare"));
				}
				
				
			}
			return u;
			
		}catch(SQLException e){
			return null;
		}
	}
}
