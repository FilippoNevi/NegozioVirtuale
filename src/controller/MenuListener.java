package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import model.Disco;
import model.Magazzino;
import model.OccorrenzeDisco;
import view.AdminFrame;
import view.MainFrame;
import view.NewDiskFrame;
import view.NewMusicianFrame;

/**
 * Classe che implementa il listener della barra del menu
 *
 */
public class MenuListener implements ActionListener{
	
	private Magazzino magazzino;
	private SortingMenu frame;
	private MainFrame login;
	
	/**
	 * Metodo costruttore
	 * @param magazzino Magazzino di cui salvare lo stato attuale
	 * @param frame Finestra che possiede una tabella con i dati da ordinare
	 * @param login Schermata di login iniziale
	 */
	
	public MenuListener(Magazzino magazzino, SortingMenu frame, MainFrame login) {
		this.magazzino = magazzino;
		this.frame = frame;
		this.login = login;
	}
	
	/**
	 * Gestore dell'evento di click sulle varie opzioni del menu
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem source = (JMenuItem)e.getSource();
		
		//sono nella schermata dell'admin
		//Premo il menu Add
		//-----------------------------------------------------------------
		if (source.getText().equals("Musicista")){
			new NewMusicianFrame(magazzino);
		}
		if (source.getText().equals("Disco")){
			new NewDiskFrame((AdminFrame)frame, magazzino);
		}
		//-----------------------------------------------------------------
		
		if (source.getText().equals("Genere")){
			List<OccorrenzeDisco> dischi = magazzino.getCatalogo(new Disco.GenereComparator());
			frame.updateTable(dischi);
		}
		if (source.getText().equals("Titolare")){
			List<OccorrenzeDisco> dischi = magazzino.getCatalogo(new Disco.TitolareComparator());
			frame.updateTable(dischi);
		}
		if (source.getText().equals("Prezzo")){
			List<OccorrenzeDisco> dischi = magazzino.getCatalogo(new Disco.PrezzoComparator());
			frame.updateTable(dischi);
		}
		
		if (source.getText().equals("Exit")){
			System.exit(0);
		}
		if (source.getText().equals("Logout")){
			JFrame f = (JFrame)frame;
			f.setVisible(false);
			login.setVisible(true);
		}
		
	}

}
