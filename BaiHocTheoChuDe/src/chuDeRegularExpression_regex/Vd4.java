package chuDeRegularExpression_regex;

import java.util.Locale;
import java.util.ResourceBundle;

public class Vd4 {
	Locale lcVN = new Locale("vi", "VN");
	Locale lcUS = new Locale("en", "US");

	public static void main(String[] args) {
		Locale lcVN = new Locale("vi", "VN");
		Locale lcUS = new Locale("en", "US");
		
		ResourceBundle rb;
		
		rb = ResourceBundle.getBundle("chuDeRegularExpression_regex/tudien", lcVN);
		System.out.println(rb.getString("sChicken"));

		rb = ResourceBundle.getBundle("chuDeRegularExpression_regex/tudien", lcUS);
		System.out.println(rb.getString("sChicken"));
		
	}
	
}
