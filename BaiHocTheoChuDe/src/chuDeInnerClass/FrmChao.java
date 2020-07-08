package chuDeInnerClass;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChao frame = new FrmChao();
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
	class XuLyHanhDong implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(rootPane, "Chào mừng bạn đến với lập trình Lớp lồng cấp vô danh");
		}
	}
	public FrmChao() {
		setTitle("Ch\u00E0o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChao = new JButton("Ch\u00E0o");
		
		XuLyHanhDong xuLy = new XuLyHanhDong();
		btnChao.addActionListener(xuLy);
		
//		btnChao.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				JOptionPane.showMessageDialog(rootPane, "Chào mừng bạn đến với lập trình Lớp lồng cấp vô danh");
//			}
//		});
		btnChao.setBounds(148, 100, 132, 23);
		contentPane.add(btnChao);
	}

}