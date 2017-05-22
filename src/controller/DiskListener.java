package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import view.NewDiskFrame;

public class DiskListener implements ActionListener {
	
	private NewDiskFrame frame;
	
	public DiskListener(NewDiskFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton source = (JButton)e.getSource();
			if(source.getText().equals("Fotografie")) {
				final JFileChooser fc = new JFileChooser();
				
				int returnVal = fc.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File foto = fc.getSelectedFile();
					frame.setFoto(foto);
					System.err.println("Opening: " + foto.getName() + ".");
				}
			}
		}
		
	}
	
}
