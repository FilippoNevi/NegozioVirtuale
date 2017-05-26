package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.AdminMenuListener;
import controller.RowListener;
import model.CD;
import model.Disco;
import model.Magazzino;
import model.OccorrenzeDisco;
import model.PersonaleAutorizzato;

public class AdminFrame extends JFrame {
	
	private PersonaleAutorizzato admin;

	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem exit;
	
	private JMenu edit;
	private JMenu search;
	private JMenuItem searchByGenere;
	private JMenuItem searchByTitolare;
	private JMenuItem searchByMusicista;
	private JMenuItem searchByPrezzo;
	private JMenu add;
	private JMenuItem addDisco;
	private JMenuItem addMusicista;
	
	private Magazzino magazzino;
	private AdminMenuListener menuListener;

	/**
	 * Create the frame.
	 */
	public AdminFrame(String titolo, Magazzino magazzino, PersonaleAutorizzato admin) {
		super(titolo);
		
		this.admin = admin;
		this.magazzino = magazzino;
		
		menuListener = new AdminMenuListener(magazzino);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		exit = new JMenuItem("Exit");
		file.add(logout);
		file.add(exit);
		
		edit = new JMenu("Edit");
		
		add = new JMenu("Add...");
		addDisco = new JMenuItem("Disco");
		addMusicista = new JMenuItem("Musicista");
		add.add(addDisco);
		add.add(addMusicista);

		
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
		edit.add(add);
		menuBar.add(file);
		menuBar.add(edit);
		
		logout.addActionListener(menuListener);
		exit.addActionListener(menuListener);
		searchByMusicista.addActionListener(menuListener);
		searchByGenere.addActionListener(menuListener);
		searchByPrezzo.addActionListener(menuListener);
		searchByTitolare.addActionListener(menuListener);
		addDisco.addActionListener(menuListener);
		addMusicista.addActionListener(menuListener);
		
		
		String titoli[]={"ID", "Tipo", "Titolo","Titolare","Icona", "Genere", "Prezzo", "Disponibilità"};
		List<OccorrenzeDisco> pezzi = magazzino.getCatalogo();
		System.err.println(pezzi);
		Object dati[][] = new String[pezzi.size()][titoli.length];
		
		
		for (int i = 0; i < pezzi.size(); i++){
			
			Disco disco = pezzi.get(i).getDisco();
			
			dati[i][0] = String.valueOf(disco.getId());
			if (pezzi.get(i).getDisco() instanceof CD){
				dati[i][1] = "CD";
			}else{
				dati[i][1] = "DVD";
			}
			
			dati[i][2] = disco.getTitolo();
			dati[i][3] = disco.getTitolare().getNomeArte();
			if (disco.getFotografie().size() > 0){
				dati[i][4] = disco.getFotografie().get(0);
			}
			dati[i][5] = disco.getGenere().toString();
			dati[i][6] = String.valueOf(disco.getPrezzo());				
			dati[i][7] = String.valueOf(pezzi.get(i).getOccorrenza());
			
		}
		
	    ViewTable tabella=new ViewTable(dati, titoli);
	    tabella.setBounds(30,40,300,300);
	    RowListener listener = new RowListener(pezzi);
        tabella.addMouseListener(listener);
	    
	    JScrollPane sp=new JScrollPane(tabella);    
	    this.add(sp);
		
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	

}
