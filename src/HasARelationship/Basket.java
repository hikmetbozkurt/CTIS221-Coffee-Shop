package HasARelationship;
import java.util.ArrayList;

import Classes.Beverage;

//update the basket according to the customer's extra orders
public class Basket {
	
	private ArrayList<Beverage> bvrgList = new ArrayList<Beverage>();
	

	public Basket(){
		
	}
	
	public ArrayList<Beverage> getBvrgList() {
		return bvrgList;
	}

	@Override
	public String toString() {
		String out = "\nUpdate on the Basket: ";
		for(int i = 0;i < bvrgList.size();i++)
			out+= bvrgList.get(i).toString();
		return out;
	}

	public void setBvrgList(ArrayList<Beverage> beverageList) {
		this.bvrgList = beverageList;
		
	}
	
}
