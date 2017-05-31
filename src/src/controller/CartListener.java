package controller;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.Carrello;
import model.Magazzino;
import view.CartFrame;
import view.ClientFrame;
import view.MainFrame;
import view.ViewTable;

public class CartListener implements MouseListener, ActionListener{
	
	
	private CartFrame frame;
	private Carrello carrello;
	private Magazzino magazzino;
	private int row;
	private MainFrame login;
	private ClientFrame client;
	
	public CartListener(CartFrame frame, Carrello carrello, Magazzino magazzino, MainFrame login, ClientFrame client){
		this.frame = frame;
		this.magazzino = magazzino;
		this.carrello = carrello;
		this.login = login;
		this.client = client;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		ViewTable tabella = (ViewTable)e.getSource();
		
		if (e.getButton() == MouseEvent.BUTTON3){
			
			JPopupMenu menu = new JPopupMenu("Menu");
			
			JMenuItem removeItem = new JMenuItem("Rimuovi");
			
			row = tabella.rowAtPoint(e.getPoint());			
			menu.add(removeItem); 
				
			removeItem.addActionListener(this);
			
			menu.show(e.getComponent(), e.getX(), e.getY());
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
		
		JMenuItem src = (JMenuItem)e.getSource();
		
		if (src.getText().equals("Rimuovi")){
			carrello.removeDisco(carrello.getDisco(row));
			magazzino.salva();
			frame.updateTable(carrello);
		}
		else if (src.getText().equals("Exit")){
			System.exit(0);
		}
		else if (src.getText().equals("Logout")){
			frame.dispose();
			client.dispose();
			login.setVisible(true);
		}
		
	}

}
