package map.restaurent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kitchen {

	private static List<Ingredients> ingredient;
	private static List<Pizza> pizza;
	private static Oven[] ovenList = new Oven[5];
	private static Map<Integer, String> backLog = new HashMap<Integer, String>();

	// Load the ingredients and pizza
	static {
		try {
			ingredient = Loader.setIngredients(".\\lib\\jsonfile\\ingredients.json");
			pizza = Loader.enterPizza(".\\lib\\jsonfile\\pizza.json", ingredient);
			for (int i = 0; i < ovenList.length; i++) {
				ovenList[i] = Loader.setOven(i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Pizza order(String choice) {
		
		System.out.println("now in kitchen");
		Pizza dummy = null;

		for (int i = 0; i < ovenList.length; i++) {
			System.out.println(ovenList[i].getInUse());
			if (ovenList[i].getInUse()) {
				System.out.println("Owen is free");
				for (Pizza recipe : pizza) {

					if (choice.equals(recipe.getName())) {
						System.out.println("Pizza being put into owen");
						dummy = ovenList[i].cook(recipe);
					}
				}
				while(dummy==null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return dummy;
	}
}
