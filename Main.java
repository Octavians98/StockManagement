import java.util.HashMap;
import java.util.Random;

public class Main {

	
	
	//For testing reasons i used very fast times for  the thread.sleep() methods, that way it`s gonna take a lot less time;
	
	
	
	
	StockManagement sm = new StockManagement();

	public static void main(String[] args) {
		Supplier supplier = new Supplier("Stan", 10);
		
		Ingredient shrimp = new Ingredient("Shrimp", "kg", new Supplier("Pepperidge farm", 3), 100);
		shrimp.restock(100);
		HashMap<Ingredient, Integer> recipe = new HashMap<Ingredient, Integer>();
		recipe.put(shrimp, 6);
		
		SushiDish dish = new SushiDish("Spring Rolls", "the meaning of life", 4,recipe,
				10);
		SushiDish dish2 = new SushiDish("Rice", "the meaning of life", 4,recipe,
				10);
		SushiDish dish3 = new SushiDish("Whatever", "the meaning of life", 4,recipe,
				10);
		SushiDish dish4 = new SushiDish("That", "the meaning of life", 4,recipe,
				10);
		SushiDish dish5 = new SushiDish("Can", "the meaning of life", 4,recipe,
				10);
		SushiDish dish6 = new SushiDish("Pork", "the meaning of life", 4,recipe,
				10);
		
		
		StockManagement sm = new StockManagement();
		sm.addSupplier(supplier);
		sm.addDish(dish);
		sm.addDish(dish6);
		sm.addDish(dish2);
		sm.addDish(dish3);
		sm.addDish(dish4);
		sm.addDish(dish5);
		sm.addDish(dish);
		sm.addDish(dish6);
		sm.addDish(dish2);
		sm.addDish(dish3);
		sm.addDish(dish4);
		sm.addDish(dish5);
		sm.addDish(dish);
		sm.addDish(dish6);
		sm.addDish(dish2);
		sm.addDish(dish3);
		sm.addDish(dish4);
		sm.addDish(dish5);
		sm.addIng(shrimp);
		
		new Thread(new OrderManagement(sm)).start();
		
		new Thread(new KitchenStaff("Mihai", sm)).start();

		new Thread(new KitchenStaff("Miguel", sm)).start();

		new Thread(new KitchenStaff("Maria", sm)).start();
		
		new Thread(new Drone(10, 1, sm)).start();
		new Thread(new Drone(10, 2, sm)).start();
		new Thread(new Drone(10, 3, sm)).start();
		LogIn login = new LogIn(sm);
		ViewStock view = new ViewStock(sm);
		view.setVisible(false);
		ChangeStock stock = new ChangeStock(sm);
		stock.setVisible(false);
		BusinessApp bApp = new BusinessApp(sm,view,stock);
		//test with more dishes
		
		int i =0;
		while(i<10){
			sm.prepareOrder(new Order(dish, 10, 4));
			i+=4;
			System.out.println(i + " orders so far");
			System.out.println(dish.returnStock() + " in stock");
			try {
				Thread.sleep(dish.returnTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(dish.returnStock() + " in stock");
	}
	public StockManagement returnSm(){
		return this.sm;
	}
}