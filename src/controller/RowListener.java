package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import model.Magazzino;
import model.OccorrenzeDisco;
import view.DetailsFrame;
import view.ViewTable;

public class RowListener implements MouseListener {

	private List<OccorrenzeDisco> dischi;
	private Magazzino magazzino;
	private SortingMenu frame;
	
	public RowListener(SortingMenu frame, List<OccorrenzeDisco> dischi, Magazzino magazzino) {
		this.dischi = dischi;
		this.magazzino = magazzino;
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ViewTable tabella = (ViewTable)e.getSource();
		int row = tabella.getSelectedRow();
		
		if(e.getClickCount() == 2) {
						
			new DetailsFrame(dischi.get(row).getDisco().getTitolo(), dischi.get(row).getDisco());
		}
		
		if (e.getClickCount() == 3 && magazzino != null){ //solo per l'admin
			
			SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 30, 1);
			JSpinner spinner = new JSpinner(sModel);
			JOptionPane.showMessageDialog(null, spinner);
			magazzino.incDisco(dischi.get(row).getDisco(), (int)spinner.getValue());
			magazzino.salva();
			frame.updateTable(magazzino.getCatalogo());
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
