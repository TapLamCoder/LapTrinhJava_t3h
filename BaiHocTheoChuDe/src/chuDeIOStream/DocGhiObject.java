package chuDeIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class DocGhiObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		double[] a = {1.2,3.8,4.1,5.9,6.3,3.7};
		System.out.println("Dang ghi tap tin...");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mang.obj"));
		oos.writeObject(a);
		oos.close();
		System.out.println("Da ghi xong tap tin.");
		
		System.out.println("Doc tap tin...");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mang.obj"));
		double[] b = (double[]) ois.readObject();
		System.out.println(Arrays.toString(b));
		ois.close();
	}

}
