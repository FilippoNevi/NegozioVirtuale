package view;

import java.awt.Color;
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
import view.ClientViewTable.ClientRowRenderer;

/**
 * Tabella che mostra i dati all'amministratore
 * Patter Factory per la sua costruzione e Template, in quanto eredita da ViewTable delle funzionalità, ma ne aggiunge/reimplementa altre
 *
 */
public class AdminViewTable extends ViewTable{
	
	public AdminViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		this.setDefaultRenderer(Object.class, new AdminRowRenderer());
	}
	
	public AdminViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new AdminRowRenderer());
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	/**
	 * Renderer ad hoc per l'amministratore, che necessita di informazioni aggiuntive, come l'eventuale allarme 
	 * (riga rossa) se le occorrenze di un disco sono <= 2
	 *
	 */
	public class AdminRowRenderer extends DefaultTableCellRenderer{
		
		//Viene chiamato per ogni cella della tabella da disegnare
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			String stato = (String)table.getModel().getValueAt(row, table.getColumnCount() -1);
			int occorrenza = Integer.parseInt(stato);
			
			if (occorrenza <= 2){								//Se ci sono pochi pezzi -> riga rossa
				setBackground(new Color(255, 170, 170));
			}
			else{												//Altrimenti riga bianca
				setBackground(new Color(250, 250, 250));
			}
			//se mi trovo nella quarta colonna e devo disegnare le icone dei dischi
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
