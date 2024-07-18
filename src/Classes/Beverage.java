package Classes;

public abstract class Beverage {
	protected double price;
	protected int count;
	
	 // no-arg constructor
	public Beverage() {
	}
	
	public Beverage(int count) {
		this.count = count;
	}
	
	public double getPrice()
	{
		return price * count;
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "\nBeverages: price=" + price + "]";
	}

	public abstract String getType();
	
}
