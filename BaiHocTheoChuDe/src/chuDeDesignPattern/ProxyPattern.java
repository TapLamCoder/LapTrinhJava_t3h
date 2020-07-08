package chuDeDesignPattern;

interface HinhAnh{
	void xuat();
}

class HinhThuc implements HinhAnh{
	private String ten;
	public HinhThuc(String ten) {
		this.ten = ten;
		taiHinh();
	}
	@Override
	public void xuat() {
		System.out.println("Xuat hinh anh "+ten+" ra man hinh");
	}
	private void taiHinh() {
		System.out.println("Tai hinh anh "+ten+" len bo nho");
	}
}

class HinhUyQuyen implements HinhAnh{
	private HinhThuc hinhThuc;
	private String ten;
	public HinhUyQuyen(String ten) {
		this.ten = ten;
	}
	@Override
	public void xuat() {
		if(hinhThuc == null)
			hinhThuc = new HinhThuc(ten);
		hinhThuc.xuat();
	}
	
}
public class ProxyPattern {

	public static void main(String[] args) {
		//HinhAnh h = new HinhThuc("abc.jpg");
		HinhAnh h = new HinhUyQuyen("abc.jpg");
		h.xuat();
		h.xuat();

	}

}
