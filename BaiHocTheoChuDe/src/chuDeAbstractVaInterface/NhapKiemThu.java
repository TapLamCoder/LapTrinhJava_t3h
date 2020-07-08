package chuDeAbstractVaInterface;

import java.util.Arrays;

public class NhapKiemThu {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HinhHoc[] mh = new HinhHoc[4];
		mh[0] = new HinhTron(6);
		mh[1] = new HinhChuNhat(8,5);
		mh[2] = new HinhVuong(5);
		mh[3] = new HinhTamGiac(3,4,5);
		
		
		double tongDienTich=0;
		for(HinhHoc h:mh) {
			System.out.println(h.tenHinh()+ " co Chu vi: "+h.chuVi()+", Dien tich: "+h.dienTich());
			tongDienTich+=h.dienTich();
		}
		System.out.println("Tong dien tich: "+tongDienTich);

		//sap xep chu vi tang dan
		System.out.println("\nSap xep chu vi tang dan");
//		for(int i=0; i<mh.length-1; i++)
//			for(int j=i+1; j<mh.length; j++) {
//				if(mh[i].chuVi()>mh[j].chuVi()) {
//					HinhHoc tam = mh[i];
//					mh[i] = mh[j];
//					mh[j] = tam;
//				}
//			}
		
		Arrays.sort(mh);
		
		for(HinhHoc h:mh) 
		{
			System.out.println(h.tenHinh()+ " co Chu vi: "+h.chuVi()+", Dien tich: "+h.dienTich());
		}
		System.out.println("Tong dien tich: "+tongDienTich);
	
	@Override
		public double chuVi() 
		{
			return (double)a+b+c;
		}

	@Override
		public double dienTich() 
		{
			double p = chuVi()/2;
			return Math.sqrt(p*(p-a)*(p-b)*(p-c));
		}
	
		HinhHoc[] mh = new HinhHoc[4];
		mh[0] = new HinhTron(6);
		mh[1] = new HinhChuNhat(8,5);
		mh[2] = new HinhVuong(5);
		mh[3] = new HinhTamGiac(3,4,5);
		double tongDienTich=0;
		for(HinhHoc h:mh) 
		{
			System.out.println(h.tenHinh()+ " co Chu vi: "+h.chuVi()+", Dien tich: "+h.dienTich());
		tongDienTich+=h.dienTich();
		}
		System.out.println("Tong dien tich: "+tongDienTich);
	}
}
