package chuDeLambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Vd2 {

	public static void main(String[] args) {
		List<String> ds1 = Arrays.asList("mai","lan","cuc","truc");
		
		//duyet danh sach bang for
		System.out.println("Duyet danh sach bang for");
		for(String s:ds1)
			System.out.print(s+" ");
		
		//duyet danh sach bang lambda
		System.out.println("\nDuyet danh sach bang lambda");
		ds1.forEach(s->System.out.print(s+", "));	
		
		Map<String,String> td = new TreeMap<>();
		td.put("interface", "giao tiep");
		td.put("abstract", "truu tuong");
		td.put("class", "lop");
		td.put("implement", "thuc thi");
		td.put("extend", "ke thua");
		
		System.out.println("\nDuyet Map bang for");
		for(String k:td.keySet())
			System.out.println(k+" --> "+td.get(k));
		
		System.out.println("\nDuyet Map bang lambda");
		td.forEach((k,v)->System.out.println(k+" ---> "+v));
	
		Arrays.
	}

}