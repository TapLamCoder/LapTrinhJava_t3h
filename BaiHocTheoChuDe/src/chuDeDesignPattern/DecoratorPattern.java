package chuDeDesignPattern;

interface Hinh{ // 1
	void xuat();
}

class HinhTron implements Hinh{ //1 .1
	@Override
	public void xuat() {
		System.out.println("Hinh tron");
	}
}

class HinhTronDVD extends HinhTron{ //1.1 .1
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Duong vien do");
	}
}

abstract class Decorator implements Hinh{ //1 .2
	protected Hinh hinh;
	protected Decorator(Hinh hinh) {
		this.hinh = hinh;
	}
	@Override
	public void xuat() {
		hinh.xuat();
	}
}

class DuongVienDo extends Decorator{ //1.2 .1
	public DuongVienDo(Hinh hinh) {
		super(hinh);
	}
	private void boSung() {
		System.out.println("Duong vien do");
	}
	@Override
	public void xuat() {
		super.xuat();
		boSung();
	}
}
public class DecoratorPattern {

	public static void main(String[] args) {
		Hinh h = new DuongVienDo(new HinhTron());
		h.xuat();
	}

}
