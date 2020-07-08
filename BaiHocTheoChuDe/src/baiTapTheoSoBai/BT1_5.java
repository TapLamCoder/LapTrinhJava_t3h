package baiTapTheoSoBai;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BT1_5 {
	public static void main(String[] args) {
		List<String> ds = Arrays.asList("void","class","virtual","extend","implement","abstract","public","private","protected");
		
		System.out.println("Sap xep thu tu theo Alphabet");
		Collections.sort(ds);
		ds.forEach(s->System.out.println(s));
		
		System.out.println("Sap xep chieu dai chuoi tang dan");
		ds.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length())
					return -1;
				else if(o1.length()==o2.length())
					return 0;
				else
					return 1;
			}
		});
		ds.forEach(s->System.out.println(s));
		
		System.out.println("Sap xep chieu dai chuoi giam dan");
		ds.sort(//new 
				(s1,s2)->{
			if(s1.length()<s2.length())
				return 1;
			else if(s1.length()==s2.length())
				return 0;
			else
				return -1;
		});
		ds.forEach(s->System.out.println(s));
	}
}