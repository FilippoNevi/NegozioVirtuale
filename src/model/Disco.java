package model;

import java.io.Serializable;
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
	 * @param tracce lista delle tracce del disco
	 * @param fotografie path di tutte le fotografie del disco
	 * @param prezzo prezzo del disco
	 * @param rilascio data di rilascio del disco
	 * @param titolare Artista titolare del disco
	 * @param descrizione descrizione del disco
	 * @param genere genere del disco
	 * @param strumenti lista di strumenti suonati per ogni artista
	 */
	
	public Disco(String titolo, List<String> tracce, List<String> fotografie, float prezzo, 
			Date rilascio, Artista titolare, String descrizione, Generi genere, List<StrumentoSuonato> strumenti) {
		
		this.id = codice;
		codice = codice +1;
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
	
	/**
	 * Un disco ha una funzione hash che ritorna l'id del disco. 
	 * Univocità garantita
	 */
	
	@Override
	public int hashCode(){
		return id;
	}
	
	/**
	 * Ritorna true se nel disco partecipa il musicista passato come parametro
	 * @param musicista Musicista che partecipa
	 * @return true se è presente nel disco, false altrimenti
	 */
	public boolean partecipa(String musicista){
		for (StrumentoSuonato strumento : strumenti){
			if (strumento.getMusicista().equals(musicista))
				return true;
		}
		return false;
	}
	
	public static void setCodice(int c){
		codice = c;
	}
	
	/**
	 * Metodo che ritorna la variabile statica che memorizza il numero progressivo dei dischi
	 * @param c
	 */
	public static int getCodice(){
		return codice;
	}
	
	/*
	 * Classi che implementano le classi Comparator (per i sort)
	 */
	
	/**
	 * Classe che realizza un comparatore di dischi: ordinamento per genere
	 *
	 */
	public static class GenereComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return d1.genere.toString().compareTo(d2.genere.toString());
		}
	}
	
	/**
	 * Classe che realizza un comparatore di dischi: ordinamento per titolare
	 *
	 */
	public static class TitolareComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return d1.titolare.getNomeArte().compareTo(d2.titolare.getNomeArte());
		}
	}
	
	/**
	 * Classe che realizza un comparatore di dischi: ordinamento per prezzo
	 *
	 */
	public static class PrezzoComparator implements Comparator<Disco>{
		
		@Override
		public int compare(Disco d1, Disco d2){
			return Double.compare(d1.prezzo, d2.prezzo);
		}
	}
	
	
	
}

