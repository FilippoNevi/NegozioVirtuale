package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DiskListener;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;

public class NewDiskFrame extends JFrame {

	private JPanel contentPane;
	private JTextField titoloField;
	private JTextField tracceField;
	private JTextField prezzoField;
	private JTextField dataRilascioText;
	
	private File foto;
	
	public void setFoto(File foto) {
		this.foto = foto;
	}
	
	public static void main(String[] args) {
		new NewDiskFrame();
	}

	/**
	 * Create the frame.
	 */
	public NewDiskFrame() {
		DiskListener listener = new DiskListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel titolo = new JLabel("Titolo");
		
		titoloField = new JTextField();
		titoloField.setColumns(10);
		
		JLabel tracce = new JLabel("Tracce");
		
		tracceField = new JTextField();
		tracceField.setColumns(10);
		
		JButton fotografieButton = new JButton("Fotografie");
		
		JLabel prezzo = new JLabel("Prezzo");
		
		prezzoField = new JTextField();
		prezzoField.setColumns(10);
		
		JLabel dataRilascio = new JLabel("Data rilascio");
		
		dataRilascioText = new JTextField();
		dataRilascioText.setColumns(10);
		
		JLabel artista = new JLabel("Artista");
		artista.setBackground(Color.WHITE);
		
		JComboBox artistaBox = new JComboBox();
		
		JLabel descrizione = new JLabel("Descrizione");
		
		JTextArea descrizioneText = new JTextArea();
		descrizioneText.setBackground(UIManager.getColor("TabbedPane.tabAreaBackground"));
		descrizioneText.setForeground(Color.BLACK);
		descrizioneText.setWrapStyleWord(true);
		descrizioneText.setLineWrap(true);
		descrizioneText.setText("Descrizione");
		
		JLabel genere = new JLabel("Genere");
		
		JComboBox genereBox = new JComboBox();
		
		JLabel strumenti = new JLabel("Strumenti");
		
		JComboBox strumentiBox = new JComboBox();
		
		JButton confermaButton = new JButton("Conferma");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(fotografieButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(prezzo)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(titolo)
									.addComponent(tracce))
								.addGap(62)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(titoloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dataRilascio)
								.addComponent(artista)
								.addComponent(descrizione)
								.addComponent(genere)
								.addComponent(strumenti))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
								.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataRilascioText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(strumentiBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(genereBox, Alignment.LEADING, 0, 95, Short.MAX_VALUE)))))
					.addContainerGap(85, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(261, Short.MAX_VALUE)
					.addComponent(confermaButton)
					.addGap(257))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(titolo)
						.addComponent(titoloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tracce)
						.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(fotografieButton)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezzo)
						.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dataRilascio)
						.addComponent(dataRilascioText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(artista)
						.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(descrizione)
						.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(genere)
						.addComponent(genereBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(strumenti)
						.addComponent(strumentiBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(confermaButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		fotografieButton.addActionListener(listener);
		
		this.setVisible(true);
	}
}
