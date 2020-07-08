package chuDeListSetMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Vd1 
{

	public static void main(String[] args) 
	{
		ArrayList ds1 = new ArrayList();
		ds1.add(1);
		ds1.add("abc");
		ds1.add(1.5);
		ds1.add(new Date());
		ds1.add(true);
		ds1.add(1);
		System.out.println("\nCac phan tu trong List");
		for(Object ob:ds1)
			System.out.println(ob.toString());

		HashSet ds2 = new HashSet();
		ds2.add(1);
		ds2.add("abc");
		ds2.add(1.5);
		ds2.add(new Date());
		ds2.add(true);
		ds2.add(1);
		System.out.println("\nCac phan tu trong Set");
		for(Object ob:ds2)
			System.out.println(ob.toString());

		System.out.println("\nCac phan tu trong Map");
		HashMap td = new HashMap();
		td.put(1, "mot");
		td.put(4, "bon");
		td.put(2, "hai");
		td.put(5, "nam");
		td.put(3, "ba");
		for(Object k:td.keySet()) {
			System.out.println(k.toString() + "---> "+td.get(k));
		}
	}
}
