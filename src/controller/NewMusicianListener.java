package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Artista;
import model.Band;
import model.Date;
import model.Generi;
import model.Magazzino;
import model.Musicista;
import view.NewMusicianFrame;

/**
 * Gestisce l'inserimento di un nuovo artista nella piattaforma
 *
 */
public class NewMusicianListener implements ActionListener{
	
	private NewMusicianFrame frame;
	private Magazzino magazzino;
	
	public NewMusicianListener(NewMusicianFrame frame, Magazzino magazzino) {
		this.frame = frame;
		this.magazzino = magazzino;
	}
	
	/**
	 * Inserimento del'artista nel magazzino
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nomeArte = frame.getNomeArte();
		Date nascita = frame.getNascita();
		Generi genere = frame.getGenere();
	
		if (nomeArte.length() > 0){
			
			Artista artista; 
			
			if (frame.isMusicista()){
				artista = new Musicista(nomeArte,
										genere,
										nascita,
										frame.getStrumenti());									
			}
			else{
				artista = new Band(nomeArte, genere, nascita);
			}
			
			if (magazzino.addArtista(artista) == false){
				JOptionPane.showMessageDialog(frame,
					    "Musicista già inserito",
					    "Errore",
					    JOptionPane.ERROR_MESSAGE);
			}
			magazzino.salva();
			frame.setVisible(false);
			
		}
		
	}
	
}
