import acm.program.*;
import acm.util.*;
import stanford.cs106.diff.DiffImage;
import stanford.cs106.gui.GuiUtils;

import java.awt.Image;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;


/*
 * OPENS A FILE, COPY AND WRITE ANOTHER FILE
 */

public class Test001 extends ConsoleProgram {

	
	public void run() {
		
		String word; 
		Scanner input = new Scanner("");
		
		try {
			   


			
			input = new Scanner(new File("small.txt"));
			
			try {
				
				PrintWriter wr = new PrintWriter(new FileWriter("copy01.txt"));

				 while(input.hasNext()) {
					 word = input.nextLine();
					 println(word);
					 wr.println(word);  // file
					 //wr.write(word); //DOESNT PRINT NEXT LINES
					 
				 }
				 
				 input.close();
				 wr.close();
			
		} catch (IOException e) {
    		throw new ErrorException(e);
   /// 		e.printStackTrace();

    		} 	    	

		}

		catch (FileNotFoundException e){
			println("File Not Found.");
			e.printStackTrace();
		}
		
	}
	
}
