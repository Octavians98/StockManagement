import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartBusiness extends JFrame {
	StockManagement sm;
	int nr=0;
	public StartBusiness(StockManagement sm){
		this.sm=sm;
		setTitle("Start the thread");
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
		JButton drone = new JButton("Add a drone");
		drone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nr++;
				new Thread(new Drone(100, nr, sm)).start();

			}
		});
		drone.setPreferredSize(new Dimension(290, 100));
		drone.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JButton kitchenStaff = new JButton("Add new kitchen stuff");
		kitchenStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Thread(new KitchenStaff("nr", sm)).start();


			}
		});
		kitchenStaff.setPreferredSize(new Dimension(290, 100));
		kitchenStaff.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		pane.add(drone);
		pane.add(kitchenStaff);

		this.add(pane);
		this.pack();
	}

}
