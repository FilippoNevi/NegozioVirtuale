package view;

import javax.swing.*;

import model.Cliente;

public class ClientFrame extends JFrame {
	
	private Cliente cliente;
	
	private JLabel tipo;
	private JLabel titolo;
	private JLabel artista;
	private JLabel foto;
	private JLabel prezzo;
	
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
	
	
	public ClientFrame(String titoloFrame) {
		super(titoloFrame);
		
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
		
		    String data[][]={ {"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"},{"101","Amit","670000"},    
                    {"102","Jai","780000"},    
                    {"101","Sachin","700000"}};    
		    String column[]={"ID","NAME","SALARY"};         
		    JTable jt=new JTable(data,column);    
		    jt.setBounds(30,40,200,300);          
		    JScrollPane sp=new JScrollPane(jt);    
		    this.add(sp);
		
		this.setJMenuBar(menuBar);
		//this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		ClientFrame f = new ClientFrame("Ciao");
	}
}
