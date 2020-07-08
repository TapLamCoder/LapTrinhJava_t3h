package baiTapTheoSoBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BT12_1 {
	public static void main(String[] args) 
	{
		List<String> strlst = new ArrayList<>();
		strlst.add("happy");
		strlst.add("");
		strlst.add("new");
		strlst.add("year");
		strlst.add("");
		strlst.add("Happy");
		strlst.add("Birth");
		strlst.add("");
		strlst.add("Day");
		strlst.add("");
		strlst.add("an id");
		strlst.add("");
		strlst.add("happymai");
		
		List<String> strlst2 = strlst.stream().filter(x->!x.isEmpty()).collect(Collectors.toList());
		strlst2.forEach(x->System.out.print(x + " "));
		
		//List<String> strlst4 = strlst.stream().collect(Collectors.toList()).addAll(str);
		
		System.out.println("\n" + "co " + strlst.stream().filter(x->x.isEmpty()).count() + " phan tu rong");
		System.out.println("co " + strlst.stream().filter(x->x.length()>=5).count() + " phan tu co so ky tu lon hon hoac bang 5");
		System.out.println("co " + strlst.stream().filter(x->!x.isEmpty()).filter(x->x.charAt(0)=='a').count() + " phan tu bat dau bang a");
		System.out.println("co " + strlst.stream().filter(x->!x.isEmpty()).filter(x->x.contains("happy")||x.contains("Happy")).count() + " phan tu co chua tu happy");

	}
}
