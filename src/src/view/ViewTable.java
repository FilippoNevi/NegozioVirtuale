package view;

import javax.swing.JTable;

public abstract class ViewTable extends JTable{
	
	public ViewTable(){
		super();
	}
	
	public ViewTable(Object[][] data, String[] columnNames){
		super(data, columnNames);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
