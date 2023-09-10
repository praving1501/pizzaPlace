package map.restaurent;

public class Ingredients {

	private String name;
	private int quantity;
	
	
	public Ingredients(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public Ingredients() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Ingredients [name=" + name + ", quantity=" + quantity + "]";
	}
	
	
	
}
