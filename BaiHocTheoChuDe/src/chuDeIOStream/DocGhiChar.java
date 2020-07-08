package chuDeIOStream;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocGhiChar {

	public static void main(String[] args) throws IOException {
		String s = "Trung tâm tin học Đại học Khoa học tự nhiên";
		
		System.out.println("Ghi ra tap tin...");
		
		FileWriter fw = new FileWriter("t3h.txt");
		fw.write(s);
		fw.close();
		System.out.println("Ghi xong tap tin.");
		
		System.out.println("Doc tap tin.");
		
		FileReader fr = new FileReader("t3h.txt");
		int c;
		while((c=fr.read())!=-1)
			System.out.print((char)c);
		fr.close();
		
	}

}
