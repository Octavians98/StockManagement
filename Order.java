
public class Order {

	private SushiDish dish;
	private int distance;
	private int quantity;
	private boolean status;
	
	public Order(SushiDish dish, int distance, int quantity) {
		
		this.dish = dish;
		this.distance = distance;
		this.quantity = quantity;
		this.status=false;
	}
	
	public int returnDistance(){
		return distance;
	}
	
	public int returnQuantity(){
		return quantity;
	}
	
	public SushiDish returnDish(){
		return dish;
	}
	
	public void orderDone(){
		status=true;
	}
	
	public boolean returnStatus(){
		return status;
	}
}
