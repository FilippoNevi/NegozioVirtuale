package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.NewMusicianListener;
import model.Artista;
import model.Band;
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
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class NewMusicianFrame extends JFrame {
	
	public final static String DELIMITER = ";";
	
	private Magazzino magazzino;
		
	private JPanel contentPane;
	private JTextField nomeArte;
	private JTextField giornoField;
	private JTextField meseField;
	private JTextField annoField;
	private JTextField strumentiField;
	
	private JRadioButton bandRadio;
	private JRadioButton musicistaRadio;
	private JComboBox comboGeneri;


	public NewMusicianFrame(Magazzino magazzino) {
		
		this.magazzino = magazzino;
		

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
		
		giornoField = new JTextField();
		giornoField.setText("GG");
		giornoField.setToolTipText("");
		giornoField.setColumns(2);
		
		meseField = new JTextField();
		meseField.setText("MM");
		meseField.setColumns(2);
		
		annoField = new JTextField();
		annoField.setText("AAAA");
		annoField.setColumns(4);
		
		JLabel lblStrumenti = new JLabel("Strumenti");
		
		strumentiField = new JTextField();
		strumentiField.setColumns(10);
		
		bandRadio = new JRadioButton("Band");
		bandRadio.setSelected(true);
		
		musicistaRadio = new JRadioButton("Musicista");
		
		ButtonGroup group = new ButtonGroup();
		group.add(bandRadio);
		group.add(musicistaRadio);
			
		JButton btnConferma = new JButton("Conferma");
				
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
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(giornoField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(meseField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(annoField, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboGeneri, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(nomeArte))
								.addComponent(strumentiField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bandRadio)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnConferma)
								.addComponent(musicistaRadio))))
					.addContainerGap(55, Short.MAX_VALUE))
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
						.addComponent(giornoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(meseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(annoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrumenti)
						.addComponent(strumentiField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bandRadio)
						.addComponent(musicistaRadio))
					.addGap(60)
					.addComponent(btnConferma)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setVisible(true);
		
		btnConferma.addActionListener(new NewMusicianListener(this, magazzino));
	}
	
	public String getNomeArte(){
		return nomeArte.getText();
	}
	
	public Date getNascita(){
		String giorno = giornoField.getText();
		String mese = meseField.getText();
		String anno = annoField.getText();
		
		if (giorno.length() > 0 && mese.length() > 0 && anno.length() > 0){
			return new Date(Integer.parseInt(anno), 
							Integer.parseInt(mese),
							Integer.parseInt(giorno));
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
}