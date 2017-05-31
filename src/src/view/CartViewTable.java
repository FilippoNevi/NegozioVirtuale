package view;

import java.awt.Component;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

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
	
	public class CartRowRenderer extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					

			if (column == 3 && value != null){
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
