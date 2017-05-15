package view;

import java.awt.GridLayout;

import javax.swing.*;

public class SignUpFrame extends JFrame {
	
	private JLabel codiceFiscale;
	private JLabel username;
	private JLabel password;
	private JLabel nome;
	private JLabel cognome;
	private JLabel residenza;
	private JLabel telefonoCasa;
	private JLabel cellulare;
	
	private JTextField codiceFiscaleField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField residenzaField;
	private JTextField telefonoCasaField;
	private JTextField cellulareField;
	
	private JButton confirmButton;
	
	public SignUpFrame(String titolo) {
		super(titolo);
		
		codiceFiscale = new JLabel("Codice Fiscale:");
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		nome = new JLabel("Nome:");
		cognome = new JLabel("Cognome:");
		residenza = new JLabel("Residenza:");
		telefonoCasa = new JLabel("Telefono Fisso:");
		cellulare = new JLabel("Cellulare:");
		
		codiceFiscaleField = new JTextField();
		usernameField = new JTextField();
		passwordField = new JTextField();
		nomeField = new JTextField();
		cognomeField = new JTextField();
		residenzaField = new JTextField();
		telefonoCasaField = new JTextField();
		cellulareField = new JTextField();
		
		confirmButton = new JButton("Conferma");
		
		GridLayout mainLayout = new GridLayout(2, 1);
		JPanel mainPanel = new JPanel(mainLayout);
		
		GridLayout dataLayout = new GridLayout(8, 2);
		JPanel dataPanel = new JPanel(dataLayout);
		
		dataPanel.add(codiceFiscale);
		dataPanel.add(codiceFiscaleField);
		dataPanel.add(username);
		dataPanel.add(usernameField);
		dataPanel.add(password);
		dataPanel.add(passwordField);
		dataPanel.add(nome);
		dataPanel.add(nomeField);
		dataPanel.add(cognome);
		dataPanel.add(cognomeField);
		dataPanel.add(residenza);
		dataPanel.add(residenzaField);
		dataPanel.add(telefonoCasa);
		dataPanel.add(telefonoCasaField);
		dataPanel.add(cellulare);
		dataPanel.add(cellulareField);
		
		JPanel confirmPanel = new JPanel();
		confirmPanel.add(confirmButton);
		
		mainPanel.add(dataPanel);
		mainPanel.add(confirmPanel);
		
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
