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
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	public ViewTable() {
		super();
		this.setDefaultRenderer(Object.class, new ClientRowRenderer());
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
}
