package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.SignUpFrame;

public class NewFrameListener implements ActionListener {
	
	private JFrame sourceFrame;
	
	public NewFrameListener(JFrame f) {
		sourceFrame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		if(source.getText().equals("Sign Up")) {
			sourceFrame.setVisible(false);
			new SignUpFrame("Sign Up");
		}
	}

}
