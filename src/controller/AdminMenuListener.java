package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Magazzino;
import view.NewDiskFrame;
import view.NewMusicianFrame;

public class AdminMenuListener implements ActionListener{
	
	private Magazzino magazzino;
	
	public AdminMenuListener(Magazzino magazzino) {
		this.magazzino = magazzino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JMenuItem source = (JMenuItem)e.getSource();
		
		if (source.getText().equals("Musicista")){
			new NewMusicianFrame(magazzino);
		}
		if (source.getText().equals("Disco")){
			new NewDiskFrame(magazzino);
		}
		
	}

}
