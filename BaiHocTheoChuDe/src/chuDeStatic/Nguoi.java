package chuDeStatic;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Nguoi {
	//du lieu
	private String hoTen;
	private Date ngaySinh;
	private boolean gioiTinh;	//true: nam, false: nu
	//bien static
	private static int soNguoi;
	//khoi lenh static
	static {
		soNguoi = 0;
	}
	//thuoc tinh
	//phuong thuc static
	public static int getSoNguoi() {
		return soNguoi;
	}
	public static void setSoNguoi(int soNguoi) {
		Nguoi.soNguoi = soNguoi;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	//khoi tao
	public Nguoi() {
		super();		//goi khoi tao cua lop Object() ngam dinh
		soNguoi++;
	}
	public Nguoi(String ht, Date ns, boolean gt) {
		super();
		hoTen=ht;
		ngaySinh=ns;
		gioiTinh=gt;
		soNguoi++;
	}
	//xu ly
	public String xuat() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%s %s %s",hoTen,ngaySinh!=null?df.format(ngaySinh):null, gioiTinh);
	}
	@Override
	public String toString() {
		return xuat();
	}
}