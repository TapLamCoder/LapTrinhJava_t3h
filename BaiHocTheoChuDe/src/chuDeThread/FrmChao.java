package chuDeThread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static class ChayChu extends Thread{
		private StringBuilder sb = new StringBuilder("Trung tâm tin học Đại học Khoa học tự nhiên                             ");
		private JFrame frm;
		public ChayChu(Object ob) {
			frm = (JFrame) ob;
		}
		@Override
			public void run() {
				while(frm != null) {
					sb.append(sb.substring(0,1));
					sb.delete(0,1);
					frm.setTitle(sb.toString());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChao frame = new FrmChao();
					ChayChu chayChu = new ChayChu(frame);
					chayChu.start();
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
	public FrmChao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChao = new JButton("Ch\u00E0o");
		btnChao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(rootPane, "Chào mừng các bạn đến với lập trình đa luồng của Java!");
			}
		});
		btnChao.setBounds(180, 94, 89, 23);
		contentPane.add(btnChao);
	}
}