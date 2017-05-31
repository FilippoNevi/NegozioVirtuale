package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Carrello;
import model.Cliente;
import model.Disco;
import model.Magazzino;
import view.CartFrame;
import view.ClientFrame;
import view.MainFrame;

public class BuyListener implements ActionListener{
	
	private Cliente cliente;
	private Magazzino magazzino;
	private MainFrame login;
	private Disco disco;
	private ClientFrame clientFrame;
	
	public BuyListener(Cliente cliente, Magazzino magazzino, MainFrame login, ClientFrame clientFrame, Disco disco){
		this.cliente = cliente;
		this.magazzino = magazzino; 
		this.login = login;
		this.disco = disco;
		this.clientFrame = clientFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton src = (JButton)e.getSource();
		
		if (src.getText().equals("Acquista")){
			
			Carrello carrello = magazzino.getCarrello(cliente);
			if (carrello == null){
				carrello = new Carrello(cliente);
			}

			int risultato = JOptionPane.showConfirmDialog(
					login,
					"Sei sicuro di voler aggiungere il disco al carrello?",
					"Conferma acquisto",
					JOptionPane.YES_NO_OPTION);
			
			if (risultato == JOptionPane.YES_OPTION){
				carrello.addDisco(disco);
				magazzino.addCarrello(carrello);
				magazzino.salva();
			}	
		}
		
		if (src.getText().equals("Carrello")){
			Carrello carrello = magazzino.getCarrello(cliente);
			
			if (carrello == null){
				carrello = new Carrello(cliente);
				magazzino.addCarrello(carrello);
			}
			
			new CartFrame(login, clientFrame, carrello, cliente, magazzino);
		}
		
	}

}
