package chuDeAbstractVaInterface;

public class KiemThu {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HinhHoc[] hh = new HinhHoc[5];
		hh[0] = new HinhTron(5);
		System.out.println("dien tich hinh tron la: " + hh[0].dienTich() + "chu vi hinh tron la: " + hh[0].chuVi());
	}

}
