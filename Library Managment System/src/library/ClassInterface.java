package library;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ClassInterface {
	MemberRecord jar = new MemberRecord();
	
	public void gui() {
		JFrame frmOptions = new JFrame();
		frmOptions.getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		frmOptions.setTitle("Options");
		frmOptions.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				  jar.showBooks();
				  jar.pack();
				  jar.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(34, 71, 139, 46);
		frmOptions.getContentPane().add(btnNewButton);
		
		JButton btnRemoveBooks = new JButton("Remove Books");
		btnRemoveBooks.setForeground(Color.BLUE);
		btnRemoveBooks.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 14));
		btnRemoveBooks.setBounds(34, 128, 184, 46);
		frmOptions.getContentPane().add(btnRemoveBooks);
		
		JButton btnPayBill = new JButton("Pay Bill");
		btnPayBill.setForeground(Color.BLUE);
		btnPayBill.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 14));
		btnPayBill.setBounds(34, 185, 184, 46);
		frmOptions.getContentPane().add(btnPayBill);
		btnPayBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jar.payBill();
			}
		});
		
		JButton btnChangeProfile = new JButton("Change Profile");
		btnChangeProfile.setForeground(Color.BLUE);
		btnChangeProfile.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 14));
		btnChangeProfile.setBounds(34, 242, 184, 46);
		frmOptions.getContentPane().add(btnChangeProfile);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBounds(237, 11, 97, 46);
		frmOptions.getContentPane().add(lblNewLabel_1);
		frmOptions.setVisible(true);
		btnChangeProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Librarian lib = new Librarian();
				lib.changeProfile();
			}
		});
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void failure() {
		JFrame frmIncorrect = new JFrame();
		frmIncorrect.setBackground(Color.WHITE);
		frmIncorrect.setTitle("Incorrect");
		frmIncorrect.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yasir_000\\workspace\\Library Managment System\\cross-512.png"));
		lblNewLabel.setBounds(54, 66, 97, 110);
		frmIncorrect.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password Incorrect");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(190, 66, 230, 110);
		frmIncorrect.getContentPane().add(lblNewLabel_2);
		frmIncorrect.setVisible(true);
	}
}
