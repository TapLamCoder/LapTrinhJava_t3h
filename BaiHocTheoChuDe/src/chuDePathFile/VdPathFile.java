package chuDePathFile;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class VdPathFile {

	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
		System.out.println("File name: "+p1.getFileName());
		System.out.println("Directory: "+p1.getParent());
		System.out.println("Root directory: "+p1.getRoot());
		
		Path p2 = Paths.get("d:/chim_canh_cut.jpg");
		if(Files.exists(p2))
			System.out.println("Tập tin "+p2.getFileName()+" đã có");	
		else	
			Files.copy(p1,p2);

		Path p3 = Paths.get("d:/chim_canh_cut_2.jpg");
		//ghi de
		Files.copy(p1, p3, StandardCopyOption.REPLACE_EXISTING);
	}

}
