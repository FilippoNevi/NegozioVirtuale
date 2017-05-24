package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class ClientMenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		JMenuItem item = (JMenuItem)e.getSource();
		System.err.println(item.getText());
	
				
	}

	

}
