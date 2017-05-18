package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewTable extends JTable {
	
	public ViewTable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
