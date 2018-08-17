/*
 * File: BiasBarsEntry.java
 * --------------------------
 * This class represents a single entry in the database. Each
 * BiasBarsEntry contains a descriptor and two mappings from
 * comment source to number of occurrences of the descriptor, one
 * for women and one for men
 */

import acm.util.*;
import java.util.*;

public class BiasBarsEntry {

	private String descriptor;
	private Integer[][] freqs;
	/**
	 * Creates a new BiasBarsEntry from a data line as it appears
	 * in the data file. Each line begins with the descriptor, which is
	 * followed by integers giving the occurrence of that descriptor in
	 * the RtGender database of social media comments. Before each list
	 * of integers is a letter "W" or "M" denoting which gender those
	 * frequencies correspond to
	 */
	public BiasBarsEntry(String line) {

		//System.out.println("line in BiasBarsEntry():"+line);
		

		StringTokenizer t = new StringTokenizer(line);
		String temp;
		String [][] m = new String [2][5];
		//Integer [][] freqs = new Integer [2][5];
		freqs = new Integer [2][5];

		//System.out.println("here-here");


		descriptor = t.nextToken();
		//System.out.println(temp);


		for(int i=0; i<2; i++) {
			//Skip the M,W
			t.nextToken();

			for(int j=0; j<5; j++) {

				m[i][j] = t.nextToken();

				freqs[i][j] = stringToNumber(m[i][j]);


			}
			
			
		}
		
		
	}

	
private Integer stringToNumber(String w) {
		
		int len = w.length();
		Integer num= 0;
		int count = 1;
		
		for(int i=len-1;i>=0; i--) {
			//number = n.charAt(0)-48;
			num += (w.charAt(i)-48)*count;
			//System.out.println(num);
			count*=10;

		}
		
		return num;
	}


	/**
	 * Returns the descriptor associated with this entry.
	 */
	public String getDescriptor() {

		return descriptor;
	}

	/**
	 * Returns the frequencies associated with an entry for a particular
	 * comment source and gender.
	 */
	public ArrayList<Integer> getFrequencies(char gender) {
		
		ArrayList<Integer> f = new ArrayList <>();
		
		int i=0;
		if (gender=='w') i=0;
		if (gender=='m') i=1;	
			
			for(int j=0; j<5; j++)
				f.add(freqs[i][j]); 
		
		return f;
	}

	/**
	 * Returns the highest frequency associated with a descriptor for any
	 * combination of comment source and gender to help with deciding the
	 * y-axis scale during graphing.
	 */
	public int getMaxFreq() {
		
		
		System.out.println("a");
		int max=0;
		
		for(int i=0; i<2; i++)
			for(int j=0; j<5; j++)
			{
				if(freqs[i][j]>max)
					max = freqs[i][j];
			}
		// TODO turn this stub into a real implementation
		return max;
	}

	/**
	 * Returns a string that makes it easy to see the value of a BiasBarsEntry.
	 */
	public String toString() {
		
		String out = "";
		//System.out.println("a");

		//System.out.println(descriptor);
		//System.out.println(freqs);

			out = descriptor + "\nW: ";
			//System.out.print("W: ");
			
			/*for(int j=0; j<5; j++)
				System.out.print(freqs[0][j] + " ");
			System.out.println();
			System.out.print("M: ");
			for(int j=0; j<5; j++)
				System.out.print(freqs[1][j] + " ");
			System.out.println();*/
		
			
			for(int j=0; j<5; j++)
				out = out + freqs[0][j] + " ";
			out += "\nM: ";
			for(int j=0; j<5; j++)
				out = out + freqs[1][j] + " ";
			//out += "\nM: ";

		return out;
	}
}

