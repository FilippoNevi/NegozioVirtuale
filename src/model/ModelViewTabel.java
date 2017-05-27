package model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import controller.RowListener;

public class ModelViewTabel extends DefaultTableModel {
	
	private static final String titoli[]={"ID", "Tipo", "Titolo","Titolare","Icona", "Genere", "Prezzo", "Disponibilità"};
	
	public ModelViewTabel(List<OccorrenzeDisco> elementi) {
		
		super(new Object[0][8], titoli);
				
		String[] riga = new String[8];
		
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
			riga[5] = disco.getGenere().toString();
			riga[6] = String.valueOf(disco.getPrezzo());				
			riga[7] = String.valueOf(occ.getOccorrenza());
			
			addRow(riga);
		}
		
		fireTableDataChanged();
	
		
	}	

}
