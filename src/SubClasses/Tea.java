package SubClasses;

import Classes.Beverage;

public class Tea extends Beverage{
	private String type;
	
	public Tea() {
		super();
	}
	
	public Tea(String type, int count) {
		super(count);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void earlGrey() {
		this.setPrice(17.25);
	}

	public void greenTea() {
		this.setPrice(22.25);
	}
	
	@Override
	public String toString() {
		return "Tea\nType= " + type + "\nPrice= " + price + " TL\nCount= " + count + "\n\n";
	}

}
