package view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

import controller.NewFrameListener;

/*
 * Prima schermata del programma
 * L'utente sceglie se fare il login
 * o se registrarsi
 */

public class MainFrame extends JFrame {	
	// Attributi loginPanel
	private JLabel username;
	private JLabel password;
	private JTextField usrField;
	private JTextField pwdField;
	
	// Attributi buttonsPanel
	private JButton loginButton;
	private JButton signUpButton;
	
	private NewFrameListener listener;
	
	public MainFrame(String titolo) {
		super(titolo);
		
		this.username = new JLabel("Username:");
		this.password = new JLabel("Password:");
		this.usrField = new JTextField();
		this.pwdField = new JTextField();
		
		this.loginButton = new JButton("Login");
		this.signUpButton = new JButton("Sign Up");
		
		GridLayout mainLayout = new GridLayout(2, 1);
		JPanel mainPanel = new JPanel(mainLayout);
		
		GridLayout loginLayout = new GridLayout(2, 2);
		JPanel loginPanel = new JPanel(loginLayout);
		
		GridLayout buttonsLayout = new GridLayout(2, 1);
		JPanel buttonsPanel = new JPanel(buttonsLayout);
		
		mainPanel.setBounds(50, 50, 50, 50);
		mainPanel.add(loginPanel);
		mainPanel.add(buttonsPanel);
		this.setContentPane(mainPanel);
		
		loginPanel.add(username);
		loginPanel.add(usrField);
		loginPanel.add(password);
		loginPanel.add(pwdField);
		
		buttonsPanel.add(loginButton);
		buttonsPanel.add(signUpButton);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(220, 100);
		this.setVisible(true);
		
		listener = new NewFrameListener(this);
		signUpButton.addActionListener(listener);
	}
	
	public static void main(String[] args) {
		MainFrame finestra = new MainFrame("Negozio Online");
	}
}
