package map.restaurent;

import java.util.List;

public class Pizza implements Food{
	
	private String name;
	private int cost;
	private List<Ingredients> ingredients;
	private int recipe;
	

	public Pizza(String name, int cost, List<Ingredients> ingredients, int recipe) {
		super();
		this.cost = cost;
		this.ingredients = ingredients;
		this.recipe = recipe;
		this.name = name;
	}

	public void setCost(int n) {
		this.cost= n;
	}
	
	public String getName() {
		return name;
	}
	public void setIngredients(List<Ingredients> b) {
		this.ingredients = b;
	}

	public void setRecipe(int c) {
		this.recipe = c;
	}
	
	public int getRecipe() {
		
		return recipe;
	}

	public int getCost() {
		return cost;
	}
	public void getLook() {
		System.out.println("this is a pizza");
	}
	
	@Override
	public String toString() {	
		
		
		return "Pizza [cost=" + cost + ", Name=" + name + ", recipe=" + recipe + "]";
	}
}
