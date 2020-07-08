package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import businessLayer.LienHeBL;
import dataTransferObject.LienHe;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FrmBT5_3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtDienThoai;
	private JTextField txtHinhAnh;
	private JLabel lblHinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBT5_3 frame = new FrmBT5_3();
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
	public FrmBT5_3() {
		setTitle("Th\u00EAm li\u00EAn h\u1EC7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel.setBounds(35, 29, 76, 14);
		contentPane.add(lblNewLabel);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(121, 26, 198, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblNewLabel_1.setBounds(35, 62, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(121, 60, 86, 20);
		contentPane.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("H\u00ECnh \u1EA3nh");
		lblNewLabel_2.setBounds(35, 98, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		txtHinhAnh = new JTextField();
		txtHinhAnh.setBounds(121, 94, 198, 20);
		contentPane.add(txtHinhAnh);
		txtHinhAnh.setColumns(10);
		
		JButton btnThemMoi = new JButton("Th\u00EAm m\u1EDBi");
		btnThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String hoTen, dienThoai, hinhAnh;
				
				hoTen = txtHoTen.getText();
				dienThoai = txtDienThoai.getText();
				hinhAnh = txtHinhAnh.getText();
				
				LienHe lh = new LienHe(hoTen, dienThoai, hinhAnh);
				int smt = LienHeBL.themLienHe(lh);
				if(smt>0)
					JOptionPane.showMessageDialog(rootPane, "Da them lien he thanh cong");
				else
					JOptionPane.showMessageDialog(rootPane, "Khong them duoc lien le");
			}
		});
		btnThemMoi.setBounds(134, 145, 117, 23);
		contentPane.add(btnThemMoi);
		
		JButton btnChonHinh = new JButton("...");
		btnChonHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser("src/hinhanh");
				FileNameExtensionFilter ff1 = new FileNameExtensionFilter("Cac tap tin *.jpg", "jpg");
				FileNameExtensionFilter ff2 = new FileNameExtensionFilter("Cac tap tin *.png", "png");
				jfc.setFileFilter(ff1);
				jfc.setFileFilter(ff2);
				jfc.setDialogTitle("Hay chon mot tap tin hinh anh");
				int chon = jfc.showOpenDialog(rootPane);
				if(chon == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					String tt = file.getAbsolutePath();
					txtHinhAnh.setText(tt);
					ImageIcon icon = new ImageIcon(tt);
					icon.setImage(icon.getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_DEFAULT));
					lblHinh.setIcon(icon);
				}
			}
		});
		btnChonHinh.setBounds(332, 94, 31, 23);
		contentPane.add(btnChonHinh);
		
		lblHinh = new JLabel("");
		lblHinh.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblHinh.setBounds(371, 11, 175, 164);
		contentPane.add(lblHinh);
	}
}
