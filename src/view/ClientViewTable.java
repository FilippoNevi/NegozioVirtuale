package view;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import model.Magazzino;

/**
 * Tabella che mostra al cliente il catalogo di dischi.
 * Patter Factory per la sua costruzione e Template, in quanto eredita da ViewTable delle funzionalità, ma ne aggiunge/reimplementa altre
 *
 */

public class ClientViewTable extends ViewTable {
	
	public ClientViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	public ClientViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	/**
	 * Renderer ad hoc per la visualizzazione "user friendly" per il cliente
	 *
	 */
	public class ClientRowRenderer extends DefaultTableCellRenderer{
		
		
		//Viene chiamato per ogni cella della tabella da disegnare
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			String stato = (String)table.getModel().getValueAt(row, table.getColumnCount() -1);
			int occorrenza = Integer.parseInt(stato);
					
			//se è la colonna dei path delle immagini, prelevo l'icona e la disegno
			if (column == 4 && value != null){
				File f = new File(Magazzino.IMG_PATH + value.toString());
				if(f.exists() && !f.isDirectory()) { 
		
					JLabel label = new JLabel();
					Image img = null;
					try{
						
						img = ImageIO.read(f);
					}
					catch(IOException e){
						e.printStackTrace();
					}
					Image resize = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					label.setIcon(new ImageIcon(resize));
					return label;
				}
					
			}

			return this;
		}

	}
}
