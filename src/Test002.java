import acm.program.*;
import acm.util.*;
import stanford.cs106.diff.DiffImage;
import stanford.cs106.gui.GuiUtils;

import java.awt.Image;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;


/*
 * OPENS A FILE, COPY AND WRITE ANOTHER FILE
 */

public class Test002 extends ConsoleProgram {

	
	public void run() {
		
		String word; 
		Scanner input = new Scanner("");
		
		try {
			   
			input = new Scanner(new File("/Users/vladimir/Desktop/CS106A-Summer18/Assignments/CS106A-Assignment6/res/gender-data-s.txt"));
			
			try {
				
				PrintWriter wr = new PrintWriter(new FileWriter("copy05.txt"));

				 while(input.hasNext()) {
					 word = input.nextLine();
					 //println(word);
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
		
		///END OF OPEN/CLOSE FILE
		
		println("here-here");
		
		HashMap <String, Integer[][]>map = new HashMap <>();
		
		String x="A", y="B";
		Integer [][]a = {{1,2,3,4,5},{11,22,33,44,55}};
		Integer [][]b = {{10,20,30,40,50},{110,220,330,440,550}};
		
		map.put(x, a);
		map.put(y, b);
		
		for(String w : map.keySet()) {
			Integer [][] m = map.get(w);
			for(int i=0; i<m.length; i++) {
				for(int j=0; j<m[0].length; j++)
					print(m[i][j]+ " ");
				println();
			}
			println();
		}
		println(map);

		
		
	}
	
}
