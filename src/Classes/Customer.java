package Classes;
import java.util.ArrayList;

import HasARelationship.Basket;
import SysAndMain.CoffeeShopSys;


public class Customer {

	private String name;
    private static ArrayList<Customer> customerList = new ArrayList<>();
	
	public Customer(String name) {
		this.name = name;
	}
	

	public boolean findCustomer(String name) {
		
		if(this.name==name)
			return false;
			return true;
			
	}
	
	
	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}
