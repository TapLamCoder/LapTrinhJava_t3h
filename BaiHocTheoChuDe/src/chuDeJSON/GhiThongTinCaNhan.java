package chuDeJSON;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GhiThongTinCaNhan {

	public static void main(String[] args) throws IOException {
		//buoc 1: tao doi tuong JSON
		JSONObject jsObj = new JSONObject();
		
		//buoc 2: them cac key va value
		jsObj.put("name", "Ly Man Hinh");
		jsObj.put("address", "227 Nguyen Van Cu");
		jsObj.put("age", 25);
		
		JSONArray courses = new JSONArray();
		courses.add("LT Java");
		courses.add("LT Python");
		courses.add("LT Android");
		
		jsObj.put("courses", courses);
		
		//buoc 3: ghi ra tap tin
		FileWriter fw = new FileWriter("thongtincanhan2.json");
		fw.write(jsObj.toJSONString());
		fw.close();
	}

}
