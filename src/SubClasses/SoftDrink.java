package SubClasses;
import Classes.Beverage;

public class SoftDrink extends Beverage {

	private String type;
	
	public SoftDrink() {
		super();
	
	}
	
	public SoftDrink(String type, int count) {
		super(count);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void coke() {
		this.setPrice(27.5);
	}
	

	public void sparkling() {
		this.setPrice(12.5);
	}
	
	public void water() {
		this.setPrice(10);
	}

	@Override
	public String toString() {
		return "SoftDrink\nType= " + type + "\nPrice= " + price + " TL\nCount= " + count + "\n\n";
	}

}
