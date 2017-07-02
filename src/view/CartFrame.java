package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.CartListener;
import controller.MenuListener;
import model.Carrello;
import model.Cliente;
import model.Magazzino;
import model.ModelViewTable;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

/**
 * Frame che mostra al cliente l'elenco di dischi presenti nel suo carrello. Gestisce anche le interazioni tra utente - carrello, come
 * la rimozione di dischi 
 *
 */
public class CartFrame extends JFrame{

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenuItem logout;
	private JMenuItem exit;
	private CartListener listener;
	
	private Carrello carrello;
	
	private Magazzino magazzino;
	private ViewTable tabella;
	
	private MainFrame login;
	private ClientFrame client;

	public CartFrame(MainFrame login, ClientFrame client, Carrello carrello, Cliente cliente, Magazzino magazzino){
		
		this.magazzino = magazzino;
		this.login = login;
		this.client = client;
		this.setTitle("Carrello");
		
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		logout = new JMenuItem("Logout");
		exit = new JMenuItem("Exit");
		file.add(logout);
		file.add(exit);
		menuBar.add(file);
		listener = new CartListener(this, carrello, magazzino, login, client);
		
		logout.addActionListener(listener);
		exit.addActionListener(listener);
			
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 514);
		setMinimumSize(new Dimension(824,514));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				 
	
		JButton btnAcquista = new JButton("Acquista");
		
		tabella = new ViewTableFactory().getTable(ViewTableFactory.CART_TABLE);
		
		TableModel model = new ModelViewTable(carrello);
		
	    tabella.setModel(model);
	    tabella.addMouseListener(listener);
	    tabella.setRowHeight(50);
	    
	    updateTable(carrello);
	    
	    JScrollPane sp=new JScrollPane(tabella);
	    
	    
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(sp, GroupLayout.PREFERRED_SIZE, 632, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnAcquista)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(197)
							.addComponent(btnAcquista))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(sp, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
					.addGap(71))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		setJMenuBar(menuBar);
	}
	
	/**
	 * Aggiorna la tabella quando vado ad aggungere / eliminare un disco dal carrello della spesa
	 * @param carrello Carrello della spesa
	 */
	public void updateTable(Carrello carrello){
		ModelViewTable model = new ModelViewTable(carrello);
		tabella.setModel(model);
		tabella.removeMouseListener(listener);
		listener = new CartListener(this, carrello, magazzino, login, client);
		tabella.addMouseListener(listener);
	}
}