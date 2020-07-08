package chuDeAbstractVaInterface;

public abstract class HinhHoc implements Comparable<HinhHoc> {			//lop truu tuong
	public abstract double chuVi();		//phuong thuc truu tuong
	public abstract double dienTich();
	public String tenHinh() {			//phuong thuc cu the
		return "Hinh hoc";
	}
	@Override
	public int compareTo(HinhHoc o) {
		if(chuVi()<o.chuVi())
			return -1;
		else if(chuVi()==o.chuVi())
			return 0;
		else
			return 1;
	}
	
}

