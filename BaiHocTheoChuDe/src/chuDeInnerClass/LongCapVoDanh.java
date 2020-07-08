package chuDeInnerClass;

interface PhepTinh{
	double tinh(int a, int b);		//ham ngam dinh la : public abstract
}

class Cong implements PhepTinh{
	@Override
	public double tinh(int a, int b) {
		return a+b;
	}
}

public class LongCapVoDanh {

	public static void main(String[] args) {
		int a = 1, b = 2;
		double tong, hieu;
		
		Cong cong = new Cong();
		tong = cong.tinh(a, b);
		System.out.println("tong = "+tong);
		
		PhepTinh tru = new PhepTinh() {
			@Override
			public double tinh(int a, int b) {
				return a-b;
			}
		};
		
		hieu = tru.tinh(a, b);
		System.out.println("hieu = "+hieu);
	}

}

