package chuDeIOStream;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrmSanPham extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTenSP;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSanPham frame = new FrmSanPham();
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
	public FrmSanPham() {
		setTitle("S\u1EA3n ph\u1EA9m");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 11, 383, 115);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "T\u00EAn s\u1EA3n ph\u1EA9m",
				"S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("T\u00EAn SP");
		lblNewLabel.setBounds(72, 167, 67, 14);
		contentPane.add(lblNewLabel);

		txtTenSP = new JTextField();
		txtTenSP.setBounds(149, 164, 206, 20);
		contentPane.add(txtTenSP);
		txtTenSP.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_1.setBounds(72, 204, 67, 14);
		contentPane.add(lblNewLabel_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(149, 201, 86, 20);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_2.setBounds(72, 245, 67, 14);
		contentPane.add(lblNewLabel_2);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(149, 242, 86, 20);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);

		JButton btnGhi = new JButton("Ghi");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tenSP;
				int soLuong;
				Float donGia;

				tenSP = txtTenSP.getText();
				soLuong = Integer.parseInt(txtSoLuong.getText());
				donGia = Float.parseFloat(txtDonGia.getText());

				try {
					DataOutputStream dos = new DataOutputStream(new FileOutputStream("sanpham.dat",true));
					dos.writeUTF(tenSP);
					dos.writeInt(soLuong);
					dos.writeFloat(donGia);
					dos.close();
					JOptionPane.showMessageDialog(rootPane, "Da ghi xong, xin nhan doc");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnGhi.setBounds(182, 278, 89, 23);
		contentPane.add(btnGhi);

		JButton btnDoc = new JButton("\u0110\u1ECDc ");
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					DataInputStream dis = new DataInputStream(new FileInputStream("sanpham.dat"));

					String tenSP;
					int soLuong;
					float donGia;
					
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.setRowCount(0);
					
					while (true)
						try 
					{
							tenSP = dis.readUTF();
							soLuong = dis.readInt();
							donGia = dis.readFloat();
							double thanhTien = soLuong*donGia;
							dtm.addRow(new Object[] {tenSP,soLuong,donGia,thanhTien});
							
					} catch (Exception e) 
						{
							break;
						}
					dis.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}

			}
		});
		btnDoc.setBounds(303, 130, 89, 23);
		contentPane.add(btnDoc);
	}
}
