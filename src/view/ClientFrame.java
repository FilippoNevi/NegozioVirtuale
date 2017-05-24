package view;

import java.util.List;

import javax.swing.*;

import controller.RowListener;
import controller.WindowClosedListener;
import model.*;

public class ClientFrame extends JFrame {
	
	private Cliente cliente;
	private Maga magazzino;
		
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem exit;
	
	private JMenu edit;
	private JMenu sort;
	private JMenuItem sortByTitolo;
	private JMenuItem sortByArtista;
	private JMenuItem sortByPrezzo;
	private JMenu search;
	private JMenuItem searchByGenere;
	private JMenuItem searchByTitolare;
	private JMenuItem searchByMusicista;
	private JMenuItem searchByPrezzo;
	
	
	public ClientFrame(String titoloFrame, Maga magazzino, Cliente cliente) {
		super(titoloFrame);
		
		this.cliente = cliente;
		this.magazzino = magazzino;
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		exit = new JMenuItem("Exit");
		file.add(logout);
		file.add(exit);
		
		edit = new JMenu("Edit");
		
		sort = new JMenu("Ordina per...");
		sortByArtista = new JMenuItem("Artista");
		sortByPrezzo = new JMenuItem("Prezzo");
		sortByTitolo = new JMenuItem("Titolo");
		sort.add(sortByTitolo);
		sort.add(sortByArtista);
		sort.add(sortByPrezzo);
		edit.add(sort);
		
		search = new JMenu("Cerca per...");
		searchByGenere = new JMenuItem("Genere");
		searchByTitolare = new JMenuItem("Titolare");
		searchByMusicista = new JMenuItem("Musicista presente");
		searchByPrezzo = new JMenuItem("Prezzo");
		search.add(searchByGenere);
		search.add(searchByTitolare);
		search.add(searchByMusicista);
		search.add(searchByPrezzo);
		
		edit.add(search);
		menuBar.add(file);
		menuBar.add(edit);
		
		String titoli[]={"Tipo", "Titolo","Titolare","Icona", "Genere", "Prezzo", "Disponibilità"};
		List<OccorrenzeDisco> pezzi = magazzino.getCatalogo(null);
		
		Object dati[][] = new String[pezzi.size()][titoli.length];
		
		
		for (int i = 0; i < pezzi.size(); i++){
			if (pezzi.get(i).getDisco() instanceof CD){
				dati[i][0] = "CD";
			}else{
				dati[i][0] = "DVD";
			}
			
			dati[i][1] = pezzi.get(i).getDisco().getTitolo();
			dati[i][2] = pezzi.get(i).getDisco().getTitolare().getNomeArte();
			dati[i][3] = pezzi.get(i).getDisco().getFotografie().get(0);
			dati[i][4] = pezzi.get(i).getDisco().getGenere().toString();
			dati[i][5] = String.valueOf(pezzi.get(i).getDisco().getPrezzo());
			dati[i][6] = String.valueOf(pezzi.get(i).getOccorrenza());
			
		}
		
	    ViewTable tabella=new ViewTable(dati, titoli);
	    tabella.setBounds(30,40,200,300);
	    RowListener listener = new RowListener(pezzi);
        tabella.addMouseListener(listener);
	    
	    JScrollPane sp=new JScrollPane(tabella);    
	    this.add(sp);
		
		this.setJMenuBar(menuBar);
		this.addWindowListener(new WindowClosedListener(magazzino));
		this.pack();
		this.setVisible(true);
	}	
	
}
