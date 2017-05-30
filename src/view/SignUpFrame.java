package view;

import static javax.swing.GroupLayout.Alignment.BASELINE;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.MainFrameListener;
import model.Cliente;
import model.Magazzino;
import model.Utente;

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
	
	private JTextField codiceFiscaleField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField residenzaField;
	private JTextField telefonoCasaField;
	private JTextField cellulareField;
	
	private JButton confirmButton;
	
	private Magazzino magazzino;
	
	public SignUpFrame(String titolo, Magazzino magazzino) {
		super(titolo);
		
		codiceFiscale = new JLabel("Codice Fiscale:");
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		confirmPassword = new JLabel("Conferma password: ");
		nome = new JLabel("Nome:");
		cognome = new JLabel("Cognome:");
		residenza = new JLabel("Residenza:");
		telefonoCasa = new JLabel("Telefono Fisso:");
		cellulare = new JLabel("Cellulare:");
		
		codiceFiscaleField = new JTextField(20);
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		confirmPasswordField = new JPasswordField(20);
		nomeField = new JTextField(20);
		cognomeField = new JTextField(20);
		residenzaField = new JTextField(20);
		telefonoCasaField = new JTextField(20);
		cellulareField = new JTextField(20);
		
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
		
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (passwordField.getText().equals(confirmPasswordField.getText()) &&
						codiceFiscaleField.getText().length() > 0 &&
						usernameField.getText().length() > 0 &&
						passwordField.getText().length() > 0 &&
						nomeField.getText().length() > 0 &&
						cognomeField.getText().length() > 0 &&
						residenzaField.getText().length() > 0 &&
						telefonoCasa.getText().length() > 0 &&
						cellulare.getText().length() > 0){
					
					Utente u = new Cliente(
								codiceFiscaleField.getText(),
								usernameField.getText(),
								passwordField.getText(),
								nomeField.getText(),
								cognomeField.getText(),
								residenzaField.getText(),
								telefonoCasa.getText(),
								cellulare.getText()
							);
					if (!magazzino.addUtente(u)){
						JOptionPane.showMessageDialog(SignUpFrame.this,
							    "Utente già inserito",
							    "Errore",
							    JOptionPane.ERROR_MESSAGE);
					}else{
						SignUpFrame.this.setVisible(false);
						magazzino.salva();
					}
				}
				else{
					JOptionPane.showMessageDialog(SignUpFrame.this,
						    "Le password non coincidono",
						    "Errore",
						    JOptionPane.ERROR_MESSAGE);
				}
					
			}
	
		});
	}
}
