package model;

import java.io.Serializable;

/**
 * Classe che rappresenta una data.
 * Attenzione! Non effettua controlli sulla validità della data memorizzata
 *
 */
public class Date implements Serializable{
	
	private int year;
	private int month;
	private int day;
	
	/**
	 * Metodo costruttore
	 * @param year Anno 
	 * @param month Mese
	 * @param day Giorno
	 */
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public String toString(){
		return String.format("%2d/%2d/%4d", day, month, year);
	}

}
