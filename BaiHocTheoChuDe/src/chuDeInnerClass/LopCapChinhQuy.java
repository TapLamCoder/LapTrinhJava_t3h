package chuDeInnerClass;

class LopNgoai{
	private int a = 2;
	class LopTrong{
		private int b = 3;
		public void xuatTrong() {
			System.out.println(String.format("a = %d, b = %d", a,b));
		}
	}
	public void xuatNgoai() {
		LopTrong lt = new LopTrong();		//tao doi tuong lop trong ben trong lop ngoai
		lt.xuatTrong();						//thi moi dung duoc method cua LopTrong
	}
}
public class LopCapChinhQuy {
	public static void main(String[] args) {
		LopNgoai ln = new LopNgoai();
		ln.xuatNgoai();
		
		LopNgoai.LopTrong lt = ln.new LopTrong(); //tao doi tuong LopTrong ngay ben trong LopCapChinhQuy khong thong qua LopNgoai
		lt.xuatTrong();
	}
}

