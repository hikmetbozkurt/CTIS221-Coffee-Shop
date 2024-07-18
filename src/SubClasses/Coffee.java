package SubClasses;
import Classes.Beverage;
public class Coffee extends Beverage{

	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Coffee() {
		super();
	}
	
	public Coffee(String type, int count) {
		super(count);
		this.type = type;
	}
	
	public void filter() {
		this.setPrice(20);
	}
	
	public void espresso() {
		this.setPrice(25);
	}
	
	public void latte() {
		this.setPrice(30);
	}
	
	public void mocha() {
		this.setPrice(35);
	}

	@Override
	public String toString() {
		return "Coffee\nType= " + type + "\nPrice= " + price + " TL\nCount= " + count + "\n\n";
	}
	
	

}
