import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Menu extends JFrame {
	StockManagement sm;
	public Menu(StockManagement sm){
		this.sm=sm;
		setTitle("Menu");
		setLayout(new GridLayout(1,1));
		setSize(1000,1000);
		setVisible(true);
		setResizable(false);
		init();
	}
	
	public void init(){
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent panel1=makeTextPanel("Panel 1");
		
		for(SushiDish dish:sm.returnMenu()){
			JButton add = new JButton("Add to shopping cart");
			JPanel panel = new JPanel();
			JLabel name = new JLabel("Name of the dish: "+dish.returnName());
			JLabel description = new JLabel("Description: "+dish.returnDescription());
			JLabel stock = new JLabel("Dishes in stock: "+Integer.toString(dish.returnStock()));
			panel.add(name);
			panel.add(stock);
			panel.add(description);
			panel.add(add);
			panel.setLayout(new GridLayout(3, 1));
			panel.setSize(200,200);
			panel.add(Box.createHorizontalStrut(30));
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panel1.add(panel);
			
		
			
		}
		JScrollPane scroll = new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Our menu",scroll);
		JPanel panel2=new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setSize(800,800);
		JLabel order=new JLabel("Your order contains: ");
		JButton confirm=new JButton("Confirm your order");
		panel2.add(order, BorderLayout.NORTH);
		panel2.add(confirm, BorderLayout.SOUTH);
		JScrollPane scroll2=new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Your order",scroll2);
		JComponent panel3=makeTextPanel("Panel3");
		JLabel previous=new JLabel("Your previous orders are: ");
		panel3.add(previous);
		JScrollPane scroll3=new JScrollPane(panel3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Your previous orders", scroll3);
		JComponent panel4=makeTextPanel("Panel4");
		JLabel track = new JLabel("Your order status is: ");
		panel4.add(track);
		tabbedPane.addTab("Your order status", panel4);
		this.add(tabbedPane);
	}

	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setSize(800,800);
        setVisible(true);
        return panel;
    }
	

}
