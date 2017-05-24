package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Disco;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Canvas;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

public class DettagliFrame extends JFrame {
	private Disco disco;

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=49,67
	 */
	private final Canvas foto = new Canvas();
	private JTable tracce;
	private JTable strumenti;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DettagliFrame frame = new DettagliFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public DettagliFrame(String titolo, Disco disco) {
		super(titolo);
		
		this.disco = disco;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitolo = new JLabel(disco.getTitolo());
		lblTitolo.setFont(new Font("Ubuntu", Font.BOLD, 20));
		
		JLabel lblArtista = new JLabel(disco.getTitolare().getNomeArte());
		lblArtista.setFont(new Font("Ubuntu", Font.BOLD, 16));
		
		JLabel lblGenere = new JLabel(disco.getGenere().toString());
		lblGenere.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		JLabel lblData = new JLabel(disco.getRilascio().toString());
		lblData.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		JLabel lblPrezzo = new JLabel(String.format("%.2f", disco.getPrezzo()));
		lblPrezzo.setFont(new Font("Ubuntu", Font.BOLD, 16));
		
		JButton btnCompra = new JButton("Compra");
		btnCompra.setFont(new Font("Serif", Font.BOLD, 12));
		
		Object[][] datiTracce = new Object[disco.getTracce().size()][1];
		for(int i = 0; i < disco.getTracce().size(); i++) {
			datiTracce[i][0] = disco.getTracce().get(i);
		}
		
		Object[][] datiStrumenti = new Object[disco.getStrumenti().size()][2];
		for(int i = 0; i < disco.getStrumenti().size(); i++) {
			datiStrumenti[i][0] = disco.getStrumenti().get(i).getStrumento();	// Trasformando la matrice in vettore
			datiStrumenti[i][1] = disco.getStrumenti().get(i).getMusicista();
		}
		
		
		tracce = new JTable(datiTracce, new String[]{"Traccia"});
		tracce.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		
		strumenti = new JTable(datiStrumenti, new String[]{"Strumenti", "Musicista"});
		strumenti.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		
		
		JLabel lblDescrizione = new JLabel(disco.getDescrizione());
		lblDescrizione.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tracce, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(strumenti, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(lblDescrizione, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblData)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblArtista)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblTitolo)
								.addPreferredGap(ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
								.addComponent(lblPrezzo)
								.addGap(46)
								.addComponent(btnCompra)
								.addGap(38))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblGenere)
								.addContainerGap()))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezzo)
						.addComponent(btnCompra)
						.addComponent(lblTitolo))
					.addGap(27)
					.addComponent(lblArtista)
					.addGap(18)
					.addComponent(lblGenere)
					.addGap(18)
					.addComponent(lblData)
					.addGap(95)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tracce, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addComponent(strumenti, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDescrizione)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
