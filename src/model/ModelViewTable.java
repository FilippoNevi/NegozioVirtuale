package model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 * Classe che si occupa dell'aggiornamento ed inizializzione della tabella che mostra i dati dei dischi e del carrello
 *
 */


public class ModelViewTable extends DefaultTableModel {
	
	private static final String titoli[]={"ID", "Tipo", "Titolo","Titolare","Icona", "Genere", "Prezzo", "Disponibilità"};
	private static final String info[]={"Tipo", "Titolo","Titolare","Icona", "Genere", "Prezzo"};
	
	/**
	 * Costruttore che costruisce una Tabella per rappresentare il catalogo
	 * @param elementi Lista di dischi nel catalogo
	 */
	public ModelViewTable(List<OccorrenzeDisco> elementi) {
		
		super(new Object[0][titoli.length], titoli);
				
		String[] riga = new String[titoli.length];
		
		for (OccorrenzeDisco occ : elementi){
			Disco disco = occ.getDisco();
			
			riga[0] = String.valueOf(disco.getId());
			if (disco instanceof CD){
				riga[1] = "CD";
			}else{
				riga[1] = "DVD";
			}
			
			riga[2] = disco.getTitolo();
			riga[3] = disco.getTitolare().getNomeArte();
			
			if (disco.getFotografie().size() > 0){
				riga[4] = disco.getFotografie().get(0);
			}
			else
				riga[4] = null;
			
			riga[5] = disco.getGenere().toString();
			riga[6] = String.valueOf(disco.getPrezzo());				
			riga[7] = String.valueOf(occ.getOccorrenza());
			
			addRow(riga);
			
		}
		
		fireTableDataChanged();   //aggiorna la view della tabella
	
		
	}
	
	/**
	 * Costruttore che costruisce una tabella per rappresentare il carrello del cliente
	 * @param carrello Carrello del cliente
	 */
	public ModelViewTable(Carrello carrello){
		super(new Object[0][info.length], info);
		
		String[] riga = new String[info.length];
		
		for (Disco d : carrello){
			
			if (d instanceof CD){
				riga[0] = "CD";
			}else{
				riga[0] = "DVD";
			}
			
			riga[1] = d.getTitolo();
			riga[2] = d.getTitolare().getNomeArte();
			
			if (d.getFotografie().size() > 0){
				riga[3] = d.getFotografie().get(0);
			}
			else
				riga[3] = null;
			
			riga[4] = d.getGenere().toString();
			riga[5] = String.valueOf(d.getPrezzo());
			
			addRow(riga);
			
		}
		
		fireTableDataChanged();   //aggiorna la view della tabella
	}
	
	/**
	 * Costruttore che costruisce una tabella che mostra il catalogo, passando come parametro direttamente il magazzino
	 * @param magazzino Magazzino 
	 */
	public ModelViewTable(Magazzino magazzino) {
		
		this(magazzino.getCatalogo());
								
	}

}
