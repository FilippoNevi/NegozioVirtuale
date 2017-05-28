package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.concurrent.FutureTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewTable extends JTable {
	
	public ViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
		this.setDefaultRenderer(Object.class, new RowRenderer());
	}
	
	public ViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new RowRenderer());
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	private class RowRenderer extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			String stato = (String)table.getModel().getValueAt(row, table.getColumnCount() -1);
			int occorrenza = Integer.parseInt(stato);
			
			if (occorrenza <= 2){
				setBackground(new Color(255, 170, 170));
			}
			else
				setBackground(Color.WHITE);
			

			if (column == 4 && value != null){
				File f = new File(value.toString());
				
				if(f.exists() && !f.isDirectory()) { 
					if (new File(value.toString()).exists()){
						JLabel label = new JLabel();
						ImageIcon icon = new ImageIcon(value.toString());
						Image resize = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
						label.setIcon(new ImageIcon(resize));
						return label;
					}
				}
			}
			return this;
		}
		
	}
}
