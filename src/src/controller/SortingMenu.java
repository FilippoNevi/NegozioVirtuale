package controller;

import java.util.List;
import model.OccorrenzeDisco;

public interface SortingMenu {
	
	public void updateTable(List<OccorrenzeDisco> elements);
	
	public boolean isForGenere();

	public boolean isForPartecipante();
	
	public boolean isForPrezzo();

	public boolean isForTitolare();

	public String getFilter();
	
	public void resetFilter();
	
}
