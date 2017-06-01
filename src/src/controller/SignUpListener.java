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
				frame.getCellulare().length() >= 0){
			
			String cellulare = frame.getCellulare();
			
			try{
							
				Cliente.ClienteBuilder builder = new Cliente.ClienteBuilder(frame.getCF(), frame.getUsername(), frame.getPassword());
				Utente u = null;
				
				if (cellulare.length() == 0){
					builder.setNome(frame.getNome()).
							setCognome(frame.getCognome()).
							setResidenza(frame.getResidenza()).
							setTelefonoCasa(frame.getTelefonoCasa());
					
					u = builder.build();
				}
				else if (cellulare.length() == 10){
		
					Long.parseLong(cellulare);		//controllo che sia un intero
					builder.setCellulare(cellulare);
					u = builder.build();
				}
							
				if (u == null){
					JOptionPane.showMessageDialog(frame,
						    "Errore inserimento dati",
						    "Errore",
						    JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!magazzino.addUtente(u)){
					JOptionPane.showMessageDialog(frame,
						    "Utente già inserito",
						    "Errore",
						    JOptionPane.ERROR_MESSAGE);
				}else{
					frame.setVisible(false);
					magazzino.salva();
				}
			}catch(NumberFormatException exc){
				System.err.println(cellulare);
				JOptionPane.showMessageDialog(frame,
					    "Numero non valido",
					    "Errore",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		
				
	}

}
