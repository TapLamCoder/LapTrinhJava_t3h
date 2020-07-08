package chuDeDesignPattern;

class Singleton{
	private static Singleton singleton;
	private Singleton() {}
	public static Singleton getSingleton() {
		if(singleton == null)
			singleton = new Singleton();
		return singleton;
	}
}
public class SingletonPattern {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		if(sb1.equals(sb2))
			System.out.println("sb1 === sb2");
		else
			System.out.println("sb1 != sb2");

		Singleton st1 = Singleton.getSingleton();
		Singleton st2 = Singleton.getSingleton();
		if(st1.equals(st2))
			System.out.println("st1 === st2");
		else
			System.out.println("st1 != st2");
	}

}
