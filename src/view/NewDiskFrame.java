package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.NewDiskListener;
import model.Artista;
import model.Generi;
import model.Magazzino;
import model.StrumentoSuonato;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class NewDiskFrame extends JFrame {

	private JPanel contentPane;
	private JTextField titoloField;
	private JTextField tracceField;
	private JTextField prezzoField;
	private JTextField giornoRilascio;
	private JTextField meseRilascio;
	private JTextField annoRilascio;
	
	private JComboBox artistaBox;
	private JTextArea descrizioneText;
	private JComboBox genereBox;
	private JRadioButton cd;
	private JRadioButton dvd;
	private JSlider occorrenze;
	private JLabel lblOccorrenze;
	
	private List<String> listaFoto;	
	private Magazzino magazzino;
	private List<StrumentoSuonato> strumentiSuonati;
	
	public NewDiskFrame(Magazzino magazzino) {
		
		this.magazzino = magazzino;
		listaFoto = new ArrayList<>();
		strumentiSuonati = new ArrayList<>();
		
		NewDiskListener listener = new NewDiskListener(this, magazzino);
		
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
		
		giornoRilascio = new JTextField();
		giornoRilascio.setText("GG");
		giornoRilascio.setColumns(2);
		
		JLabel artista = new JLabel("Artista");
		artista.setBackground(Color.WHITE);
		
		List<Artista> listaArtisti = magazzino.getArtisti();
		String[] list = new String[listaArtisti.size()];
		
		for (int i = 0; i < listaArtisti.size(); i++)
			list[i] = listaArtisti.get(i).getNomeArte();
		
		artistaBox = new JComboBox(list);
		
		JLabel descrizione = new JLabel("Descrizione");
		
		descrizioneText = new JTextArea();
		descrizioneText.setBackground(UIManager.getColor("TabbedPane.tabAreaBackground"));
		descrizioneText.setForeground(Color.BLACK);
		descrizioneText.setWrapStyleWord(true);
		descrizioneText.setLineWrap(true);
		descrizioneText.setText("Descrizione");
		
		JLabel genere = new JLabel("Genere");
		
		genereBox = new JComboBox(Generi.values());
		
		JButton confermaButton = new JButton("Conferma");
		
		meseRilascio = new JTextField();
		meseRilascio.setText("MM");
		meseRilascio.setColumns(2);
		
		annoRilascio = new JTextField();
		annoRilascio.setText("AAAA");
		annoRilascio.setColumns(4);
		
		cd = new JRadioButton("CD");
		
		dvd = new JRadioButton("DVD");
		ButtonGroup group = new ButtonGroup();
		group.add(cd);
		group.add(dvd);
		
		cd.setSelected(true);
			
		occorrenze = new JSlider(1, 100);
		occorrenze.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblOccorrenze.setText("Occorrenze: " + occorrenze.getValue());
				
			}
		});
		
		lblOccorrenze = new JLabel("Occorrenze: " + occorrenze.getValue());
		
		JButton addMusicista = new JButton("Aggiungi un musicista");
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(titolo)
									.addComponent(tracce)
									.addComponent(prezzo, Alignment.TRAILING))
								.addComponent(artista)
								.addComponent(descrizione)
								.addComponent(genere)
								.addComponent(dataRilascio))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, 391, Short.MAX_VALUE)
								.addComponent(genereBox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
											.addGap(65))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(titoloField, Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(giornoRilascio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(meseRilascio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(annoRilascio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
											.addGap(65)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(cd)
											.addGap(18)
											.addComponent(dvd))
										.addComponent(fotografieButton)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(47)
											.addComponent(lblOccorrenze))
										.addComponent(occorrenze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 207, Short.MAX_VALUE)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(addMusicista)
							.addPreferredGap(ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
							.addComponent(confermaButton)
							.addGap(227))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(titolo)
						.addComponent(titoloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblOccorrenze))
						.addComponent(tracce))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(occorrenze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(prezzo)
						.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(giornoRilascio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataRilascio)
						.addComponent(meseRilascio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(annoRilascio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fotografieButton))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(artista)
						.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cd)
						.addComponent(dvd))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(descrizione)
						.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(genere)
						.addComponent(genereBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addMusicista)
						.addComponent(confermaButton))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
		
		fotografieButton.addActionListener(listener);
		addMusicista.addActionListener(listener);
		confermaButton.addActionListener(new NewDiskListener(this, magazzino));
		
		this.setVisible(true);
		
	}
	
	public String getTitolo(){
		return titoloField.getText();
	}
	
	public List<String> getTracce(){
		String[] tracce = tracceField.getText().split(NewMusicianFrame.DELIMITER);
		List<String> lista = new ArrayList<>();
		
		for (String s : tracce)
			lista.add(s);
		return lista;
	}
	
	public float getPrezzo(){
		if (prezzoField.getText().length() > 0)
			return Float.parseFloat(prezzoField.getText());
		return 0;
	}
		
	public void addStrumentoSuonato(StrumentoSuonato strumento){
		strumentiSuonati.add(strumento);
	}
	
	public List<StrumentoSuonato> getStrumentoSuonato(){
		return strumentiSuonati;
	}
	
	public Date getDataRilascio() {
		String giorno = giornoRilascio.getText();
		String mese = meseRilascio.getText();
		String anno = annoRilascio.getText();
		
		if (giorno.length() > 0 && mese.length() > 0 && anno.length() > 0){
			return new Date(Integer.parseInt(anno), 
							Integer.parseInt(mese),
							Integer.parseInt(giorno));
			
		}
		return null;
	}
	
	public String getArtista(){
		return artistaBox.getSelectedItem().toString();
	}
	
	public String getDescrizione(){
		return descrizioneText.getText();
	}
	
	public void addFoto(String url) {
		listaFoto.add(url);
	}
	
	public List<String> getFoto(){
		return listaFoto;
	}
	
	public Generi getGenere(){
		return Generi.values()[genereBox.getSelectedIndex()];
	}
	
	public boolean isCD(){
		return cd.isSelected();
	}

	public boolean isDVD(){
		return dvd.isSelected();
	}
	
	public int getOccorrenze(){
		return occorrenze.getValue();
	}
}