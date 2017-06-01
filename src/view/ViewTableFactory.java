package view;

/**
 * Classe che permette la costruzione di ViewTable: Factory pattern
 *
 */
public class ViewTableFactory {		
	
	static final String CLIENT_TABLE = "CLIENT";		//Tabella cliente
	static final String ADMIN_TABLE = "ADMIN";			//Tabella amministratore
	static final String CART_TABLE = "CART";			//Tabella carrello
	
	public ViewTable getTable(String type){
		
		if (type.equalsIgnoreCase(CLIENT_TABLE)){
			return new ClientViewTable();
		}
		else if (type.equalsIgnoreCase(ADMIN_TABLE)){
			return new AdminViewTable();
		}
		else if (type.equalsIgnoreCase(CART_TABLE)){
			return new CartViewTable();
		}
		throw new RuntimeException("Parameter Error ViewTableFactory class");
	}

}
