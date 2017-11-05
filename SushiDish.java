import java.util.HashMap;
import java.util.Random;

public class SushiDish {

	private String name;
	private String description;
	private int price;
	private HashMap<Ingredient, Integer> recipe;
	private int stockLvl;
	private int restockLvl;
	private Random r=new Random();
	private int low=2000;
	private int high=6000;
	
	public SushiDish(String name, String description, int price, HashMap<Ingredient, Integer> recipe,
			int restockLvl) {
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.recipe = recipe;
		this.restockLvl = restockLvl;
	}
	
	public String returnName(){
		return name;
	}
	
	public String returnDescription(){
		return description;
		
	}
	
	public int returnPrice(){
		return price;
		
	}
	
	public HashMap<Ingredient, Integer> returnRecipe(){
		return recipe;
	}
	
	public int returnStock(){
		return stockLvl;
	}

	public int returnRestockLvl(){
		return restockLvl;
	}
	
	public void changeName(String name){
		this.name=name;
	}
	
	public void changeDescription(String description){
		this.description=description;
	}
	
	public void changeRestockLvl(int restockLvl){
		this.restockLvl=restockLvl;
	}
	
	public void changeRecipe(Ingredient ingredient, Integer quantity){
		this.recipe.put(ingredient, quantity);
	}
	
	public void changePrice(int price){
		this.price=price;
	}
	
	public void removeIngredient(Ingredient ingredient){
		this.recipe.remove(ingredient);
	}
	
	public void newDish(int quantity){
		this.stockLvl-=quantity;
	}
	
	public int returnTime(){
		int result =r.nextInt(high-low)+low;
		return result;
	}
	public void cooking(){
		for(Ingredient ingredient:recipe.keySet()){
			ingredient.use(recipe.get(ingredient));
		}
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		++stockLvl;
	}
}

