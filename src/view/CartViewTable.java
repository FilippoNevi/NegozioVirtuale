package view;

/**
 * Tabella che visualizza le informazioni principali riguardo i dischi presenti nel carrello del cliente. 
 * Patter Factory per la sua costruzione e Template, in quanto eredita da ViewTable delle funzionalità, ma ne aggiunge/reimplementa altre
 */
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

public class CartViewTable extends ViewTable{

	public CartViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		this.setDefaultRenderer(Object.class, new CartRowRenderer());
	}
	
	public CartViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new CartRowRenderer());
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	/**
	 * Renderer personalizzato per il carrello
	 *
	 */
	public class CartRowRenderer extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					
			//Se mi trovo nella terza colonna, devo disegnare l'icona del disco
			if (column == 3 && value != null){
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
