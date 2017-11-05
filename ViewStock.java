import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ViewStock extends JFrame {
	
	StockManagement sm;
	public ViewStock(StockManagement sm){
		this.sm=sm;
		setTitle("View Stock");
		setSize(800, 800);
		this.setLayout(new GridLayout(1, 2));
		setVisible(true);
		setResizable(false);
		init();
	}
	
	public void init(){
		JPanel panel1=new JPanel();
		panel1.setLayout(new BorderLayout());
		JPanel panel2=new JPanel();
		JLabel tit = new JLabel("Dish stock");
		panel2.add(tit);
		panel1.add(panel2,BorderLayout.NORTH);
		JPanel panel3=new JPanel();
		for(SushiDish dish:sm.returnMenu()){
			JLabel name = new JLabel("Dish: "
					+ dish.returnName());
			JLabel stock = new JLabel("Stock: "+Integer.toString(dish.returnStock()));
			JLabel restocking = new JLabel("Restock level: "+dish.returnRestockLvl());
			panel3.add(name);
			panel3.add(stock);
			panel3.add(restocking);
			panel3.setSize(200,200);
			panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
			panel3.add(Box.createVerticalStrut(25));
			panel1.add(panel3);
}
		JScrollPane scroll = new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll);
		JPanel panel4=new JPanel();
		panel4.setLayout(new BorderLayout());
		JPanel panel5 = new JPanel();
		JLabel lit = new JLabel("Ingredient stock");
		panel5.add(lit);
		panel4.add(panel5,BorderLayout.NORTH);
		JPanel panel6=new JPanel();
		for(Ingredient ingredient:sm.returnIng()){
			JLabel name = new JLabel("Name: "+ingredient.returnName());
			JLabel stock = new JLabel("Stock: "+Integer.toString(ingredient.returnStock()));
			JLabel restocking = new JLabel("Restock level: "+ingredient.returnRestockLvl());
			panel6.add(name);
			panel6.add(stock);
			panel6.add(restocking);
			panel6.setSize(200,200);
			panel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
			panel6.add(Box.createVerticalStrut(25));
			panel4.add(panel6);
			
		}
		JScrollPane scroll2=new JScrollPane(panel4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll2);
	}
}
