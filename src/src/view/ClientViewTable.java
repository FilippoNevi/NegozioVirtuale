package view;


import java.awt.Component;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ClientViewTable extends ViewTable {
	
	public ClientViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	public ClientViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	public class ClientRowRenderer extends DefaultTableCellRenderer{
		
		
		//Viene chiamato per ogni cella della tabella da disegnare
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			String stato = (String)table.getModel().getValueAt(row, table.getColumnCount() -1);
			int occorrenza = Integer.parseInt(stato);
					

			if (column == 4 && value != null){
				File f = new File(value.toString());

				if(f.exists() && !f.isDirectory()) { 
		
					JLabel label = new JLabel();
					ImageIcon icon = new ImageIcon(value.toString());
					Image resize = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					label.setIcon(new ImageIcon(resize));
					return label;
				}
					
			}

			return this;
		}

	}
}
