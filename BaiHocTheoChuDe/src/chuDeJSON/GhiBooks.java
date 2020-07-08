package chuDeJSON;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GhiBooks {
	public static void main(String[] args) throws IOException {
		JSONObject jsObj1 = new JSONObject();
		jsObj1.put("language", "Java");
		jsObj1.put("edition", "first");

		JSONObject jsObj2 = new JSONObject();
		jsObj2.put("language", "Python");
		jsObj2.put("edition", "second");
		
		JSONObject jsObj3 = new JSONObject();
		jsObj3.put("language", "Kotlin");
		jsObj3.put("edition", "third");
		
		JSONArray books = new JSONArray();
		books.add(jsObj1);
		books.add(jsObj2);
		books.add(jsObj3);
		
		JSONObject jsObj = new JSONObject();
		jsObj.put("books", books);
		
		FileWriter fw = new FileWriter("books2.json");
		fw.write(jsObj.toJSONString());
		fw.close();
		
	}
}
