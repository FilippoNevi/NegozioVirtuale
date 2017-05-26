package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Cliente;
import model.Magazzino;
import model.PersonaleAutorizzato;
import model.Utente;
import view.AdminFrame;
import view.ClientFrame;
import view.MainFrame;
import view.SignUpFrame;

public class NewFrameListener implements ActionListener {
	
	private MainFrame sourceFrame;
	private Magazzino magazzino;
	
	public NewFrameListener(MainFrame f, Magazzino magazzino) {
		sourceFrame = f;
		this.magazzino = magazzino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if(source.getText().equals("Sign Up")) {
			new SignUpFrame("Sign Up", magazzino);
		}
		
		if (source.getText().equals("Login")){
			
			String username = sourceFrame.getUsername();
			String password = sourceFrame.getPassword(); 
	
			if (username.length() > 0 && password.length() > 0){
									
				Utente user = magazzino.getUtente(username, password);
				if (user != null && user instanceof Cliente){
					
					new ClientFrame("Catalogo Dischi", magazzino, (Cliente)user);
					sourceFrame.setVisible(false);
				
				}
				if (user != null && user instanceof PersonaleAutorizzato){
					
					new AdminFrame("Catalogo dischi - admin", magazzino, (PersonaleAutorizzato)user);
					sourceFrame.setVisible(false);;
				}
				else{
					JOptionPane.showMessageDialog(sourceFrame,
						    "Cliente non trovato",
						    "Errore",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
				
		}
	}

}
