import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewIngredient extends JFrame{
	StockManagement sm;
	public AddNewIngredient(StockManagement sm){
		this.sm=sm;
		setTitle("Add a new ingredient");
		setSize(400, 150);
		this.setLayout(new FlowLayout());
		setVisible(true);
		setResizable(false);
		init();
	}
	public void init(){
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setSize(400,300);
		JPanel button = new JPanel();
		button.setVisible(true);
		button.setSize(400,100);
		panel.setLayout(new GridLayout(4,2,10,10));
		button.setLayout(new GridLayout(1, 3));
		JTextField name = new JTextField(10);
		JTextField unit = new JTextField(10);
		JTextField supplier = new JTextField(10);
		JTextField restockLvl = new JTextField(10);
		JLabel nameL = new JLabel("Insert name");
		JLabel unitL = new JLabel("Insert unit(kg,l etc)");
		JLabel supplierL = new JLabel("Insertsupplier name");
		JLabel restockL = new JLabel("Insert restock lvl");
		JButton addIng = new JButton("Add ingredient");
		addIng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Supplier sup = null;
				for(Ingredient ingredient:sm.returnIng()){
					if(name.getText().equals(ingredient.returnName())){
						JOptionPane.showMessageDialog(null,"This ingredient already exist");
					}else{
						for(Supplier s:sm.returnSupplier()){
							if(supplier.getText().equals(s.returnName())){
								sup=s;
							}
						}
						if(sup!=null){
							sm.addIng(new Ingredient(name.getText(), unit.getText(), sup, Integer.parseInt(restockLvl.getText())));
							dispose();
						}else JOptionPane.showMessageDialog(null, "You don`t work with this supplier");
					}
				}
				
			}
		});
		panel.add(nameL);
		panel.add(name);
		panel.add(unitL);
		panel.add(unit);
		panel.add(supplierL);
		panel.add(supplier);
		panel.add(restockL);
		panel.add(restockLvl);
		button.add(addIng,BorderLayout.CENTER);
		this.add(panel);
		this.add(button);		
	}
	
	
	
	
	
	
}
