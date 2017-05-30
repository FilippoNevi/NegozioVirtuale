package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Magazzino;
import model.Utente;
import view.SignUpFrame;

public class SignUpListener implements ActionListener{
	
	private SignUpFrame frame;
	private Magazzino magazzino;
	
    public SignUpListener(SignUpFrame frame, Magazzino magazzino){
    	this.frame = frame;
    	this.magazzino = magazzino;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		if (!frame.getPassword().equals(frame.getConfirmPassword())){
			JOptionPane.showMessageDialog(frame,
				    "Le password non coincidono",
				    "Errore",
				    JOptionPane.ERROR_MESSAGE);
		}
		else if (frame.getCF().length() > 0 &&
				frame.getUsername().length() > 0 &&
				frame.getPassword().length() > 0 &&
				frame.getNome().length() > 0 &&
				frame.getCognome().length() > 0 &&
				frame.getResidenza().length() > 0 &&
				frame.getTelefonoCasa().length() > 0 &&
				frame.getCellulare().length() > 0){
			
			Utente u = new Cliente(
						frame.getCF(),
						frame.getUsername(),
						frame.getPassword(),
						frame.getNome(),
						frame.getCognome(),
						frame.getResidenza(),
						frame.getTelefonoCasa(),
						frame.getCellulare()
					);
			if (!magazzino.addUtente(u)){
				JOptionPane.showMessageDialog(frame,
					    "Utente già inserito",
					    "Errore",
					    JOptionPane.ERROR_MESSAGE);
			}else{
				frame.setVisible(false);
				magazzino.salva();
			}
		}
		
				
	}

}
