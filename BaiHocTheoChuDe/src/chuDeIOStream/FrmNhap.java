package chuDeIOStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrmNhap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhap frame = new FrmNhap();
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
	public FrmNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHinh = new JLabel("");
		lblHinh.setBounds(52, 21, 329, 177);
		contentPane.add(lblHinh);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
					
					FileOutputStream fos = new FileOutputStream("newdesert.jpg");
					int b;
					while ((b = fis.read()) != -1)
							{
								fos.write(b);
							}
					fos.close();
					fis.close();
					
					
					
				} catch (FileNotFoundException e1) 
				{
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ImageIcon ii = new ImageIcon("newdesert.jpg");
				//ii.setImage(ii.getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), ));
			
			}
			
		});
		btnNewButton.setBounds(175, 216, 89, 23);
		contentPane.add(btnNewButton);
	}
}
