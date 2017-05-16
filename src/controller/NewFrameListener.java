package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Magazzino;
import view.SignUpFrame;

public class NewFrameListener implements ActionListener {
	
	private JFrame sourceFrame;
	private Magazzino magazzino;
	
	public NewFrameListener(JFrame f, Magazzino magazzino) {
		sourceFrame = f;
		this.magazzino = magazzino;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if(source.getText().equals("Sign Up")) {
			sourceFrame.setVisible(false);
			new SignUpFrame("Sign Up", magazzino);
		}
		else if(source.getText().equals("Login")){
			
		}
	
	}

}
