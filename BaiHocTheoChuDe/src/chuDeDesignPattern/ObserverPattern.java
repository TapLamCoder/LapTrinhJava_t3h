package chuDeDesignPattern;

import java.util.ArrayList;
import java.util.List;

class Account{
	private List<Observer> dsgs = new ArrayList<>();
	
	private int sd;
	
	public int getSd() {
		return sd;
	}
	public void setSd(int sd) {
		this.sd = sd;
		notifyObserver();
	}
	private void notifyObserver() {
		for(Observer gs:dsgs)
			gs.notify("So tien thay doi "+sd);
	}
	public void addObserver(Observer gs) {
		dsgs.add(gs);
	}
}

abstract class Observer{
	protected Account tk;
	protected int a;
	public abstract void notify(String tb);
}

class EmailObserver extends Observer{
	public EmailObserver(Account tk) {
		this.tk = tk;
		tk.addObserver(this);
	}
	@Override
	public void notify(String tb) {
		System.out.println("Email thong bao : "+tb);
	}
}

class SMSObserver extends Observer{
	public SMSObserver(Account tk) {
		this.tk = tk;
		tk.addObserver(this);
	}
	@Override
	public void notify(String tb) {
		System.out.println("SMS thong bao : "+tb);
	}
}
public class ObserverPattern {

	public static void main(String[] args) {
		Account tk1 = new Account();
		EmailObserver gs1 = new EmailObserver(tk1);
		SMSObserver gs2 = new SMSObserver(tk1);
		tk1.setSd(100000);
		tk1.setSd(150000);
	}

}

