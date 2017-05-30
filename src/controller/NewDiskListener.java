package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Artista;
import model.CD;
import model.DVD;
import model.Disco;
import model.Generi;
import model.Magazzino;
import model.Musicista;
import model.StrumentoSuonato;
import view.AdminFrame;
import view.MainFrame;
import view.NewDiskFrame;
import view.StrumentoSuonatoFrame;

public class NewDiskListener implements ActionListener {
	
	private NewDiskFrame frame;
	private Magazzino magazzino;
	private AdminFrame admin;
	
	public NewDiskListener(NewDiskFrame frame, AdminFrame admin, Magazzino magazzino) {
		this.frame = frame;
		this.magazzino = magazzino;
		this.admin = admin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton source = (JButton)e.getSource();
			
			if(source.getText().equals("Fotografie")) {
				JFileChooser fc = new JFileChooser();
				
				FileFilter imgFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				
				fc.setFileFilter(imgFilter);
				
				int returnVal = fc.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File foto = fc.getSelectedFile();
					frame.addFoto(foto.getAbsolutePath());
					System.err.println("Opening: " + foto.getName() + ".");
				}
			}
			
			if (source.getText().equals("Aggiungi un musicista")){
				new StrumentoSuonatoFrame(frame, magazzino);
			}
			
			if (source.getText().equals("Conferma")){
				String titolo = frame.getTitolo();
				List<String> tracce =frame.getTracce();
				List<String> foto = frame.getFoto();
				
				float prezzo = frame.getPrezzo();
				Date rilascio = frame.getDataRilascio();
				String nomeArtista = frame.getArtista();
				String descrizione = frame.getDescrizione();
				Generi genere = frame.getGenere();
				List<StrumentoSuonato> strumentiSuonati = frame.getStrumentoSuonato();
								
				if (titolo.length() > 0 && !tracce.isEmpty() && nomeArtista.length() > 0 &&
						descrizione.length() > 0 && !strumentiSuonati.isEmpty()){
										
					Disco disco;
					if (frame.isCD()){
						disco = new CD(
								titolo, 
								tracce,
								foto, 
								prezzo, 
								rilascio, 
								magazzino.getArtista(nomeArtista),
								descrizione,
								genere,
								strumentiSuonati);
					} 
					else{
						disco = new DVD(
								titolo, 
								tracce,
								foto, 
								prezzo, 
								rilascio, 
								magazzino.getArtista(nomeArtista),
								descrizione,
								genere,
								strumentiSuonati);
					}
					
					magazzino.addDisco(disco, frame.getOccorrenze());
				
					magazzino.salva();
				    frame.setVisible(false);
				    admin.updateTable(magazzino.getCatalogo());
				}
			}
			
			
		}
		
	}
	
}
