package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Maga;

public class WindowClosedListener extends WindowAdapter{
	
	private Maga magazzino;
	
	public WindowClosedListener(Maga magazzino){
		this.magazzino = magazzino;
	}
	
	public void windowClosing(WindowEvent e){
    	
		magazzino.salva();
		System.exit(0);
    }

}
