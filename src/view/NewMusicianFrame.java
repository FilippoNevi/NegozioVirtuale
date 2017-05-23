package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

public class NewMusicianFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nomeArte;
	private JTextField giornoField;
	private JTextField meseField;
	private JTextField annoField;
	private JTextField strumentiField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMusicianFrame frame = new NewMusicianFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewMusicianFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNomeDarte = new JLabel("Nome d'Arte");
		
		nomeArte = new JTextField();
		nomeArte.setColumns(10);
		
		JLabel lblGenere = new JLabel("Genere");
		
		JComboBox comboBox = new JComboBox();
		
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
		
		JRadioButton bandRadio = new JRadioButton("Band");
		bandRadio.setSelected(true);
		
		JRadioButton musicistaRadio = new JRadioButton("Musicista");
		
		ButtonGroup group = new ButtonGroup();
		group.add(bandRadio);
		group.add(musicistaRadio);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bandRadio)
							.addGap(18)
							.addComponent(musicistaRadio))
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
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(nomeArte))
								.addComponent(strumentiField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap(189, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
