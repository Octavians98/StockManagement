
public class Drone implements Runnable {
	
	private int speed;
	private int nr;
	StockManagement stockManagement;

	public Drone(int speed, int nr, StockManagement stockManagement) {
		
		this.speed = speed;
		this.nr = nr;
		this.stockManagement = stockManagement;
	}

	@Override
	public void run() {

			Ingredient ingredient=null;
			Order order=null;
			while(true){
				ingredient=stockManagement.restocking.poll();
				if(ingredient==null){
					order=stockManagement.ordersReady.poll();
					if(order==null)
						synchronized(stockManagement.notifyDrones){
						while(ingredient==null&&order==null){
							try{
								stockManagement.notifyDrones.wait();
							}catch(InterruptedException e){
								e.printStackTrace();
							}
							ingredient=stockManagement.restocking.poll();
							if(ingredient==null)order=stockManagement.ordersReady.poll();
						}
					}
				}
			if(ingredient!=null){
				try{ Thread.sleep(1000);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			ingredient.restock(ingredient.returnRestockLvl());
			System.out.println("Drone "+nr+" restocked"+ingredient.returnName());
			}else{
				try{
					Thread.sleep(1000);}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println("Drone "+nr+" delivered"+order.returnQuantity()+" "+order.returnDish().returnName());
			}
			}
		
	}

}