package SysAndMain;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import Classes.Beverage;
import Classes.Customer;
import HasARelationship.Basket;
import SubClasses.Coffee;
import SubClasses.SoftDrink;
import SubClasses.Tea;
import java.util.Collection;
import java.util.HashMap;

public class CoffeeShopSys {

	private static ArrayList<Beverage> beverageList = new ArrayList<Beverage>();
	private static Basket basket = new Basket();


	public static String[] getBeverageListItems() {
		String[] out = new String[beverageList.size()];
		
		for(int i = 0;i < beverageList.size();i++) {
			out[i] = beverageList.get(i).getType();
		}
		
		return out;
	}
	
	public static String getBeverageListDetail(String customerName) {
		String out = "Hello " + customerName + "!\n";
		for(int i = 0;i < beverageList.size();i++) {
			out += beverageList.get(i).toString();
		}
		return out;
	}

	public static String addBeverage(String beverageType, int count) {
		Beverage temp = null;
		boolean found = false;
		for(int i = 0;i < beverageList.size();i++) {
			if(beverageList.get(i).getType().equals(beverageType)) {
				beverageList.get(i).setCount(beverageList.get(i).getCount() + count);
				found = true;
			}
		}
		if(!found) {
		switch(beverageType) {
		case "Filter": temp = new Coffee(beverageType, count);
		((Coffee) temp).filter();
			break;
		case "Espresso": temp = new Coffee(beverageType, count);
		((Coffee) temp).espresso();
			break;
		case "Latte": temp = new Coffee(beverageType, count);
		((Coffee) temp).latte();
			break;
		case "Mocha": temp = new Coffee(beverageType, count);
		((Coffee) temp).mocha();
			break;
		case "Green Tea": temp = new Tea(beverageType,count);
		((Tea) temp).greenTea();
			break;
		case "Earl Grey": temp = new Tea(beverageType,count);
		((Tea) temp).earlGrey();
			break;
		case "Coke": temp = new SoftDrink(beverageType,count);
		((SoftDrink) temp).coke();
			break;
		case "Sparkling": temp = new SoftDrink(beverageType,count);
		((SoftDrink) temp).sparkling();
			break;
		case "Water": temp = new SoftDrink(beverageType,count);
		((SoftDrink) temp).water();
			break;
			default: return "error";
		}

		beverageList.add(temp);
		basket.setBvrgList(beverageList);
		return "Beverage selection added to the basket\n";
		}
		else
			return "Beverage selection updated in the basket\n";
}
	
	public static String calculatePrice(String customerName) {
		double price = 0;
		String out = "Hello " + customerName+ "!\n\nThere are:\n";
		for(int i = 0;i < beverageList.size();i++) {
			out += beverageList.get(i).getCount() + " - " + beverageList.get(i).getType() + "s\n";
			price += beverageList.get(i).getPrice();
		}
		out+="\nTotal price is : " + price + " TL\n";
		return out;
}
	
	public static boolean removeBeverage(String type) {
		for(int i = 0;i < beverageList.size();i++) {
			if(beverageList.get(i).getType().equals(type)) {
				beverageList.remove(i);
				basket.setBvrgList(beverageList);
				return true;
			}
		}
		return false;
	}
	
	public double calculateTotalPrice() {
		double price = 0;
		
		for(int i = 0;i < beverageList.size();i++) {
			price += beverageList.get(i).getPrice();
		}
		
		return price;
	}
	
	public static ArrayList<Beverage> getBeverageList() {
		return beverageList;
	}
}


