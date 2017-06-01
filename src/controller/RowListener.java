package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import model.Cliente;
import model.Magazzino;
import model.OccorrenzeDisco;
import model.Utente;
import view.AdminViewTable;
import view.DetailsFrame;
import view.DetailsFrameClient;
import view.MainFrame;
import view.ViewTable;

/**
 * Classe che gestisce gli eventi tra user e tabella 
 *
 */
public class RowListener implements MouseListener, ActionListener{

	private List<OccorrenzeDisco> dischi;
	private Magazzino magazzino;
	private SortingMenu frame;
	private boolean isAdmin;
	private int row;
	private ViewTable tabella;
	
	private JMenuItem addItem;
	private JMenuItem detailsItem;
	private Utente utente;
	private MainFrame login;
	
	public RowListener(SortingMenu frame, List<OccorrenzeDisco> dischi, Magazzino magazzino, Utente utente, MainFrame login) {
		this.dischi = dischi;
		this.magazzino = magazzino;
		this.frame = frame;
		this.utente = utente;
		this.login = login;
	}
	
	/**
	 * In base al tasto che premo, a chi sono, e alla riga in cui ho il puntatore, eseguo determinate operazioni
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		tabella = (ViewTable)e.getSource();
		
		if (tabella instanceof AdminViewTable){				//Se sono l'amministratore del sistema
		
			row = tabella.rowAtPoint(e.getPoint());
			
			if (e.getButton() == MouseEvent.BUTTON3){		//click destro
				
				JPopupMenu menu = new JPopupMenu("Menu");
				
				detailsItem = new JMenuItem("Dettagli");
				addItem = new JMenuItem("Aggiungi quantità");
				
				menu.add(detailsItem);
				menu.add(addItem);
				
				detailsItem.addActionListener(this);
				addItem.addActionListener(this);
				
				menu.show(e.getComponent(), e.getX(), e.getY());
		
			}
		}
		else{
			row = tabella.rowAtPoint(e.getPoint());			//Se sono un cliente normale
			
			if (e.getButton() == MouseEvent.BUTTON3){		//click destro
				
				JPopupMenu menu = new JPopupMenu("Menu");
				
				detailsItem = new JMenuItem("Dettagli");
				
				menu.add(detailsItem);
					
				detailsItem.addActionListener(this);
				
				menu.show(e.getComponent(), e.getX(), e.getY());
		
			}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem src = (JMenuItem) e.getSource();
		
		if (tabella instanceof AdminViewTable){
			if (src == addItem){
				
				SpinnerNumberModel sModel = new SpinnerNumberModel(0, 0, 30, 1);
				JSpinner spinner = new JSpinner(sModel);
				JOptionPane.showMessageDialog(null, spinner);
				magazzino.incDisco(dischi.get(row).getDisco(), (int)spinner.getValue());
				magazzino.salva();
				frame.updateTable(magazzino.getCatalogo());
			}
			else if (src == detailsItem){
				new DetailsFrame(dischi.get(row).getDisco().getTitolo(), dischi.get(row).getDisco());
			}
			
		}
		else{
			if (src == detailsItem){
				new DetailsFrameClient(dischi.get(row).getDisco(), magazzino, (Cliente)utente, login);
			}
			
		}
				
			
	}
	
}
