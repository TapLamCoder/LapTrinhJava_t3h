package baiTapTheoSoBai;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FrmBT10_1 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBT10_1 frame = new FrmBT10_1();
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
	public FrmBT10_1() {
		setTitle("B\u00E0i t\u1EADp 10.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 32, 350, 141);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(80);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"aaa", "234234234", "C:\\Users\\Public\\Pictures\\Sample Pictures\\koala.jpg"},
				{"bbbb", "546345435", "C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg"},
				{"cccc", "2353434324", "C:\\Users\\Public\\Pictures\\Sample Pictures\\penguins.jpg"},
			},
			new String[] {
				"H\u1ECD t\u00EAn", "\u0110i\u1EC7n tho\u1EA1i", "H\u00ECnh \u1EA3nh"
			}
		));
		table.getColumnModel().getColumn(2).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel lbl = new JLabel();
				ImageIcon icon = new ImageIcon(value.toString());
				icon.setImage(icon.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT));
				lbl.setIcon(icon);
				return lbl;
			}
		});
		scrollPane.setViewportView(table);
	}
}

