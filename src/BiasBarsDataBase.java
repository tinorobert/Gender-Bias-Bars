/*
 * File: BiasBarsDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of descriptors.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * descriptor and get back the corresponding BiasBarsEntry.
 * Descriptors are matched independent of case, so that "nice"
 * and "NICE" are the same word.
 */

import acm.util.*;
import java.util.*;
import java.io.*;

//import java.util.Scanner;


public class BiasBarsDataBase {

	ArrayList <String> lines = new ArrayList<>();
	HashMap <String,BiasBarsEntry>person = new HashMap<>();
	String line;
	
	/**
	 * Constructor: BiasBarsDataBase(filename)
	 * Creates a new BiasBarsDataBase and initializes it using the
	 * data in the specified file. The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public BiasBarsDataBase(String filename) {

	readLines(filename);
	createMap();
	
	//for(String k : person.keySet())
	//	System.out.println("key2 "+k);

	
	
	}

	
	
	private void readLines(String filename) {
		
		try {
			Scanner in = new Scanner(new File(filename));

			while(in.hasNext()) 
				lines.add(in.nextLine());
				
			in.close();
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Not Found, baby!");
			}
		
		
		//for(String w : lines)
		//	System.out.println(w);
		
	}

	private void createMap() {

		BiasBarsEntry entry;
		String temp;
		
		
		
		for(String w : lines) {
			
		//System.out.println(w+" 100");
	
		entry = new BiasBarsEntry(w);	
		temp = entry.getDescriptor();
		//System.out.println("temp "+temp);

		person.put(temp, entry);
	
		}
		
		/*for(String k : person.keySet()) {
			System.out.println("key: "+k);
			System.out.println("val: "+person.get(k));

		}*/


	}
	
	/**
	 * Returns the BiasBarsEntry associated with this descriptor,
	 * if one exists. If the descriptor does not appear in the database, this
	 * method returns null.
	 */	
	
	
	
	public BiasBarsEntry findEntry(String descriptor) {

		BiasBarsEntry content;
		
		if(person.containsKey(descriptor));
			 content = person.get(descriptor);
		
		/*System.out.println(descriptor);

		for(int i=0; i<2; i++) {
			for(int j=0; j<5; j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
		}*/
		
		


			 
		return content;
	}
}

