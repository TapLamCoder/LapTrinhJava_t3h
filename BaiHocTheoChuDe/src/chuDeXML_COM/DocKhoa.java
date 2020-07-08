package chuDeXML_COM;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DocKhoa {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("khoa.xml");
		
		Element rootNode = doc.getDocumentElement();
		System.out.println("Ten node: "+rootNode.getNodeName()); //return root node name "khoa"
		System.out.println("Kieu node: "+rootNode.getNodeType());//return 1
		System.out.println("Gia tri: "+rootNode.getNodeValue());//return null
		System.out.println("Noi dung text: "+rootNode.getTextContent());//return AV \n Anh van
		
		NodeList nodeList = rootNode.getChildNodes();
		System.out.println("So node con : "+nodeList.getLength()); //return 5
		for(int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i); //return #text makh #text tenkh #text
			System.out.println("Ten node: "+node.getNodeName());
		}
		
		NodeList nodeList1 = doc.getElementsByTagName("khoa");
		for(int i=0; i<nodeList1.getLength(); i++) {
			Node node1 = nodeList1.item(i);
			NodeList nodeList2 = node1.getChildNodes();
			String makh=null, tenkh=null;
			for(int j=0; j<nodeList2.getLength(); j++) {
				Node node2 = nodeList2.item(j);
				if(node2.getNodeType()==Node.ELEMENT_NODE) 
				{
					if(node2.getNodeName().equals("makh"))
						makh = node2.getTextContent();
					else
						tenkh = node2.getTextContent();
				}
			}
			System.out.println(makh+ " - "+ tenkh);
		}

	}

}
