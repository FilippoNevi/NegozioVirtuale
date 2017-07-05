package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.TableModel;

import controller.BuyListener;
import controller.CartListener;
import controller.FilterListener;
import controller.MenuListener;
import controller.RowListener;
import controller.SortingMenu;
import controller.WindowClosedListener;
import model.*;

/**
 * Frame che mostra il catalogo al cliente. Implements SortingMenu in quanto possiede la tabella del catalogo che 
 * può essere ordinata o filtrata, in base alle preferenze
 *
 */
public class ClientFrame extends JFrame implements SortingMenu{
	
	private Cliente cliente;
	private Magazzino magazzino;
		
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem exit;
	
	private JMenu edit;
	private JMenu sort;
	private JMenuItem sortByGenere;
	private JMenuItem sortByTitolare;
	private JMenuItem sortByPrezzo;
	
	private MenuListener menuListener;
	private JTextField filtro;
	
	private ViewTable tabella;
	
	private JButton btnCerca;
	private JRadioButton titolareRadio;
	private JRadioButton partecipanteRadio;
	private JRadioButton prezzoRadio;
	private JRadioButton genereRadio;
	
	private RowListener listener;
	private JButton btnAnnulla;
	
	private MainFrame login;
	private JButton btnCarrello;
	
	
	public ClientFrame(String titolo, Magazzino magazzino, Cliente cliente, MainFrame login) {
		super(titolo);
		
		this.cliente = cliente;
		this.magazzino = magazzino;
		this.login = login;
		
		menuListener = new MenuListener(magazzino, this, login);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 549);
		setMinimumSize(new Dimension(300,200));
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		exit = new JMenuItem("Exit");
		file.add(logout);
		file.add(exit);
		
		edit = new JMenu("Edit");
		
		
		sort = new JMenu("Ordina per...");
		sortByGenere = new JMenuItem("Genere");
		sortByTitolare = new JMenuItem("Titolare");
		sortByPrezzo = new JMenuItem("Prezzo");
		sort.add(sortByGenere);
		sort.add(sortByTitolare);
		sort.add(sortByPrezzo);
		
		edit.add(sort);;
		menuBar.add(file);
		menuBar.add(edit);
		
		logout.addActionListener(menuListener);
		exit.addActionListener(menuListener);
		sortByGenere.addActionListener(menuListener);
		sortByPrezzo.addActionListener(menuListener);
		sortByTitolare.addActionListener(menuListener);
		
		
		tabella = new ViewTableFactory().getTable(ViewTableFactory.CLIENT_TABLE);
	 
		List<OccorrenzeDisco> dischi = magazzino.getCatalogo();
		TableModel model = new ModelViewTable(magazzino);
		
	    tabella.setBounds(30,40,300,300);
	    tabella.setModel(model);
	    tabella.addMouseListener(listener);
	    tabella.setRowHeight(50);
	    
	    updateTable(magazzino.getCatalogo());
	   	        
	    JScrollPane sp=new JScrollPane(tabella);
	    
	    filtro = new JTextField();
	    filtro.setColumns(50);
	    
	    btnCerca = new JButton("Cerca");
	    genereRadio = new JRadioButton("Genere");
	    titolareRadio = new JRadioButton("Titolare");
	    partecipanteRadio = new JRadioButton("Partecipante");
	    prezzoRadio = new JRadioButton("Prezzo");
	    	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(genereRadio);
	    group.add(titolareRadio);
	    group.add(partecipanteRadio);
	    group.add(prezzoRadio);
	    
	    genereRadio.setSelected(true);
	    
	    btnAnnulla = new JButton("Annulla");
	    
	    FilterListener filterListener = new FilterListener(magazzino, this);
	    btnCerca.addActionListener(filterListener);	    
	    btnAnnulla.addActionListener(filterListener);
	    
	    btnCarrello = new JButton("Carrello");
	    btnCarrello.addActionListener(new BuyListener(cliente, magazzino, login, this, null));
	
	    GroupLayout groupLayout = new GroupLayout(getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(sp, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
	    			.addContainerGap())
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(20)
	    					.addComponent(btnCerca)
	    					.addGap(18)
	    					.addComponent(filtro, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(133)
	    					.addComponent(btnAnnulla)))
	    			.addGap(52)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(genereRadio)
	    				.addComponent(titolareRadio))
	    			.addGap(26)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(prezzoRadio)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(partecipanteRadio)
	    					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
	    					.addComponent(btnCarrello)
	    					.addGap(31))))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(35)
	    			.addComponent(sp, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	    			.addGap(48)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(filtro, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(genereRadio)
	    				.addComponent(btnCerca)
	    				.addComponent(partecipanteRadio)
	    				.addComponent(btnCarrello))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(titolareRadio)
	    				.addComponent(prezzoRadio)
	    				.addComponent(btnAnnulla))
	    			.addContainerGap(40, Short.MAX_VALUE))
	    );
	    getContentPane().setLayout(groupLayout);
		
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void updateTable(List<OccorrenzeDisco> elementi){
				
		ModelViewTable model = new ModelViewTable(elementi);
		tabella.setModel(model);
		tabella.removeMouseListener(listener);
		listener = new RowListener(this, elementi, magazzino, cliente, login);
		tabella.addMouseListener(listener);
		
	}

	@Override
	public boolean isForGenere() {
		return genereRadio.isSelected();
	}

	@Override
	public boolean isForPartecipante() {
		return partecipanteRadio.isSelected();
	}

	@Override
	public boolean isForPrezzo() {
		return prezzoRadio.isSelected();
	}

	@Override
	public boolean isForTitolare() {
		return titolareRadio.isSelected();
	}

	@Override
	public String getFilter() {
		return filtro.getText();
	}

	@Override
	public void resetFilter(){
		filtro.setText("");
	}
	
}
