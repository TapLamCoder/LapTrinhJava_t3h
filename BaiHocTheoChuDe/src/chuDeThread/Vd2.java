package chuDeThread;

//buoc 1: xay dung lop ke thua Thread
class TieuTrinh1 extends Thread{
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class TieuTrinh2 extends Thread{
	@Override
	public void run() {
		for(int i=51; i<=100; i++) {
			System.out.print(i+" ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class TieuTrinh3Runnable implements Runnable{
	@Override
	public void run() {
		for (int i = 101; i <= 150; i++) {
			System.out.print(i + " ");
		}
	}
	
}
public class Vd2 {

	public static void main(String[] args) {
		// buoc 2: tao doi tuong tu lop tieu trinh
		Thread tt1 = new TieuTrinh1();
		Thread tt2 = new TieuTrinh2();
		Thread tt3 = new Thread(new TieuTrinh3Runnable());
		//buoc 3: goi ham start()
		tt1.start();
		tt2.start();
		tt3.start();
	}

}
