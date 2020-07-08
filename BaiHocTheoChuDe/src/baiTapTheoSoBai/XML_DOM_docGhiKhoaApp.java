package baiTapTheoSoBai;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class XML_DOM_docGhiKhoaApp extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKhoa;
	private JTextField txtTenKhoa;
	private JTable tbKhoa;
	private JScrollPane scrollPane;
	private JButton btnDocKhoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XML_DOM_docGhiKhoaApp frame = new XML_DOM_docGhiKhoaApp();
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
	public XML_DOM_docGhiKhoaApp() {
		setTitle("Doc Ghi Khoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaKhoa = new JLabel("Ma Khoa");
		lblMaKhoa.setBounds(65, 43, 46, 14);
		contentPane.add(lblMaKhoa);
		
		JLabel lblTenKhoa = new JLabel("Ten Khoa");
		lblTenKhoa.setBounds(65, 68, 46, 14);
		contentPane.add(lblTenKhoa);
		
		txtMaKhoa = new JTextField();
		txtMaKhoa.setBounds(166, 40, 167, 20);
		contentPane.add(txtMaKhoa);
		txtMaKhoa.setColumns(10);
		
		txtTenKhoa = new JTextField();
		txtTenKhoa.setBounds(166, 65, 167, 20);
		contentPane.add(txtTenKhoa);
		txtTenKhoa.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 128, 343, 84);
		contentPane.add(scrollPane);
		
		tbKhoa = new JTable();
		tbKhoa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma Khoa", "Ten Khoa"
			}
		));
		tbKhoa.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane.setViewportView(tbKhoa);
		
		JButton btnGhiKhoa = new JButton("Ghi Khoa");
		btnGhiKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					
					Document doc;
					Element dskhoaNode;
					
					File file = new File("dskhoa2.xml");
					
					if(file.isFile()) {
						doc = db.parse(file);
						dskhoaNode = doc.getDocumentElement();
					}else {
						doc = db.newDocument();
						dskhoaNode = doc.createElement("dskhoa");
						doc.appendChild(dskhoaNode);
					}
					
					Element khoaNode = doc.createElement("khoa");
					dskhoaNode.appendChild(khoaNode);
					
					Element makhNode = doc.createElement("makh");
					khoaNode.appendChild(makhNode);
					
					Text makhTextNode = doc.createTextNode(txtMaKhoa.getText());
					makhNode.appendChild(makhTextNode);
					
					Element tenkhNode = doc.createElement("tenkh");
					khoaNode.appendChild(tenkhNode);
					
					Text tenkhTextNode = doc.createTextNode(txtTenKhoa.getText());
					tenkhNode.appendChild(tenkhTextNode);
					
					TransformerFactory tff = TransformerFactory.newInstance();
					Transformer tf = tff.newTransformer();
					tf.transform(new DOMSource(doc), new StreamResult(file));
					
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGhiKhoa.setBounds(166, 96, 89, 23);
		contentPane.add(btnGhiKhoa);
		
		btnDocKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					
					Document doc = db.parse("dskhoa2.xml");
					NodeList nodeList1 = doc.getElementsByTagName("khoa");
					
					DefaultTableModel dtm = (DefaultTableModel) tbKhoa.getModel();
					dtm.setRowCount(0);
					
					for(int i=0; i<nodeList1.getLength(); i++) {
						Node node1 = nodeList1.item(i);
						NodeList nodeList2 = node1.getChildNodes();
						String makh=null, tenkh=null;
						for(int j=0; j<nodeList2.getLength(); j++) {
							Node node2 = nodeList2.item(j);
							if(node2.getNodeType()==Node.ELEMENT_NODE) {
								if(node2.getNodeName().equals("makh"))
									makh = node2.getTextContent();
								else
									tenkh = node2.getTextContent();
							}
						}
						dtm.addRow(new String[] {makh,tenkh});
					}
				} catch (ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}
			}
		});

		btnDocKhoa.setBounds(166, 215, 89, 23);
		contentPane.add(btnDocKhoa);
	}
}
