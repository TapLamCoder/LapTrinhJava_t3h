package chuDeRegularExpression_regex;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Vd3 {

	public static void main(String[] args) {
		double so = 12345.67;
		System.out.println("So (Java): "+so);
		
		Locale lcVN = new Locale("vi", "VN");
		Locale lcUS = new Locale("en", "US");
		
		NumberFormat nfVN = NumberFormat.getNumberInstance(lcVN);
		NumberFormat nfUS = NumberFormat.getNumberInstance(lcUS);
		
		System.out.println("So (VN): "+nfVN.format(so));
		System.out.println("So (US): "+nfUS.format(so));
		
		Date homNay = new Date();
		
		System.out.println("Hom nay (Java): "+homNay);
		DateFormat dfVN = DateFormat.getDateInstance(DateFormat.SHORT, lcVN);
		DateFormat dfUS = DateFormat.getDateInstance(DateFormat.SHORT, lcUS);
		
		System.out.println("Hom nay (VN): "+dfVN.format(homNay));
		System.out.println("Hom nay (US): "+dfUS.format(homNay));
		
		NumberFormat nfTienVN = NumberFormat.getCurrencyInstance(lcVN);
		NumberFormat nfTienUS = NumberFormat.getCurrencyInstance(lcUS);

		System.out.println("So tien (VN): "+nfTienVN.format(so));
		System.out.println("So tien (US): "+nfTienUS.format(so));
	}

}
