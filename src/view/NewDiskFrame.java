package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

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
import javax.swing.SpinnerDateModel;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class NewDiskFrame extends JFrame {

	private JPanel contentPane;
	private JTextField titoloField;
	private JTextField tracceField;
	private JTextField prezzoField;
	
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
	private JSpinner dateSpinner;
	
	public NewDiskFrame(AdminFrame frame, Magazzino magazzino) {
		
		this.magazzino = magazzino;
		listaFoto = new ArrayList<>();
		strumentiSuonati = new ArrayList<>();
		
		NewDiskListener listener = new NewDiskListener(this, frame, magazzino);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 536);
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
		
		SpinnerDateModel spinnerModel = new SpinnerDateModel();
		dateSpinner = new JSpinner(spinnerModel);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		dateSpinner.setEditor(editor);
		
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addComponent(genere)
					.addGap(44)
					.addComponent(genereBox, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(cd)
					.addGap(18)
					.addComponent(dvd)
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(311)
							.addComponent(occorrenze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(121, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(descrizione)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(prezzo)
										.addComponent(tracce)
										.addComponent(dataRilascio)
										.addComponent(artista)
										.addComponent(titolo))
									.addGap(52)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(titoloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(131)
											.addComponent(lblOccorrenze))
										.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
									.addGap(3)))
							.addGap(8)
							.addComponent(fotografieButton)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(addMusicista)
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addComponent(confermaButton)
							.addGap(227))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(118))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(titolo)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tracce)
									.addGap(18)
									.addComponent(prezzo)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblOccorrenze))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(occorrenze, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(17))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(dataRilascio)
									.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(titoloField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tracceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(prezzoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(48)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(artistaBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(fotografieButton))
						.addComponent(artista))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(descrizione)
					.addGap(18)
					.addComponent(descrizioneText, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(genere))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(genereBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cd)
								.addComponent(dvd))))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addMusicista)
						.addComponent(confermaButton))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
		
		fotografieButton.addActionListener(listener);
		addMusicista.addActionListener(listener);
		confermaButton.addActionListener(new NewDiskListener(this, frame, magazzino));
		
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
		String dataLetta = dateSpinner.getValue().toString();
		
		String data[] = dataLetta.split("/");
		
		if (data[0].length() > 0 && data[1].length() > 0 && data[2].length() > 0){
			return new Date(Integer.parseInt(data[0]), 
							Integer.parseInt(data[1]),
							Integer.parseInt(data[2]));
			
			
		}
		
		System.out.println(data);
		
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