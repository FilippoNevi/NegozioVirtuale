package controller;

import java.util.List;
import model.OccorrenzeDisco;

/**
 * Interfaccia implementata da tutti i JFrame che possiedono una tabella di occorrenze dischi che può essere ordinata
 * in qualche modo, o nella quale si può fare una ricerca filtrata
 * @author eros
 *
 */
public interface SortingMenu {
	
	/**
	 * Metodo che aggiorna la grafica della tabella
	 * @param elements Nuova lista da inserire in tabella
	 */
	public void updateTable(List<OccorrenzeDisco> elements);
	
	/**
	 * Ritorna true se la ricerca viene fatta per genere
	 * @return true se per genere, false altrimenti
	 */
	public boolean isForGenere();

	/**
	 * Ritorna true se la ricerca è per partecipante in un disco
	 * @return true se è per partecipante, false altrimenti
	 */
	public boolean isForPartecipante();
	
	/**
	 * Ritorna true se la ricerca è per prezzo 
	 * @return true se è per prezzo, false altrimenti
	 */ 
	public boolean isForPrezzo();

	/**
	 * Ritorna true se la ricerca è per titolare del disco
	 * @return true se è per titolare, false altrimenti
	 */
	public boolean isForTitolare();

	/**
	 * Metodo che ritorna la stringa di filtro della ricerca da effettuare
	 * @return Filtro di ricerca
	 */
	public String getFilter();
	
	/**
	 * Metodo che resetta la form del filtro di ricerca
	 */
	public void resetFilter();
	
}
