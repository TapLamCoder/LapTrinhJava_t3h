package presentationLayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Throwable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLayer.UserBL;
import dataTransferObject.User;

public class LoginPanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel frame = new LoginPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPanel() {
		setTitle("Dang Nhap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Dang Nhap");
//		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName, passWord;
				userName = txtUserName.getText();
				passWord = new String(txtPassword.getPassword());
				User user = UserBL.timUser(userName,passWord);;
				if(user!=null)
					JOptionPane.showMessageDialog(rootPane, "Ban da dang nhap thanh cong!");
				else
					JOptionPane.showMessageDialog(rootPane, "Ten dang nhap hoac mat khau sai");
			}
		});
		btnLogin.setBounds(164, 181, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(45, 69, 63, 14);
		contentPane.add(lblNewLabel);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(131, 66, 240, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 110, 46, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(131, 107, 122, 20);
		contentPane.add(txtPassword);
	}
}
