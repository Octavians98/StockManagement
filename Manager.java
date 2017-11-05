import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Manager extends JFrame {
	StockManagement sm;
	public Manager(StockManagement sm){
		this.sm=sm;
		setTitle("Manage your business");
		setSize(300, 300);
		this.setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		init();
		
	}
	
	public void init(){
		JPanel pane =  new JPanel();
		pane.setLayout(new GridLayout(3, 1,10,10));
		pane.setSize(300,300);
		JButton dish = new JButton("Add new dish");
		dish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewDish addDish =  new AddNewDish(sm);
				
			}
		});
		dish.setPreferredSize(new Dimension(290, 100));
		dish.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JButton ingredient = new JButton("Add new ingredient");
		ingredient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewIngredient addIng = new AddNewIngredient(sm);
				
			}
		});
		ingredient.setPreferredSize(new Dimension(290, 100));
		ingredient.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JButton supplier = new JButton("Add new supplier");
		supplier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddSupplier supp = new AddSupplier(sm);
				
			}
		});
		supplier.setPreferredSize(new Dimension(290, 100));
		supplier.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pane.add(dish);
		pane.add(ingredient);
		pane.add(supplier);
		this.add(pane);
		this.pack();
	}}
