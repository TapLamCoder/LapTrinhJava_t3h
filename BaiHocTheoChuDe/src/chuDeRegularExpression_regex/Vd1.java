package chuDeRegularExpression_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
//import 

public class Vd1 {

	public static void main(String[] args) {
//1st example
		String input = "A5";
		String regEx = "[a-z]||[A-Z][0-9]";

		try {
			Pattern pt = Pattern.compile(regEx);
			Matcher mc = pt.matcher(input);

			if (mc.matches())
				System.out.println("Hop mau");
			else
				System.out.println("Khong hop mau");
		} catch (PatternSyntaxException e) {
			System.out.println("Bieu thuc chinh qui sai qui tac");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Bi loi: "+e.getMessage());
		}
//2nd example
		String input2 = "abcbcbcZ3nnnnnnoommmCCDDDx 2";
		String regEx2 = "a(bc){3,}.[123][mno]*[CD]+[xy]?\\s\\d"; //group1:(bc){3,} gr2:. gr3[123] gr4[mno]* gr5[CD]+ gr6[xy]? gr7\\s gr8\\d
		try {
			Pattern pt2 = Pattern.compile(regEx2);
			Matcher mc2 = pt2.matcher(input2);

			if (mc2.matches())
				System.out.println("Hop mau");
			else
				System.out.println("Khong hop mau");
			
		} catch (PatternSyntaxException e) {
			System.out.println("Bieu thuc chinh qui sai qui tac");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Bi boi: "+e.getMessage());
		}
//3rd example
		String input3 = "canhcut.jpg";
		String regEx3 = "[^\\s]+\\.(?i)(jpg|png|gif|bmp)";
		
		try {
			Pattern pt3 = Pattern.compile(regEx3);
			Matcher mc3 = pt3.matcher(input3);

		if (mc3.matches())
			System.out.println("Ten hinh anh hop le");
		else
			System.out.println("Ten hinh anh khong hop le");
		
		} catch (PatternSyntaxException e) {
			System.out.println("Bieu thuc chinh qui sai qui tac");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Bi boi: "+e.getMessage());
		}
	}	
}

