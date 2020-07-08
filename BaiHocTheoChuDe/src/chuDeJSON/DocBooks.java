package chuDeJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocBooks {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//buoc 1: tao doi tuong phan tich
		JSONParser jsPar = new JSONParser();
		
		//buoc 2: phan tich tu file ra doi tuong JSON
		JSONObject jsObj = (JSONObject) jsPar.parse(new FileReader("books.json"));
		
		//buoc 3: doc key tra ve value
		JSONArray jsArr = (JSONArray) jsObj.get("books");
		
		//buoc 4: xuat ket qua
		for(int i=0; i<jsArr.size(); i++) {
			JSONObject jsObj2 = (JSONObject) jsArr.get(i);
			
			String language, edition;
			language = jsObj2.get("language").toString();
			edition = jsObj2.get("edition").toString();
			
			System.out.println(String.format("%s %s", language, edition));
		}
	}

}
