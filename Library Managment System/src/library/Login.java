package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	JFrame frmRegister = new JFrame();
	JTextField textField;
	JPasswordField passwordField;
	public String 	username;
	public String 	password;
	ClassInterface dog = new ClassInterface();
	/**
	 * @wbp.parser.entryPoint
	 */
	public  void form(){
	frmRegister.getContentPane().setForeground(Color.YELLOW);
	frmRegister.getContentPane().setBackground(Color.LIGHT_GRAY);
	frmRegister.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 14));
	frmRegister.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yasir_000\\Downloads\\pixel.png"));
	frmRegister.setTitle("Login");
	frmRegister.getContentPane().setLayout(null);
	
	JLabel lblUsername = new JLabel("Username :");
	lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	lblUsername.setOpaque(true);
	lblUsername.setBackground(Color.GRAY);
	lblUsername.setForeground(Color.WHITE);
	lblUsername.setBounds(34, 91, 72, 41);
	frmRegister.getContentPane().add(lblUsername);
	
	JLabel label = new JLabel("");
	label.setBounds(34, 77, 46, 14);
	frmRegister.getContentPane().add(label);
	
	textField = new JTextField();
	textField.setBounds(126, 101, 174, 20);
	frmRegister.getContentPane().add(textField);
	textField.setColumns(10);
	
	JLabel lblPassword = new JLabel("Password:");
	lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 13));
	lblPassword.setOpaque(true);
	lblPassword.setForeground(Color.WHITE);
	lblPassword.setBackground(Color.GRAY);
	lblPassword.setBounds(34, 143, 72, 41);
	frmRegister.getContentPane().add(lblPassword);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(126, 153, 174, 20);
	frmRegister.getContentPane().add(passwordField);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yasir_000\\workspace\\Library Managment System\\images.jpg"));
	lblNewLabel.setBounds(116, 11, 199, 58);
	frmRegister.getContentPane().add(lblNewLabel);
	
	JButton btnSubmit = new JButton("Submit");
	btnSubmit.setBounds(335, 227, 89, 23);
	frmRegister.getContentPane().add(btnSubmit);
	btnSubmit.setActionCommand("OK");
	btnSubmit.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent ae){
			   action();
			   Connection connector =  ConnectDB.getConnection();
			 try {
				String user = username; 
				Statement st = connector.createStatement();
				Statement state = connector.createStatement();
				String query = "SELECT password FROM librarian WHERE name = '" + user + "'";
				String query1 = "UPDATE user set username = '"+user+"' WHERE iduser = '1'";
				ResultSet q = st.executeQuery(query);
				int w = state.executeUpdate(query1);
				StringBuilder b = new StringBuilder();
				int counter = 0;
				String em = "";
				int i = 0;
			if(q.next()){	
				em = q.getString(1);
				String pass1 = new String(computeHash(password));
				System.out.println("This is what i entered:" + pass1);
				System.out.println("This is what is in the database: " + em);
				if(em.equals(pass1)){
					System.out.println(em);
					System.out.println("success");
					dog.gui();
				}
				else {
					System.out.println("Sorry your password did not work!");
					dog.failure();
				}
			}
			
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
}
	});
	frmRegister.setVisible(true);
	}
	public void action() {
		if(textField.getText().isEmpty()){
			System.out.println("Enter something");
		}
		
		else{
			username = textField.getText();
			password = passwordField.getText();
		}
	}
	
	public static byte[] computeHash(String x)
			  throws Exception
			  {
			     java.security.MessageDigest d =null;
			     d = java.security.MessageDigest.getInstance("SHA-1");
			     d.reset();
			     d.update(x.getBytes());
			     return  d.digest();
			  }
}

	
