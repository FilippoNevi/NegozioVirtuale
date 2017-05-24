package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Maga;
import view.SignUpFrame;

public class NewFrameListener implements ActionListener {
	
	private JFrame sourceFrame;
	private Maga magazzino;
	
	public NewFrameListener(JFrame f, Maga magazzino) {
		sourceFrame = f;
		this.magazzino = magazzino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if(source.getText().equals("Sign Up")) {
			new SignUpFrame("Sign Up", magazzino);
		}
		
	
	}

}
