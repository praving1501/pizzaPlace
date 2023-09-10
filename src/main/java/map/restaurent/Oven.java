package map.restaurent;

import java.util.Timer;
import java.util.TimerTask;

public class Oven {

	private int ovenNumber;
	private static boolean inUse = false;
	private static Pizza cooked;

	public static Pizza cook(final Pizza p) {

		System.out.println("now in owen");
		inUse = false;
		Timer timer = new Timer();

		TimerTask putIn = new TimerTask() {

			
			@Override
			public void run() {
				System.out.println("pizza cooked");
				cooked = p;
				inUse = true;
			}
		};
		System.out.println("pizza cooking");
		timer.schedule(putIn, p.getRecipe());
		while(inUse) {
			System.out.println("Now waiting for pizza to cook");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cooked;
	}

	public boolean getInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public Oven(int ovenNumber) {
		this.ovenNumber = ovenNumber;
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				inUse = true;
			}

		};
		timer.schedule(task, 10000);
		while(!inUse) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Owen "+ ovenNumber+ " is ready");

	}

	public int getOvenNumber() {
		return ovenNumber;
	}

	public void setOvenNumber(int ovenNumber) {
		this.ovenNumber = ovenNumber;
	}

}
