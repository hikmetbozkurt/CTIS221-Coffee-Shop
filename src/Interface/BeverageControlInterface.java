package Interface;

import Classes.Beverage;

public interface BeverageControlInterface {
	public static int maxBeverage = 5;
	
	public abstract void addBeverage(Beverage beverage);
	public abstract boolean removeBeverage(String name);
	public abstract String displayBasket();
}
