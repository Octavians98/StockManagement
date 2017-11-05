import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BusinessApp extends JFrame {
	StockManagement sm;
	ViewStock view;
	ChangeStock stock;
	public BusinessApp(StockManagement sm,ViewStock view,ChangeStock stock){
		this.sm=sm;
		this.view=view;
		this.stock=stock;
		setTitle("BusinessApp");
		setSize(400,400);
		setVisible(true);
		setResizable(false);
		//this.setLayout(new GridLayout(2, 2));
		init();
	
	}
	
	public void init(){
		JPanel business=new JPanel();
		business.setLayout(new GridLayout(2, 2));
		JButton viewStock = new JButton("View dish/ingredient stock");
		viewStock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view = new ViewStock(sm);
				stock.dispose();
			}
		});
		
		JPanel label = new JPanel();
		JPanel app = new JPanel();
		JLabel title = new JLabel("Business app");
		title.setFont(new Font("Serif",Font.PLAIN,32));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setAlignmentY(Component.CENTER_ALIGNMENT);
		label.add(title);
		JPanel buttons = new JPanel();
		JButton b1 = new JButton("Set restock levels");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stock = new ChangeStock(sm);
				view.dispose();
				
			}
		});
		JButton b2 = new JButton("Manage inventory");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Manager manager = new Manager(sm);
				
			}
		});
		JButton b3 = new JButton("Start the business");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartBusiness start = new StartBusiness(sm);
				
			}
		});
		buttons.setLayout(new GridLayout(2, 2));
		buttons.add(viewStock);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		app.setLayout(new GridLayout(2, 1));
		app.add(label);
		app.add(buttons);
		this.add(app);
		
		
		
	}
}
