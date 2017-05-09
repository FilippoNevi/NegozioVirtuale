package model;

public class OccorrenzeDisco {
	
	private Disco disco;
	private int occorrenza;
	
	public OccorrenzeDisco(Disco disco, int occorrenza){
		this.disco = disco;
		this.occorrenza = occorrenza;
	}
	
	public Disco getDisco(){
		return disco;
	}
	
	public int getOccorrenza(){
		return occorrenza;
	}
}
