package map.restaurent;

import java.util.List;

public interface Food {

	public void setCost(int a);
	
	public int getCost();
	
	public void setIngredients(List<Ingredients> b);

	public void setRecipe(int c);
	
	public void getLook();
	
}
