
public class Ingredient {

	private String name;
	private String unit;
	private Supplier supplier;
	private int stockLvl;
	private int restockLvl;
	
	public Ingredient(String name, String unit, Supplier supplier,  int restockLvl) {
		
		this.name = name;
		this.unit = unit;
		this.supplier = supplier;
		this.restockLvl = restockLvl;
	}
	
	public String returnName(){
		return name;
	}
	
	public String returnType(){
		return unit;
	}
	
	public int returnRestockLvl(){
		return restockLvl;
	}
	
	public int returnStock(){
		return stockLvl;
	}
	
	public Supplier returnSupplier(){
	return supplier;

	}
	
	public void changeRestock(int restockLvl){
		this.restockLvl=restockLvl;
	}
	
	public void ingredientSup(Supplier supplier){
		this.supplier=supplier;
	}
	public synchronized void use(int quantity){
		while(quantity>stockLvl){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		stockLvl-=quantity;
		notifyAll();
	}
	
	
	public synchronized void restock(int quantity){
		stockLvl=stockLvl+quantity;
		notifyAll();
	}
	
}