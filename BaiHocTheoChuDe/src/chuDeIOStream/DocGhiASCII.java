package chuDeIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DocGhiASCII 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		int[] a = {12,20,5,14,11};
	
		System.out.println("Ghi ra tap tin...");
		PrintWriter pw = new PrintWriter(new FileOutputStream("mang.txt"));
		for(int so:a)
			pw.printf("%5d", so);
		pw.close();
		System.out.println("Da ghi xong tap tin.");
		
		System.out.println("Doc tap tin...");
		Scanner scan = new Scanner(new FileInputStream("mang.txt"));
		while(scan.hasNextInt()) 
		{
			System.out.print(scan.nextInt()+" ");
		}
		scan.close();	
	}
}
