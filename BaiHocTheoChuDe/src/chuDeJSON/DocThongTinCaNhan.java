package chuDeJSON;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocThongTinCaNhan {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//buoc 1: tao doi tuong phan tich
		JSONParser jsPar = new JSONParser();
		
		//buoc 2: phan tich tu file ra doi tuong JSON
		JSONObject jsObj = (JSONObject) jsPar.parse(new FileReader("thongtincanhan.json"));
		
		//buoc 3: doc name tra ve value
		String name, address;
		long age;
		JSONArray courses;
		
		name = jsObj.get("name").toString();
		address = jsObj.get("address").toString();
		age = (long) jsObj.get("age");
		courses = (JSONArray) jsObj.get("courses");
		
		System.out.println("Personal information\n");
		System.out.println("Name: "+name);
		System.out.println("Address: "+address);
		System.out.println("Age: "+age);
		System.out.println("Courses: ");
		 for(int i=0; i<courses.size(); i++) 
		 { String course =
		  courses.get(i).toString(); System.out.println("\t"+course); 
		 }
		 
	}

}

