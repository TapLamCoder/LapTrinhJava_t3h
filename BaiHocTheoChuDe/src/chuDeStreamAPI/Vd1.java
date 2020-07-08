package chuDeStreamAPI;

import java.util.Arrays;
import java.util.stream.Stream;

public class Vd1 {

	public static void main(String[] args) {
		int[] a = {1,5,2,4,3};

		int tong = 0;
		for(int so:a)
			tong+=so;
		System.out.println("tong = "+tong);
		
		tong = Arrays.stream(a).sum();
		System.out.println("tong = "+tong);
			
		tong=0;
		for(int i=2; i<a.length; i++)
			tong+=a[i];
		System.out.println("tong = "+tong);

		tong = Arrays.stream(a).skip(2).sum();
		System.out.println("tong = "+tong);
		
		Stream<String> l1 = Stream.generate(()->"abc").limit(6);
		l1.forEach(s->System.out.println(s));
		
		int[] b = Arrays.stream(a).sorted().toArray();
		Arrays.stream(b).forEach(x -> System.out.print(x + " "));
		
	}

}
