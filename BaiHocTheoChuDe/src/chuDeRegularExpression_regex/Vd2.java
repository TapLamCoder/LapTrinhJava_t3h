package chuDeRegularExpression_regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vd2 {

	public static void main(String[] args) {
		if(Pattern.matches("\\d.", "5g"))
			System.out.println("Hop mau");
		else
			System.out.println("Khong hop mau");
		
		String s = "mai;lan,cuc:truc";
		String[] m = s.split(";|,|:");
		for(String sub:m)
			System.out.println(sub);
		
		String regEx = "meo";
		String input = "meo me meo con cung keu meo meo";
		
		Pattern pt = Pattern.compile(regEx);
		Matcher mc = pt.matcher(input);
		
		String s2 = mc.replaceAll("cho");
		System.out.println(s2);
	}

}

