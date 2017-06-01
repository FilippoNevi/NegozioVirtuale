package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import view.ClientViewTable.ClientRowRenderer;

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

	public class AdminRowRenderer extends DefaultTableCellRenderer{
		
		//Viene chiamato per ogni cella della tabella da disegnare
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			String stato = (String)table.getModel().getValueAt(row, table.getColumnCount() -1);
			int occorrenza = Integer.parseInt(stato);
			
			if (occorrenza <= 2){
				setBackground(new Color(255, 170, 170));
			}
			else{
				setBackground(new Color(250, 250, 250));
			}

			if (column == 4 && value != null){
				//path relativo
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
