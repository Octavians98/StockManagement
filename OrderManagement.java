
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OrderManagement implements Runnable {

	StockManagement stockManagement;

	public OrderManagement(StockManagement stockManagement){
		this.stockManagement=stockManagement;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		int dishQuantity;
		SushiDish sDish;
		HashSet<SushiDish> sushiDish;
		while(true){
			synchronized (stockManagement.notifyOrder) {
				try{
					stockManagement.notifyOrder.wait();
				}
				catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}

			sushiDish =new HashSet<SushiDish>();
			for(Order order: stockManagement.ordersPreparing)
			{
				sDish=order.returnDish();
				if(!order.returnStatus()&&!sushiDish.contains(sDish)){
					dishQuantity=order.returnQuantity();
					if(dishQuantity<=sDish.returnStock()){
						sDish.newDish(dishQuantity);
						stockManagement.ordersReady.add(order);
						synchronized (stockManagement.notifyDrones) {
							stockManagement.notifyDrones.notifyAll();

						}
						order.orderDone();
						System.out.println("Order "+stockManagement.ordersPreparing.indexOf(order)+" of "+dishQuantity+" "+sDish.returnName()+" completed");
					}else{sushiDish.add(sDish);
					}
					stockManagement.restock(sDish);
				}
			}
		}
	}
}
