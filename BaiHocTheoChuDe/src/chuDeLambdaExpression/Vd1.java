package chuDeLambdaExpression;

interface PhepTinh{
	double tinh(int a, int b);
}

//xay lop thuc thi giao tiep
class Cong implements PhepTinh{
	@Override
	public double tinh(int a, int b) {
		return a+b;
	}
}

interface ChaoHoi{
	void chao();
}

public class Vd1 {

	public static void main(String[] args) {
		int a = 5, b =4;
		double tong, hieu, tich, thuong;
		
		Cong cong = new Cong();
		tong = cong.tinh(a, b);
		System.out.println("tong = "+tong);
		
		//lop long cap vo danh
		PhepTinh tru = new PhepTinh() {
			@Override
			public double tinh(int a, int b) {
				return a-b;
			}
		};
		hieu = tru.tinh(a, b);
		System.out.println("hieu = "+hieu);
		
		//bieu thuc Lambda
		PhepTinh nhan = (x,y) -> (double)x*y;
		tich = nhan.tinh(a, b);
		System.out.println("tich = "+tich);
		
		ChaoHoi ch1 = () -> System.out.println("Chào mừng bạn đến với Biểu thức Lambda!");
		ch1.chao();
		
		ChaoHoi ch2 = () ->{
			String s = "Chào các bạn!";
			s = s.toUpperCase();
			System.out.println(s);
		};
		ch2.chao();
	}

}
