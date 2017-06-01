package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import controller.NewMusicianListener;
import model.Artista;
import model.Band;
import model.Date;
import model.Generi;
import model.Magazzino;
import model.Musicista;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

/**
 * Frame che si occupa dell'inserimento dei dati di un nuovo Artista nella struttura dati. Visibile solo al PersonaleAutorizzato
 *
 */
public class NewMusicianFrame extends JFrame implements ActionListener{
	
	public final static String DELIMITER = ";";
	
	private Magazzino magazzino;
		
	private JPanel contentPane;
	private JTextField nomeArte;
	private JTextField strumentiField;
	
	private JRadioButton bandRadio;
	private JRadioButton musicistaRadio;
	private JComboBox comboGeneri;
	private JSpinner dateSpinner;
	private JCheckBox conoscoLaData;


	public NewMusicianFrame(Magazzino magazzino) {
		
		this.magazzino = magazzino;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomeDarte = new JLabel("Nome d'Arte");
		
		nomeArte = new JTextField();
		nomeArte.setColumns(10);
		
		JLabel lblGenere = new JLabel("Genere");
		
		comboGeneri = new JComboBox(Generi.values());
		
		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		
		JLabel lblStrumenti = new JLabel("Strumenti");
		
		strumentiField = new JTextField();
		strumentiField.setColumns(10);
		
		bandRadio = new JRadioButton("Band");
		bandRadio.addActionListener(this);
		
		musicistaRadio = new JRadioButton("Musicista");
		musicistaRadio.addActionListener(this);
		musicistaRadio.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(bandRadio);
		group.add(musicistaRadio);
			
		JButton btnConferma = new JButton("Conferma");
		
		SpinnerDateModel spinnerModel = new SpinnerDateModel();
		dateSpinner = new JSpinner(spinnerModel);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
		DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		dateSpinner.setEditor(editor);
		
		conoscoLaData = new JCheckBox("Conosco la data");
		conoscoLaData.setSelected(true);
		conoscoLaData.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeDarte)
								.addComponent(lblGenere)
								.addComponent(lblDataDiNascita)
								.addComponent(lblStrumenti))
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(strumentiField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeArte, 208, 208, 208)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(conoscoLaData))
									.addComponent(comboGeneri, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bandRadio)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConferma)
								.addComponent(musicistaRadio))))
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDarte)
						.addComponent(nomeArte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenere)
						.addComponent(comboGeneri, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDiNascita)
						.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(conoscoLaData))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrumenti)
						.addComponent(strumentiField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bandRadio)
						.addComponent(musicistaRadio))
					.addGap(60)
					.addComponent(btnConferma)
					.addContainerGap(87, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setVisible(true);
		
		btnConferma.addActionListener(new NewMusicianListener(this, magazzino));
	}
	
	public String getNomeArte(){
		return nomeArte.getText();
	}
	
	public Date getNascita() {
		
		if (conoscoLaData.isSelected()){
			String dataLetta = new SimpleDateFormat("dd/MM/yyyy").format(dateSpinner.getValue());
			
			String data[] = dataLetta.split("/");
			
			return new Date(Integer.parseInt(data[2]), 
						    Integer.parseInt(data[1]), 
						    Integer.parseInt(data[0]));
				
			
		}		
		
		return null;
	}
	public List<String> getStrumenti(){
		String[] strumenti = strumentiField.getText().split(DELIMITER);
		List<String> lista = new ArrayList<>();
		
		for (String s : strumenti)
			lista.add(s);
		
		return lista;
	} 
	
	public boolean isMusicista(){
		return musicistaRadio.isSelected();
	}
	
	public boolean isBand(){
		return bandRadio.isSelected();
	}
	
	public Generi getGenere(){
		return Generi.values()[comboGeneri.getSelectedIndex()];
	}

	/**
	 * Se voglio inserire una band, disattivo l'elenco degli strumenti usati. Se non conosco la data di nascita
	 * disattivo lo spinner della data
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JRadioButton){
			JRadioButton src = (JRadioButton)e.getSource();
			
			if (src.getText().equals("Band")){
				strumentiField.setEnabled(false);
			}
			else
				strumentiField.setEnabled(true);
		}
		
		if (e.getSource() instanceof JCheckBox){
			JCheckBox src = (JCheckBox)e.getSource();
			
			if (src == conoscoLaData && src.isSelected()){
				dateSpinner.setEnabled(true);
			}
			else if (src == conoscoLaData && !src.isSelected()){
				dateSpinner.setEnabled(false);;
			}
		}
		
	}
}