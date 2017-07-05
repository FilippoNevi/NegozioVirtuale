package view;

import static javax.swing.GroupLayout.Alignment.BASELINE;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controller.MainFrameListener;
import controller.SignUpListener;
import model.Cliente;
import model.Magazzino;
import model.Utente;

/**
 * Frame che gestisce l'inserimento dei dati del cliente che vuole effettuare una registrazione alla piattaforma
 *
 */
public class SignUpFrame extends JFrame {
	
	private JLabel codiceFiscale;
	private JLabel username;
	private JLabel password;
	private JLabel confirmPassword;
	private JLabel nome;
	private JLabel cognome;
	private JLabel residenza;
	private JLabel telefonoCasa;
	private JLabel cellulare;
	
	private JFormattedTextField codiceFiscaleField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField residenzaField;
	private JFormattedTextField telefonoCasaField;
	private JTextField cellulareField;
	
	private JButton confirmButton;
	
	private Magazzino magazzino;
	
	public SignUpFrame(String titolo, Magazzino magazzino) {
		super(titolo);
		
		setMinimumSize(new Dimension(350, 250));
		
		codiceFiscale = new JLabel("Codice Fiscale:");
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		confirmPassword = new JLabel("Conferma password: ");
		nome = new JLabel("Nome:");
		cognome = new JLabel("Cognome:");
		residenza = new JLabel("Residenza:");
		telefonoCasa = new JLabel("Telefono Fisso:");
		cellulare = new JLabel("Cellulare:");
		
		try {
			codiceFiscaleField = new JFormattedTextField(new MaskFormatter("AAAAAAAAAAAAAAAA"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		confirmPasswordField = new JPasswordField(20);
		nomeField = new JTextField(20);
		cognomeField = new JTextField(20);
		residenzaField = new JTextField(20);
		
		try {
			telefonoCasaField = new JFormattedTextField(new MaskFormatter("##########"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		cellulareField = new JTextField();
		
		confirmButton = new JButton("Conferma");
		
		this.magazzino = magazzino;
		
		GroupLayout mainLayout = new GroupLayout(getContentPane());
		
		getContentPane().setLayout(mainLayout);
		mainLayout.setAutoCreateGaps(true);
		mainLayout.setAutoCreateContainerGaps(true);
		
		mainLayout.setHorizontalGroup(mainLayout.createSequentialGroup()
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(codiceFiscale)
					.addComponent(username)
					.addComponent(password)
					.addComponent(confirmPassword)
					.addComponent(nome)
					.addComponent(cognome)
					.addComponent(residenza)
					.addComponent(telefonoCasa)
					.addComponent(cellulare)
					.addComponent(confirmButton))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(codiceFiscaleField)
					.addComponent(usernameField)
					.addComponent(passwordField)
					.addComponent(confirmPasswordField)
					.addComponent(nomeField)
					.addComponent(cognomeField)
					.addComponent(residenzaField)
					.addComponent(telefonoCasaField)
					.addComponent(cellulareField))
				.addComponent(confirmButton));
			

		mainLayout.setVerticalGroup(mainLayout.createSequentialGroup()
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(codiceFiscale)
					.addComponent(codiceFiscaleField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(username)
					.addComponent(usernameField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(password)
					.addComponent(passwordField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(confirmPassword)
					.addComponent(confirmPasswordField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(nome)
					.addComponent(nomeField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(cognome)
					.addComponent(cognomeField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(residenza)
					.addComponent(residenzaField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(telefonoCasa)
					.addComponent(telefonoCasaField))
				.addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(cellulare)
					.addComponent(cellulareField))
				.addComponent(confirmButton)
				);
		
		this.pack();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		confirmButton.addActionListener(new SignUpListener(this, magazzino));
	}
	
	public String getCF(){
		return codiceFiscaleField.getText();
	}
	
	public String getUsername(){
		return usernameField.getText();
	}
	
	public String getPassword(){
		return passwordField.getText();
	}
	
	public String getConfirmPassword(){
		return confirmPasswordField.getText();
	}
	
	public String getNome(){
		return nomeField.getText();
	}
	
	public String getCognome(){
		return cognomeField.getText();
	}
	
	public String getResidenza(){
		return residenzaField.getText();
	}
	
	public String getCellulare(){
		return cellulareField.getText();
	}
	
	public String getTelefonoCasa(){
		return telefonoCasa.getText();
	}
	
}
