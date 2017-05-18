package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;

import model.OccorrenzeDisco;
import view.DettagliFrame;
import view.ViewTable;

public class RowListener implements MouseListener {

	private List<OccorrenzeDisco> dischi;
	
	public RowListener(List<OccorrenzeDisco> dischi) {
		this.dischi = dischi;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			ViewTable tabella = (ViewTable)e.getSource();
			int row = tabella.getSelectedRow();
			
			new DettagliFrame(dischi.get(row).getDisco().getTitolo(), dischi.get(row).getDisco());
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
