import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame{
	StockManagement sm;
	File file = new File("contacts.txt");
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);


		public LogIn(StockManagement sm){
			this.sm = sm;
			setTitle("Log in");
			setSize(500,150);
			this.setLayout(new FlowLayout());
			setVisible(true);
			init();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
		}
		
		
		public void init(){
			JButton signUp = new JButton("Sign up");
			signUp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SignUp u = new SignUp();
					
				}
			});

			JLabel luser = new JLabel("User: ");
			JLabel lpassword = new JLabel("Password: ");
			txuser.setBounds(70,30,150,20);
			pass.setBounds(70,65,150,20);
			blogin.setBounds(110,100,80,20);
			panel.add(luser);
			panel.add(txuser);
			panel.add(lpassword);
			panel.add(pass);
			panel.add(signUp);
			panel.add(blogin);
			panel.setLayout(new GridLayout(4, 2));
			this.add(panel);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			actionlogin();
		}
		
		public void actionlogin(){
			
			blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			String puname = txuser.getText();
			String ppaswd = pass.getText();
			try {
				if(CheckLogin(txuser.getText(), pass.getText())) {
					Menu menu = new Menu(sm);
					dispose();
				} else {

				JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				
				
				}
			} catch (HeadlessException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			}
});
			
			}
		private boolean CheckLogin(String username, String password) throws FileNotFoundException {
	        String identification = username + "%" + password;
	        Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.contains(identification)) return true;
	        }

	        return false;
	    }
}

