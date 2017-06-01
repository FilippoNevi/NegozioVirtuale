package view;

public class ViewTableFactory {		//factory pattern
	
	static final String CLIENT_TABLE = "CLIENT";
	static final String ADMIN_TABLE = "ADMIN";
	static final String CART_TABLE = "CART";
	
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
