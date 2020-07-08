package chuDeListSetMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Vd2 {

	public static void main(String[] args) {
		List<String> ds1 = new ArrayList<String>();
		ds1.add("2");
		ds1.add("abc");
		ds1.add("4");
		ds1.add("xyz");
		for(String s:ds1) 
			System.out.println(s);
		
		Set<Integer> ds2 = new HashSet<Integer>();
		ds2.add(5);
		ds2.add(1);
		ds2.add(3);
		ds2.add(4);
		int tong = 0;
		for(int so:ds2)
			tong+=so;
		System.out.println("tong = "+tong);
	
		Map<Integer,String> td = new HashMap<Integer, String>();
		td.put(1, "one");
		td.put(2, "two");
		td.put(3, "three");
		td.put(4, "four");
		td.put(5, "five");
		if(!td.containsKey(3))
			td.put(3, "five");
		for(int k:td.keySet())
			System.out.println(k + " ---> "+td.get(k));
		for(int k:td.keySet())
			System.out.println(k + "key leads to " + td.get(k));
	}

}
