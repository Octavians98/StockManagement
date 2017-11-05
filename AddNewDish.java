import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewDish extends JFrame{
	StockManagement sm;
	HashMap<Ingredient, Integer> recipe;
	
	public AddNewDish(StockManagement sm){
		recipe = new HashMap<Ingredient,Integer>();
		this.sm=sm;
		setTitle("Add a new dish");
		setSize(300, 300);
		this.setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		init();
	}
//fa recipe
	public void init(){
		JComboBox combo =new JComboBox();
//		combo.setModel(new DefaultComboBoxModel<Ingredient>(sm.returnIng().toArray(new Ingredient[1])));
		for(Ingredient i:sm.returnIng()){
			combo.addItem(i.returnName());
			
		}
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setSize(500,300);
		JPanel button = new JPanel();
		button.setVisible(true);
		button.setSize(400,100);
		panel.setLayout(new GridLayout(5,2,10,10));
		button.setLayout(new GridLayout(1, 2));
		JTextField name = new JTextField(10);
		JTextField description = new JTextField(10);
		JTextField price = new JTextField(10);
		JTextField restockLvl = new JTextField(10);
		JTextField nrIng = new JTextField(10);
		JLabel nameL = new JLabel("Insert name");
		JLabel descriptionL = new JLabel("Insert description");
		JLabel priceL = new JLabel("Insert price");
		JLabel restockL = new JLabel("Insert restock lvl");
		JButton addDish = new JButton("Add dish");
		JButton addIng = new JButton("Add ingredient");
		addIng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String value = combo.getSelectedItem().toString();
				for(Ingredient i:sm.returnIng()){
					if(value.equals(i.returnName())){
						recipe.put(i, Integer.parseInt(nrIng.getText()));
					}
				}
				
			}
		});
	
	
		
		addDish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(SushiDish dish:sm.returnMenu()){
					if(name.getText().equals(dish.returnName())){
						JOptionPane.showMessageDialog(null, "Dish already in menu");
					}else {
						sm.addDish(new SushiDish(name.getText(),description.getText(),Integer.parseInt(price.getText()),recipe,Integer.parseInt(restockLvl.getText())));
					}
				}
				
			}
		});
		panel.add(nameL);
		panel.add(name);
		panel.add(descriptionL);
		panel.add(description);
		panel.add(priceL);
		panel.add(price);
		panel.add(restockL);
		panel.add(combo);
		button.add(addDish,BorderLayout.NORTH);
		button.add(addIng, BorderLayout.CENTER);
		
		
		this.add(panel);
		this.add(button);
		
	}
}
