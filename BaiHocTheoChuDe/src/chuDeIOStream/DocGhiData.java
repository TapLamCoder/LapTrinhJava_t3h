package chuDeIOStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocGhiData {

	public static void main(String[] args) throws IOException 
	{
		int[] a = {12,20,5,14,11};
		
		System.out.println("Ghi ra tap tin...");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("mang.dat"));
		for(int so:a)
			dos.writeInt(so);
		dos.close();
		System.out.println("Ghi xong tap tin.");
		
		System.out.println("Doc tap tin.");
		DataInputStream dis = new DataInputStream(new FileInputStream("mang.dat"));
		while(true)
		{
			try 
			{
				int so = dis.readInt();
				System.out.print(so+" ");
			} 
			catch (Exception e) 
			{
				break;
			}
		}
		dis.close();
		
	}

}
