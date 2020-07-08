package chuDeIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class DocGhiByte {

	public static void main(String[] args) 
	{
		try 
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Public\\Pictures\\OutputDesert.jpg");
			int b;
			while ((b=fis.read()) != -1) 
			{
				fos.write(b);
			}
			fis.close();
			fos.close();
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Khong doc duoc file");
			e.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
	}

}
