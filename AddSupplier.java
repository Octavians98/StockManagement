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

public class AddSupplier extends JFrame {
	StockManagement sm;
	public AddSupplier(StockManagement sm){
		this.sm=sm;
		setTitle("Add a new supplier");
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
		JTextField distance = new JTextField(10);

		JLabel nameL = new JLabel("Insert name");
		JLabel distanceL = new JLabel("Insert distance");

		JButton addSupp = new JButton("Add supplier");
		addSupp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for(Supplier s:sm.returnSupplier()){
					if(name.getText().equals(s.returnName())){
						JOptionPane.showMessageDialog(null,"This supplier already exist");
					}else{


						sm.addSupplier(new Supplier(name.getText(),Integer.parseInt(distance.getText())));
						dispose();
					}
				}


			}
		});
		panel.add(nameL);
		panel.add(name);
		panel.add(distanceL);
		panel.add(distance);

		button.add(addSupp,BorderLayout.CENTER);
		this.add(panel);
		this.add(button);		
	}






}


