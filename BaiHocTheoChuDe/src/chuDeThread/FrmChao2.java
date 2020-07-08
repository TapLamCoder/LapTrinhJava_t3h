package chuDeThread;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmChao2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtChao;

	/**
	 * Launch the application.
	 */
	static class ChayChu extends Thread{
		private StringBuilder sb = new StringBuilder("Trung tâm tin học Đại học Khoa học tự nhiên ");
		private Object ob;
		public ChayChu(Object ob) {
			this.ob = ob;
		}
		@Override
			public void run() {
				while(ob!=null) {
					sb.insert(0, sb.substring(sb.lastIndexOf(" "),sb.length()));//		sb.append(sb.substring(0,1)); 
					sb.delete(sb.lastIndexOf(" "),sb.length());//					sb.delete(0,1);//sb.delete(lastIndexOf(" ",sb.length()));
					if(ob instanceof JFrame)
						((JFrame) ob).setTitle(sb.toString());
					if(ob instanceof JTextField)
						((JTextField) ob).setText(sb.toString());
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
					FrmChao2 frame = new FrmChao2();
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
	public FrmChao2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtChao = new JTextField();
		txtChao.setEditable(false);
		txtChao.setBounds(10, 125, 414, 20);
		contentPane.add(txtChao);
		txtChao.setColumns(10);
		ChayChu chayChuTextField = new ChayChu(txtChao);
		chayChuTextField.start();
		
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