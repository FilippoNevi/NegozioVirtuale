package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.Disco;
import model.Magazzino;
import model.OccorrenzeDisco;

public class FilterListener implements ActionListener{
	
	private SortingMenu frame;
	private Magazzino magazzino;
	
	public FilterListener(Magazzino magazzino, SortingMenu frame){
		this.frame = frame;
		this.magazzino = magazzino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton src = (JButton)e.getSource();
		List<OccorrenzeDisco> dischi = magazzino.getCatalogo();
		
		if (src.getText().equals("Annulla")){
			frame.updateTable(dischi);
		}
		else{
			
			List<OccorrenzeDisco> filtrati = new ArrayList<>();
			String filtro = frame.getFilter();
			
			if (filtro.length() > 0){
			
				for (OccorrenzeDisco occ : dischi){
					
					Disco disco = occ.getDisco();
					
					if (frame.isForGenere() && disco.getGenere().toString().equalsIgnoreCase(filtro))
						filtrati.add(occ);
					
					else if (frame.isForPartecipante() && disco.partecipa(filtro))
						filtrati.add(occ);
					
					else if (frame.isForPrezzo() && disco.getPrezzo() == Float.parseFloat(filtro))
						filtrati.add(occ);
					
					else if (frame.isForTitolare() && disco.getTitolare().getNomeArte().equals(filtro))
						filtrati.add(occ);
					
				}
				frame.updateTable(filtrati);
			}
		}
		
	}

}
