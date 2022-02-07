package ReanAndWriteFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteFileExp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File inputfile = new File("C:\\Users\\90542\\Downloads\\test.txt");
		File outputFile = new File("C:\\Users\\90542\\Downloads\\outputFile.txt");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(inputfile));
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("C:\\Users\\90542\\Downloads\\outputFile.txt"), "utf-8"));
		
		String satir = reader.readLine();
		String[] parts = new String[100000];
		
		while (satir!=null) {
			System.out.println(satir);
			parts = satir.split(" ");
			

			if(parts.length>1) {
				boolean flag = false;
				for(int i = 0; i < parts.length; i++) {
					if(Integer.parseInt(parts[i]) == 0) {
						 writer.append("yes \n");
						 flag = true;
					} else {
						int k = Integer.parseInt(parts[i]);
						for(int j = i+1; j < parts.length; j++) {
							k = k + Integer.parseInt(parts[j]);
							int bb = Integer.parseInt(parts[j]);
							if(k == 0) {
								writer.append("yes \n");
								flag = true;
								break;
							}
						}
						
						if(flag == true) {
							break;
						}
						
					}
					
				}
				
				if(flag == false) {
					 writer.append("no \n");
				}
			
			}
			
			
			satir = reader.readLine();
		}
		writer.close();

	}

}
