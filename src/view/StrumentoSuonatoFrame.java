package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controller.StrumentoSuonatoListener;
import model.Magazzino;
import model.Musicista;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class StrumentoSuonatoFrame extends JFrame implements PopupMenuListener {

	private JPanel contentPane;
	private Magazzino magazzino;
	private JComboBox strumentiBox;
	private JComboBox musicistiBox;
	private NewDiskFrame frame;
	
	public StrumentoSuonatoFrame(NewDiskFrame frame, Magazzino magazzino) {
		this.magazzino = magazzino;
		this.frame = frame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMusicista = new JLabel("Musicista");
		
		List<Musicista> musicisti = magazzino.getMusicisti();
		Musicista[] elementi = musicisti.toArray(new Musicista[musicisti.size()]);
		
		musicistiBox = new JComboBox(elementi);
		
		JLabel lblStrumento = new JLabel("Strumento");
				
		strumentiBox = new JComboBox();
		strumentiBox.addPopupMenuListener(this);
		musicistiBox.addPopupMenuListener(this);
		
		JButton btnConferma = new JButton("Conferma");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblStrumento)
									.addGap(31)
									.addComponent(strumentiBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMusicista)
									.addGap(47)
									.addComponent(musicistiBox, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(153)
							.addComponent(btnConferma)))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMusicista)
						.addComponent(musicistiBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStrumento)
						.addComponent(strumentiBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(btnConferma)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnConferma.addActionListener(new StrumentoSuonatoListener(frame, this));
		
		this.setVisible(true);
	}

	
	public Musicista getMusicista(){
		return (Musicista)musicistiBox.getSelectedItem();
	}
	
	public String getStrumento(){
		return (String)strumentiBox.getSelectedItem();
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		strumentiBox.removeAllItems();
		Musicista selezionato = (Musicista)musicistiBox.getSelectedItem();
		List<String> listaStrumenti = selezionato.getStrumenti();
		
		
		for (String strumento : listaStrumenti)
			strumentiBox.addItem(strumento);
		
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		strumentiBox.removeAllItems();
		Musicista selezionato = (Musicista)musicistiBox.getSelectedItem();
		List<String> listaStrumenti = selezionato.getStrumenti();
		
		
		for (String strumento : listaStrumenti)
			strumentiBox.addItem(strumento);
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {}
	
	
}
