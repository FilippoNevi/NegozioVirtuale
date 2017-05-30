package view;

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

}
