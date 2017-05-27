package view;

import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.FutureTask;

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
			return this;
		}
		
	}
}
