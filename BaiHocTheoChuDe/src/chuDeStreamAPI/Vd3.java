package chuDeStreamAPI;

import java.util.Arrays;
import java.util.List;

public class Vd3 {

	public static void main(String[] args) {
		int[] a = {1,2,5,3,4,2,4,3,1};
		System.out.println("Cac gia tri cua mang");
		Arrays.stream(a).forEach(x->System.out.print(x+ " "));
		System.out.println("\nLay cac gia tri duy nhat va binh phuong chinh no");
		Arrays.stream(a).distinct().map(x->x*x).forEach(x->System.out.print(x+ " "));
		
		List<Integer> ds1 = Arrays.asList(1,2,5,3,4,2,4,3,1);
		int tong = ds1.stream().mapToInt(x->x).sum();
		System.out.println("\ntong = "+tong);
		
		List<String> ds2 = Arrays.asList("mai","lan");
		List<String> ds3 = Arrays.asList("sanh","si","tung","loc");
		ds2.stream().flatMap(s->ds3.stream().map(s3->s+" -> "+s3)).forEach(s->System.out.println(s+" "));
	
		int[] b = {1,5,3,2,4};
		Arrays.stream(b).peek(x->System.out.println("Dang xet "+x))
				.filter(x->x%2!=0)
				.peek(x->System.out.println("So le "+x))
				.forEach(x->System.out.println(x));
		System.out.println("\nCac so nguyen to trong mang");
		Arrays.stream(b).filter(x->{
			boolean snt = true;
			if(x<2)
				snt = false;
			else
				for(int i=2; i<=Math.sqrt(x) && snt; i++)
					if(x%i==0)
						snt = false;
			return snt;
		}).forEach(x->System.out.print(x+" "));
	}

}

