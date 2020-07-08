package chuDeJSON;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FormBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtLanguage;
	private JTextField txtEdition;
	private JTable tbBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBook frame = new FormBook();
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
	public FormBook() {
		setTitle("Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Language");
		lblNewLabel.setBounds(51, 30, 97, 14);
		contentPane.add(lblNewLabel);
		
		txtLanguage = new JTextField();
		txtLanguage.setBounds(158, 27, 170, 20);
		contentPane.add(txtLanguage);
		txtLanguage.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Edition");
		lblNewLabel_1.setBounds(51, 66, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEdition = new JTextField();
		txtEdition.setBounds(158, 63, 170, 20);
		contentPane.add(txtEdition);
		txtEdition.setColumns(10);
		
		JButton btnThem = new JButton("Ghi");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("books3.json");
				
				JSONObject jsObj = null;
				JSONArray books;
				
				if(file.isFile()) {
					JSONParser jsPar = new JSONParser();
					try {
						jsObj = (JSONObject) jsPar.parse(new FileReader(file));
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					}
					books = (JSONArray) jsObj.get("books");
				}
				else {
					jsObj = new JSONObject();
					books = new JSONArray();
				}
				
				//doc book moi them
				String language, edition;
				language = txtLanguage.getText();
				edition = txtEdition.getText();
				
				JSONObject jsObjNew = new JSONObject();
				jsObjNew.put("language", language);
				jsObjNew.put("edition",edition);
				
				//them book moi vao mang books 
				books.add(jsObjNew);
				
				//thiet lap lai key books theo gia tri moi
				jsObj.put("books", books);
				
				//ghi ra tap tin json
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(jsObj.toJSONString());
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnThem.setBounds(111, 112, 89, 23);
		contentPane.add(btnThem);
		
		JButton btnDoc = new JButton("\u0110\u1ECDc");
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JSONParser jsp = new JSONParser(); 
				JSONObject jso = null;
				DefaultTableModel dtm = (DefaultTableModel) tbBook.getModel();
				dtm.setRowCount(0);
				try {
					jso = (JSONObject) jsp.parse(new FileReader("books3.json"));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}
				JSONArray jsa = (JSONArray)jso.get("books");
				for (Object jsi : jsa)
				{
					JSONObject jso2 = (JSONObject) jsi;
					String language = jso2.get("language").toString();
					String edition = jso2.get("edition").toString();
					dtm.addRow(new Object[] {language, edition});
				}
				
			}
		});
		btnDoc.setBounds(239, 112, 89, 23);
		contentPane.add(btnDoc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 158, 354, 140);
		contentPane.add(scrollPane);
		
		tbBook = new JTable();
		tbBook.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Language", "Edition"
			}
		));
		scrollPane.setViewportView(tbBook);
	}
}
