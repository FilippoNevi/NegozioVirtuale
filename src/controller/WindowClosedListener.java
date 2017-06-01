package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Magazzino;

/**
 * Listener che gestisce la chiusura del programma
 *
 */
public class WindowClosedListener extends WindowAdapter{
	
	private Magazzino magazzino;
	
	public WindowClosedListener(Magazzino magazzino){
		this.magazzino = magazzino;
	}
	
	public void windowClosing(WindowEvent e){
    	
		magazzino.salva();
		System.exit(0);
    }

}
