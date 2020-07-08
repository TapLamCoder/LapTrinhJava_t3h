package baiTapTheoSoBai;

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

public class BT15_2_FrmDangNhap extends JFrame {

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
					BT15_2_FrmDangNhap frame = new BT15_2_FrmDangNhap();
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
	public BT15_2_FrmDangNhap() {
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
				try {
					//buoc 1: nap trinh dieu khien
					Class.forName("com.mysql.jdbc.Driver");
					
					//buoc 2: tao chuoi ket noi
					String url = "jdbc:mysql://localhost:3308/qllienhe?useUnicode=true&characterEncoding=UTF-8";
					
					//buoc 3: tao ket noi
					Connection ketNoi = DriverManager.getConnection(url, "root", "");
					
					//buoc 4: tao phat bieu
					PreparedStatement pst = ketNoi.prepareStatement("select * from user where username=? and password=?");
					pst.setString(1, userName);
					pst.setString(2,passWord);
//					Statement stm = ketNoi.createStatement();
					
					//buoc 5: thuc hien cau truy van
//					String sql = "select * from user where username='"+userName+"' and password='"+password+"'";
					ResultSet rs = pst.executeQuery();
					
					//buoc 6: xu ly ket qua
					if(rs.next())
						JOptionPane.showMessageDialog(rootPane, "Ban da dang nhap thanh cong");
					else
						JOptionPane.showMessageDialog(rootPane, "Ten dang nhap hoac mat khau sai");
					
					//buoc 7: dong ket noi
					ketNoi.close();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
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
