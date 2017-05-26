package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Comparator;
import java.util.List;

/**
 * Classe astratta che realizza un oggetto generico Disco
 *
 */
public abstract class Disco implements Serializable{
	private int id;
	private String titolo;
	private List<String> tracce;
	private List<String> fotografie;
	private float prezzo;
	private Date rilascio;
	private Artista titolare;
	private String descrizione;
	private Generi genere;
	private List<StrumentoSuonato> strumenti;
	
	private static int codice = 0;		//Serve per creare un nuovo id del disco dinamicamente
	
	/**
	 * Costruttore che inizializza gli attributi di un Disco
	 * @param titolo titolo del disco
	 * @param tracce
	 * @param fotografie
	 * @param prezzo
	 * @param rilascio
	 * @param titolare
	 * @param descrizione
	 * @param genere
	 * @param strumenti
	 */
	
	public Disco(String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentoSuonato> strumenti) {
		
		this.id = codice++;
		this.titolo = titolo;
		this.tracce = tracce;
		this.fotografie = fotografie;
		this.prezzo = prezzo;
		this.rilascio = rilascio;
		this.titolare = titolare;
		this.descrizione = descrizione;
		this.genere = genere;
		this.strumenti = strumenti;
	}
	
	public int getId(){ 
		return id; 
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<String> getTracce() {
		return tracce;
	}

	public void setTracce(List<String> tracce) {
		this.tracce = tracce;
	}

	public List<String> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<String> fotografie) {
		this.fotografie = fotografie;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Date getRilascio() {
		return rilascio;
	}

	public void setRilascio(Date rilascio) {
		this.rilascio = rilascio;
	}

	public Artista getTitolare() {
		return titolare;
	}

	public void setTitolare(Artista titolare) {
		this.titolare = titolare;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Generi getGenere() {
		return genere;
	}

	public void setGenere(Generi genere) {
		this.genere = genere;
	}

	public List<StrumentoSuonato> getStrumenti() {
		return strumenti;
	}

	public void setStrumenti(List<StrumentoSuonato> strumenti) {
		this.strumenti = strumenti;
	}
	
	public void addFotografia(String url){
		fotografie.add(url);
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean equals(Object o){
		if (o instanceof Disco){
			return id == ((Disco)o).id;
		}
		return false;		
	}
	
	@Override
	public int hashCode(){
		return id;
	}
	
	public boolean partecipa(String musicista){
		for (StrumentoSuonato strumento : strumenti){
			if (strumento.getMusicista().equals(musicista))
				return true;
		}
		return false;
	}
	
	/*
	 * Classi che implementano le classi Comparator (per i sort)
	 */
	
	public class GenereComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return d1.genere.toString().compareTo(d2.genere.toString());
		}
	}
	
	public class TitolareComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return d1.titolare.getNomeArte().compareTo(d2.titolare.getNomeArte());
		}
	}
	
	public class PrezzoComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return Double.compare(d1.prezzo, d2.prezzo);
		}
	}
	
	
}

