package chuDeXML_COM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class GhiKhoa {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		
		//buoc 1: tao document XML
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Element khoaNode = doc.createElement("khoa");
		doc.appendChild(khoaNode);
		
		Element makhNode = doc.createElement("makh");
		khoaNode.appendChild(makhNode);
		
		Text makhTextNode = doc.createTextNode("AV");
		makhNode.appendChild(makhTextNode);
		
		Element tenkhNode = doc.createElement("tenkh");
		khoaNode.appendChild(tenkhNode);
		
		Text tenkhTextNode = doc.createTextNode("Anh van");
		tenkhNode.appendChild(tenkhTextNode);
		
		//buoc 2: bien doi document XML ra file
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		
		//File file = new File("khoa2.xml");
		
		//Source source = new DOMSource(doc);
		//Result result = new StreamResult(file);
		
		//tf.transform(source, result);
		
		tf.transform(new DOMSource(doc),new StreamResult(new File("khoa2.xml")));
	}

}
