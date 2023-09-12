package map.restaurent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kitchen {

	private static List<Ingredients> ingredient;
	private static List<Pizza> pizza;
	private static Map<Thread, Oven> ovenList = new HashMap<>();
	private static Map<Integer, String> backLog = new HashMap<Integer, String>();
	private static List<Boolean> ovenFree = new ArrayList<>();

	// Load the ingredients and pizza
	static {
		try {
			ingredient = Loader.setIngredients(".\\lib\\jsonfile\\ingredients.json");
			pizza = Loader.enterPizza(".\\lib\\jsonfile\\pizza.json", ingredient);
			System.out.println("Ingredients added");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("setting oven");
		for (int i = 0; i < 3; i++) {
			Map.Entry<Thread, Oven> entry = Loader.setOven(new Oven(i));
			ovenList.put(entry.getKey(), entry.getValue());
			System.out.println("Oven " + i + " added");
			entry.getKey().start();
		}

	}

	public boolean checkOven() {

		ovenFree.clear();
		for (Map.Entry<Thread, Oven> free : ovenList.entrySet()) {
			ovenFree.add(free.getValue().getInUse());
		}
		System.out.println(ovenFree);
		return ovenFree.contains(true);
	}

	// Put pizza into oven
	public Pizza order(String choice) {

		System.out.println("now in kitchen");

		Pizza dummy = null;
		System.out.println(checkOven());
		while (!checkOven()) {
			System.out.println("Waiting for ovens");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

		for (Map.Entry<Thread, Oven> free : ovenList.entrySet()) {
			if (free.getValue().getInUse()) {
				System.out.println("Owen is free");
				for (Pizza recipe : pizza) {

					if (choice.equals(recipe.getName())) {
						System.out.println("Pizza being put into owen");
						dummy = free.getValue().cook(recipe);
					}
				}
				while (dummy == null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			break;
		}

		System.out.println("done");
		return dummy;
	}
}
