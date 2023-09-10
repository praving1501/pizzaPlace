package map.restaurent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Loader {
	
	
	//Pizza Object loader
	public static List<Pizza> enterPizza(String location, List<Ingredients> ingredient) throws FileNotFoundException, IOException, ParseException {
		
		//dummy pizza list 
		List<Pizza> pizza = new ArrayList<Pizza>();

		//Get data from JSON File
		JSONParser jsonparser = new JSONParser();
		JSONObject level1 = (JSONObject) jsonparser.parse(new FileReader(location));
		
		//cycle through first level list 
		List<String> elements1 = new ArrayList<String>(level1.keySet());
		for(String name : elements1) {
			
			//get data of first level objects
			JSONObject level2 = (JSONObject) level1.get(name);
			
			//get data of the level1 object
			int cookingTime = Integer.parseInt((String) level2.get("Cooking Time"));
            int cost = Integer.parseInt(level2.get("Cost").toString());
            
            JSONArray level21 = (JSONArray) level2.get("Ingredients");
            
            //cycle through level 2 object
			List<String> elements2 = new ArrayList<String>(level2.keySet());
			
			//dummy list of ingredients
			List<Ingredients> ingredientList = new ArrayList<Ingredients>();
			for (Object ingred : level21) {
				String indiname = (String) ingred;
				
				//to add ingredients into the dummy ingredient list to add into dummy pizza list
				for(Ingredients reference : ingredient) {
					if(reference.getName().equals(indiname)) {
						ingredientList.add(reference);
						break;
					}
				}
			}
			
			//add pizza object with the json data into the dummy pizza list
			pizza.add(new Pizza(name, cost, ingredient, cookingTime));
		}
		return pizza;
	}
	
	//Ingredients Object loader
	public static List<Ingredients> setIngredients(String location) throws FileNotFoundException, IOException, ParseException {
		
		//dummy ingredients list
		List<Ingredients> ingredients = new ArrayList<Ingredients>();
		
		//get data from JSON File
		JSONParser jsonparser = new JSONParser();
		JSONObject keyWordsList = (JSONObject) jsonparser.parse(new FileReader(location));
		
		//cycle through level 1 json list
		List<String> elements = new ArrayList<String>(keyWordsList.keySet());
		for (String element : elements) {
			
			//get data form level 1 object
			int value = Integer.parseInt(keyWordsList.get(element).toString());
			
			//add Ingredients object into dummy ingredient list
			ingredients.add(new Ingredients(element, value));
		}
		return ingredients;
	}
	
	public static Oven setOven(int i) {
		
		return new Oven(i);
	}
}
