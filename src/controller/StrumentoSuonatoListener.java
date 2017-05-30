package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Magazzino;
import model.Musicista;
import model.StrumentoSuonato;
import view.NewDiskFrame;
import view.StrumentoSuonatoFrame;

public class StrumentoSuonatoListener implements ActionListener{
	
	private NewDiskFrame frame;
	private StrumentoSuonatoFrame src;
	
	public StrumentoSuonatoListener(NewDiskFrame frame, StrumentoSuonatoFrame src) {

		this.frame = frame;
		this.src = src;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Musicista musicista = src.getMusicista();
		String strumento = src.getStrumento();
		
		frame.addStrumentoSuonato(new StrumentoSuonato(musicista, strumento));
		src.dispose();
		
	}
	

}
