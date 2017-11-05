import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class StockManagement {

	private ArrayList<SushiDish> dishes;
	private ArrayList<Ingredient> ingredients;
	Queue<SushiDish> preparing;
	Queue<Ingredient> restocking;
	Queue<Order> ordersReady;
	ArrayList<Order> ordersPreparing;
	Object notifyStaff, notifyDrones, notifyOrder;
	private ArrayList<Supplier> suppliers;
	
	public StockManagement(){
		suppliers=new ArrayList<Supplier>();
		dishes=new ArrayList<SushiDish>();
		ingredients=new ArrayList<Ingredient>();
		preparing=new ArrayDeque<SushiDish>();
		restocking=new ArrayDeque<Ingredient>();
		ordersPreparing=new ArrayList<Order>();
		ordersReady=new ArrayDeque<Order>();
		notifyDrones=new Object();
		notifyOrder=new Object();
		notifyStaff=new Object();
	}
	
	public void addIng(Ingredient ingredient){
		ingredients.add(ingredient);
	}
	
	public void addDish(SushiDish dish){
		dishes.add(dish);
	}
	
	public void addSupplier(Supplier supplier){
		suppliers.add(supplier);
	}
	
	public void removeIng(Ingredient ingredient){
		ingredients.remove(ingredient);
	}
	
	public ArrayList<Ingredient> returnIng(){
		return ingredients;
	}
	
	public void removeDish(SushiDish dish){
		dishes.remove(dish);
	}
	public  ArrayList<Supplier> returnSupplier(){
		return suppliers;
	}
	public ArrayList<SushiDish> returnMenu(){
		return dishes;
	}
	public void restock(SushiDish dish){
		for(Ingredient ingredient:dish.returnRecipe().keySet())
			if(ingredient.returnStock()<ingredient.returnRestockLvl())
				if(!restocking.contains(ingredient))
					restocking.add(ingredient);
		if(!restocking.isEmpty()){
			synchronized(notifyDrones){
				notifyDrones.notifyAll();
			}
		}	int d = dish.returnRestockLvl();
			if(d-dish.returnStock()>0){
				while(d-->0)
					preparing.add(dish);
				synchronized (notifyStaff) {
					notifyStaff.notifyAll();
					
				}
			}
		}
				
	
	
	public void prepareOrder(Order order){
		ordersPreparing.add(order);
		synchronized (notifyOrder) {
		notifyOrder.notify();	
		}
	}
}
