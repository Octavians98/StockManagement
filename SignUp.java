import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	File file= new File("contacts.txt");
	String[] postCodes ={"SO182NU","BH238EF","GU51","RG27","GU35"};
	 String postS;
	public SignUp(){
   	
    setTitle("Sign up form");
	setSize(500,150);
	this.setLayout(new FlowLayout());
	init();
	setVisible(true);
	
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	}
    public void init(){
    	
        JTextField user = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JPasswordField checkPassword = new JPasswordField(20);
         JLabel luser = new JLabel("User: ");
         JLabel lpassword = new JLabel("Enter password: ");
         JLabel lcheckPassword = new JLabel("Enter password again: ");
         JLabel left=new JLabel(" ");
         JButton register = new JButton("Register");
         JComboBox post = new JComboBox(postCodes);
         post.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				postS=post.getSelectedItem().toString();
				
				
			}
		});
          
         register.addActionListener(new ActionListener() { 
             
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedWriter writer;
                try {
                    FileWriter fileW = new FileWriter(file,true);
                   
                    if(password.getText().equals(checkPassword.getText())){
                    	if(!CheckLogin(user.getText())){
                   fileW.write(user.getText() + "%" + password.getText()+" "+postS+"\r"+"\n");
                   fileW.flush();
                   fileW.close();}else JOptionPane.showMessageDialog(null, "User already registered");}else JOptionPane.showMessageDialog(null,"Password don`t match");
                } catch(FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
               dispose();
            }
        });
         JPanel panel = new JPanel();
         GridLayout gridLayout = new GridLayout(4,2);
         panel.setLayout(gridLayout);
         panel.add(luser);
         panel.add(user);
         panel.add(lpassword);
         panel.add(password);
         panel.add(lcheckPassword);
         panel.add(checkPassword);
         panel.add(post);
        // panel.add(left);
         panel.add(register);
         
         this.add(panel);
   }
    private boolean CheckLogin(String username) throws FileNotFoundException {
        String identification = username;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(identification)) return true;
        }

        return false;
    }
   }

