import acm.program.*;
import acm.util.*;
import stanford.cs106.diff.DiffImage;
import stanford.cs106.gui.GuiUtils;

import java.awt.Image;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Copier extends ConsoleProgram {

	private static final String[] LOAD_IMAGE_EXTENSIONS = new String[] { "png", "bmp", "wbmp","jpg", "gif", "jpeg", "txt" };

	
	public void run() {
		
		String word; 
		Scanner input = new Scanner("");
		
		try {
			   
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(GuiUtils.getExtensionFileFilter("Image files", LOAD_IMAGE_EXTENSIONS));
			File dir = new File(System.getProperty("user.dir"));
			//chooser.setCurrentDirectory(getImageDirectory());
			chooser.setCurrentDirectory(dir);
			//if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			//	{
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File imageFile2 = chooser.getSelectedFile();

				try {
					Image image2 = ImageIO.read(imageFile2);
					//Image image1 = currentImage.getImage();
					//new DiffImage(image1, image2);
				} catch (IOException ioe) {
//					showErrorPopup("could not read diff image data from " + imageFile2.getName() + ": " + ioe.getMessage());
					ioe.getMessage();

				}
				
				
				}

			
			input = new Scanner(new File("small.txt"));
			
			try {
				
				PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));

				 while(input.hasNext()) {
					 word = input.nextLine();
					 println(word);
					 wr.println(word);  // file
					 wr.write(word);
					 
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
