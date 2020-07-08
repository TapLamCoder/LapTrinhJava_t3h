package chuDeStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vd4 {

	public static void main(String[] args) {
		List<String> ds = new ArrayList<>();
		ds.add("void");
		ds.add("");
		ds.add("implement");
		ds.add("abstract");
		ds.add("");
		ds.add("extend");
		ds.add("");
		ds.add("class");
		ds.add("");
		ds.add("override");
		ds.add("super");
		
		ds.forEach(s->{
			if(!s.isEmpty())
				System.out.print(s+", ");
			else
				System.out.print("\" \""+", ");
		});
		int soChuoiTrong = (int) ds.stream().filter(s->s.isEmpty()).count();
		System.out.println("\nSo chuoi trong la: "+soChuoiTrong);
		
		List<String> ds1 = ds.stream().filter(s->!s.isEmpty()).collect(Collectors.toList());
		System.out.println("\nDanh sach ds1");
		ds1.forEach(s->System.out.print(s+" "));
	}

}
