package chuDeInnerClass;

import chuDeInnerClass.LopNgoai.LopTrong;

class LopNgoai2{
	private int a = 2;
	public void xuatNgoai() {
		int c = 4;
		class LopTrong2{
			private int b = 3;
			public void xuatTrong() {
				System.out.println(String.format("a = %d, b = %d, c = %d", a,b,c));
			}
		}
		LopTrong2 lt = new LopTrong2();		//tao doi tuong lop trong ben trong lop ngoai
		lt.xuatTrong();
	}
}
public class LongCapHam {

	public static void main(String[] args) {
		LopNgoai2 ln2 = new LopNgoai2();
		ln2.xuatNgoai();
	}

}
