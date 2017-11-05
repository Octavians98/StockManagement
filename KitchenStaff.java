 
public class KitchenStaff implements Runnable{
	
	private String name;
	StockManagement stockManagement;
	public KitchenStaff(String name, StockManagement stockManagement) {
		
		this.name = name;
		this.stockManagement = stockManagement;
	}
	@Override
	public void run() {
		SushiDish sushiDish;
		while(true){
			sushiDish=stockManagement.preparing.poll();
			if(sushiDish==null)
				synchronized (stockManagement.notifyStaff) {
					while(sushiDish==null){
						try{
							stockManagement.notifyStaff.wait();
						} catch(InterruptedException e){
							e.printStackTrace();}
						sushiDish=stockManagement.preparing.poll();
						}
					}
				sushiDish.cooking();
					System.out.println(name +" prepared "+sushiDish.returnName());
					synchronized (stockManagement.notifyOrder) {
						stockManagement.notifyOrder.notify();
						
					}
				} 
					
				
		}
		
	}
	


