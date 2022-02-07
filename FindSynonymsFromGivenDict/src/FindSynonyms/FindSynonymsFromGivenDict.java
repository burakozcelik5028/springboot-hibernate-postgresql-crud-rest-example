package FindSynonyms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindSynonymsFromGivenDict {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File outputFile = new File("C:\\Users\\90542\\Downloads\\outputFile.txt");
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("C:\\Users\\90542\\Downloads\\outputFile.txt"), "utf-8"));
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\90542\\Downloads\\example_big.in");
		FileInputStream fis = new FileInputStream("C:\\Users\\90542\\Downloads\\test.txt");          
		Scanner sc = new Scanner(fis);   
		
		String[] parts = new String[100000];
		String[] part2 = new String[100000];
		int i = 0;
		int k = 0;
		HashMap<String, String> dictionary = new HashMap<String, String>();
		int w = 0;
		int j = 0;
		while (sc.hasNextLine()) {
			part2[j] = sc.nextLine().toUpperCase();
			j++;
		}
		
		while (part2[k] != null) {
			
			if(i==0) {
				i++;
			} else {
				parts = part2[k].split(" ");
				
				if(parts.length == 1) {
					i++;
					if(i % 2 == 0) {
						dictionary.clear();
					}
				} else {
				
					if(i % 2 == 0 && parts.length >  1) {
						if(dictionary.containsKey(parts[0])) {
							dictionary.put(""+w, parts[0] + " " + parts[1]);
							w++;
							dictionary.put(""+w, parts[1] + " " + parts[0]);
							w++;
						} else {
							dictionary.put(parts[0], parts[1]);
						}
						
						
						
					} else {
						if(!dictionary.isEmpty()) {
							
							if( !(dictionary.containsKey(parts[0]) || dictionary.containsKey(parts[1])) && !(parts[1].toUpperCase().equals(parts[0].toUpperCase())) ) {
								writer.append("different\n");
							} else {
								
								if ( dictionary.containsKey(parts[0]) 
										&& (dictionary.get(parts[0]).equals(parts[1]))) {
									writer.append("synonyms\n");
								} 
								
								else if ( dictionary.containsKey(parts[1].toUpperCase()) 
										&& (dictionary.get(parts[1].toUpperCase()) == parts[0].toUpperCase())){
									writer.append("synonyms\n");
								} 
								
								else if ((parts[1].toUpperCase().equals(parts[0].toUpperCase()))){
									writer.append("synonyms\n");
								}  
								
								else if ( dictionary.containsKey(parts[1]) 
										&& dictionary.containsKey(dictionary.get(parts[1])) 
										&& dictionary.get(dictionary.get(parts[1])).equals(parts[0])  ){
									writer.append("synonyms\n");
								} 
								
								else if ( dictionary.containsKey(parts[0]) 
										&& dictionary.containsKey(dictionary.get(parts[0])) 
										&& dictionary.get(dictionary.get(parts[0])).equals(parts[1])  ){
									writer.append("synonyms\n");
								} 
								
								else {
									boolean et = false;
									for(int u = 0 ; u <= w; u++) {
										et=false;
										System.out.println(dictionary.containsKey(""+u));
										System.out.println(dictionary.get(""+u));
										if( dictionary.containsKey(""+u) && 
												(dictionary.get(""+u).equals(parts[0] + " " + parts[1]) || dictionary.get(""+u).equals(parts[1] + " " + parts[0])) ) {
											writer.append("synonyms\n");
											et=true;
											break;
										} else if( dictionary.containsKey(""+u)) {
											String[] holder = new String[2];
											holder = dictionary.get(""+u).split(" ");
											System.out.println(holder);
											
											
											if ( dictionary.containsKey(holder[0]) 
													&& (dictionary.get(holder[0]).equals(holder[1])) 
													&& (dictionary.get(holder[0]).equals(parts[0]))  ) {
												writer.append("synonyms\n");
												et=true;
												break;
											} 
											
											else if ( dictionary.containsKey(holder[1]) 
													&& (dictionary.get(holder[1]).equals(holder[0])) 
													&& (dictionary.get(holder[1]).equals(parts[1]))  ){
												writer.append("synonyms\n");
												et=true;
												break;
											} 
											
											else if ((holder[1].equals(holder[0]))){
												writer.append("synonyms\n");
												et=true;
												break;
											}  
											
											else if ( dictionary.containsKey(holder[1]) 
													&& dictionary.containsKey(dictionary.get(holder[1])) 
													&& dictionary.get(dictionary.get(holder[1])).equals(holder[0]) 
													&& dictionary.get(dictionary.get(holder[1])).equals(parts[1]) ){
												writer.append("synonyms\n");
												et=true;
												break;
											} 
											
											else if ( dictionary.containsKey(holder[0]) 
													&& dictionary.containsKey(dictionary.get(holder[0])) 
													&& dictionary.get(dictionary.get(holder[0])).equals(holder[1]) ){
												writer.append("synonyms\n");
												et=true;
												break;
											} 
											
											
										}
									}
									if(et == false) {
										writer.append("different\n");
									}
									
								}
							}
							
							
						}
					}
				}
				
				
			}
			k++;
			
		}
		writer.close();
		sc.close();
	}

}
