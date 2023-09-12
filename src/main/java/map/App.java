package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import map.restaurent.*;

public class App {
	
	
	private static List<Timer> timers = new ArrayList();
	
    public static void main( String[] args ){
    	
    	Kitchen test = new Kitchen();
    	
    	List<Person> names = new ArrayList<Person>();
    	
    	names.add(new Person());
    	System.out.println("pizza ordered");
    	Pizza inHand = test.order("Veggie Supreme Pizza");
    	
    	
    	while(inHand==null) {
    		try {
    			System.out.println("waiting in room");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	System.out.println(inHand.getName()+ " : "+ inHand.getRecipe());
    	
    }
}











