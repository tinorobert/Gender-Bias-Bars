
/* 
 * CopyFile.java
 * -------------
 * This program shows an example of copying a text file
 * line by line.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.Scanner;

public class CopyFile extends ConsoleProgram {
    
    public void run() {
    	//setFont("Times New Roman-24");
    	//BufferedReader rd = openFile("Please enter filename: ");
    	Scanner rd = openFile1("Please enter filename: ");

    	
    	///try {
   /// 		PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));
    		
    		/*while (true) {
    			
    			String line = rd.readLine();
    			if (line == null) break;*/
    			while(rd.hasNextLine()) {
    			String line = rd.nextLine();	
    			
    			println(line);	// console
   /// 			wr.println(line);  // file
  ///  		}
    		
    		rd.close();
  ///  		wr.close();
    		
 ///   	} catch (IOException e) {
    		//throw new ErrorException(e);
   /// 		e.printStackTrace();

    	} 	    	
    }

	/*private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				println("Nice try punk.  That file doesn't exist.");
			}
		}
		return rd;
	}*/
	
	private Scanner openFile1(String prompt) {
	String word; 
	Scanner input = new Scanner("");
	
	try {
	

	input = new Scanner(new File("small.txt"));
		

	//while(input.hasNextLine()) {
	//	word = input.nextLine();
	//	println(word);
	//}
	//input.close();
	}

	catch (FileNotFoundException e){
	println("File Not Found.");
	e.printStackTrace();
	}
	
	return input;
	
	}
    
}
