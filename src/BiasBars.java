/*
 * File: BiasBars.java
 * ---------------------
 * When it is finished, this program will implement the viewer for
 * the descriptor frequency data described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class BiasBars extends Program {

	/** The name of the file containing the data */
	private static final String DATA_FILE = "res/gender-data.txt";
	
	/** The width of the text field in the NORTH of the window */
	private static final int TEXT_FIELD_WIDTH = 16;
	
	// TODO add instance variable(s)
	JLabel label;
	JTextField field;
	JButton button1, button2;
	BiasBarsGraph canvas = new BiasBarsGraph();
	BiasBarsDataBase db = new BiasBarsDataBase(DATA_FILE);

	
	/**
	 * This method has the responsibility for creating the database
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
		setTitle("BiasBars");

		add(canvas);
		
		label = new JLabel("Descriptor");
		add(label,NORTH);
		field = new JTextField(TEXT_FIELD_WIDTH);
		add(field,NORTH);
		field.addActionListener(this);
		field.setActionCommand("Graph");
		
		field.setText("inevitable");
		button1 = new JButton("Graph");
		add(button1,NORTH);
		button2 = new JButton("Clear");
		add(button2,NORTH);
		addActionListeners();
		

		
	}

	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {


		String text="", lowText="";
		int l,h;
		
		

		if(e.getActionCommand().equals("Graph"))
			{
				text = field.getText();
				println(text);
			
			
			//Convert to LOWERCASE
			l=text.length();
			for(int i=0; i<l; i++)
				lowText = lowText + (Character.toLowerCase(text.charAt(i)));
			
			println(lowText);
			
			BiasBarsEntry entry = db.findEntry(lowText);
			canvas.addEntry(entry);
			//h = entry.getMaxFreq();
			canvas.update();
			
			}
			if(e.getActionCommand().equals("Clear"))
				{
				System.out.println("CLEAR");
				canvas.clear();
				
				}

			
			
	}
	
	
	
	
	
	public void run() {
		
		
		/*BiasBarsDataBase db = new BiasBarsDataBase(DATA_FILE);
		BiasBarsEntry entry = db.findEntry("different");
		int h;
		
		if(entry.equals(null))
			System.out.println("BAD TIMES");
		else
			System.out.println(entry.getDescriptor()+"!");

		
		//System.out.println(entry.toString());
		h = entry.getMaxFreq();
		System.out.println("h= " +h);

		
		
		canvas.addEntry(entry);
		canvas.update();*/
		


	}
}
