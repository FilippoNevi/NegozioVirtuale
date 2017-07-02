package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Disco;
import model.Magazzino;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * Frame che visualizza al PersonaleAutorizzato, tutti i dettagli del disco da lui selezionato
 *
 */
public class DetailsFrame extends JFrame implements MouseListener{

	private JPanel contentPane;
	
	protected Disco disco;	
	protected ListTable tracce;
	protected ListTable strumenti;
	protected JLabel imgLabel;	
	protected int fotoIndex = 0;
	
	public DetailsFrame(){
		super();
	}
	
	public DetailsFrame(String titolo, Disco disco) {
		super(titolo);
		
		this.disco = disco;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 688);
		setMinimumSize(new Dimension(710,688));
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
		
		JLabel lblPrezzo = new JLabel(String.format("%.2f €", disco.getPrezzo()));
		lblPrezzo.setFont(new Font("Ubuntu", Font.BOLD, 16));
				
		Object[][] datiTracce = new Object[disco.getTracce().size()][1];
		for(int i = 0; i < disco.getTracce().size(); i++) {
			datiTracce[i][0] = disco.getTracce().get(i);
		}
		
		Object[][] datiStrumenti = new Object[disco.getStrumenti().size()][2];
		for (int i = 0; i < disco.getStrumenti().size(); i++){
			datiStrumenti[i][0] = disco.getStrumenti().get(i).getMusicista().toString();
			datiStrumenti[i][1] = disco.getStrumenti().get(i).getStrumento();
		}
		
		
		tracce = new ListTable(datiTracce, new String[]{"Traccia"});
		tracce.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		
		strumenti = new ListTable(datiStrumenti, new String[]{"Strumenti", "Musicista"});
		strumenti.setFont(new Font("Ubuntu", Font.PLAIN, 12));
		
		JLabel lblDescrizione = new JLabel(disco.getDescrizione());
		lblDescrizione.setFont(new Font("Ubuntu", Font.PLAIN, 14));
		
		imgLabel = new JLabel("");
		imgLabel.setVerticalAlignment(SwingConstants.TOP);
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.addMouseListener(this);

		
		if (disco.getFotografie().size() == 0)
			imgLabel.setIcon(new ImageIcon(DetailsFrame.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
		else
			updateFoto(fotoIndex);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(lblDescrizione, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tracce, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTitolo)
										.addComponent(lblArtista)
										.addComponent(lblGenere)
										.addComponent(lblData))
									.addGap(11)))
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(strumenti, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPrezzo)
									.addGap(35)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrezzo)
								.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addComponent(lblTitolo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblArtista)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblGenere)
							.addGap(18)
							.addComponent(lblData)))
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tracce, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addComponent(strumenti, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblDescrizione)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}
	
	public void updateFoto(int index){
		
		File f = new File(Magazzino.IMG_PATH + disco.getFotografie().get(index));
		if(f.exists() && !f.isDirectory()) { 
			
			imgLabel.setIcon(getImage(disco.getFotografie().get(index)));
		}
		else
			imgLabel.setIcon(new ImageIcon(DetailsFrame.class.getResource("/com/sun/javafx/webkit/prism/resources/missingImage.png")));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (disco.getFotografie() != null && disco.getFotografie().size() > 0){
			fotoIndex = (fotoIndex + 1) % disco.getFotografie().size();
			updateFoto(fotoIndex);
		}
		
	}
	
	private ImageIcon getImage(String path){
	
		//Serve per trovare il file con il path relativo 
		File f = new File(Magazzino.IMG_PATH + path);
		
		Image img = null;
		if(f.exists() && !f.isDirectory()) { 

			JLabel label = new JLabel();
			
			try{
				
				img = ImageIO.read(f);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		Image newImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		return new ImageIcon(newImg);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Semplice tabella per la visualizzazione delle tracce e dei musicisti, con i relativi strumenti
	 *
	 */
	protected class ListTable extends JTable{
		public ListTable(Object[][] data, String[] columnNames) {
			super(data, columnNames);
			
		}
				
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}
}