import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeRestockIng extends JFrame {
	StockManagement sm;
	Ingredient ingredient;
	public ChangeRestockIng(StockManagement sm, Ingredient ingredient) {
		this.sm=sm;
		this.ingredient=ingredient;
		setTitle("Change stocklvl");
		setSize(300, 300);
		this.setLayout(new GridLayout(2, 1));
		setVisible(true);
		setResizable(false);
		init();
	}
	public void close(){
		this.dispose();
	}
	public void init(){
		JPanel text = new JPanel();
		JTextField field = new JTextField(10);
		text.setSize(300,125);
		text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
		text.add(field);
		text.add(Box.createVerticalStrut(25));
		this.add(text);
		JButton change = new JButton("Change stock level");
		change.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(field.getText().matches("^-?\\d+$")){
					ingredient.changeRestock(Integer.parseInt(field.getText()));
					close();
				
			}
		}});
		JPanel button = new JPanel();
		button.setSize(300,150);
		button.add(change);
		this.add(button);
	}

}