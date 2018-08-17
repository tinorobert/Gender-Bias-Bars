/*
 * File: BiasBarsGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * frequencies is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the current entry changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
import acm.util.*;
import java.awt.*;


public class BiasBarsGraph extends GCanvas implements ComponentListener {
	
	/** An array of the comment sources for the data. The order of the data in gender-data.txt will line up with this array. */	
	private static final String[] COMMENT_SOURCES = {"Facebook (pol.)", "Facebook (celeb.)", "TEDTalks", "Reddit", "Fitocracy"};

	/** The number of frequencies to label, from 0 to the maximum frequency shown */
	private static final int NLABELS = 11;

	/** The number to round the up to when choosing the maximum value shown on the y-axis */
	private static final int MAGNITUDE = 10;
	
	/** The total width of the bars for each comment source (the width of an actual bar will be half of this) */
	private static final int BARS_WIDTH = 150;

	/** The number of pixels to reserve at the top and bottom of the canvas */
	private static final int VERTICAL_MARGIN = 30;
	
	/** The number of pixels between the left side of the canvas and the left y-axis */
	private static final int LEFT_MARGIN = 50;
	
	/** The number of pixels between the right side of the canvas and the right y-axis */
	private static final int RIGHT_MARGIN = 30;
	
	/** The total length of each tick mark drawn on the y-axis */
	private static final int TICK_MARK_LENGTH = 8;
	
	/** The number of pixels between each axis and its labels */
	private static final int LABEL_OFFSET = 5;

	/** The maximum frequency on the y-axis when there is no current entry */
	private static final int DEFAULT_MAX_FREQ = 1000;

	// TODO add instance variable(s)
	String descriptor;
	BiasBarsEntry entry; 
	//Integer[][] f = new Integer[2][5];
	ArrayList<Integer> f = new ArrayList <>();

	
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public BiasBarsGraph() {
		
		int y = getHeight();		//DONT
		int x = getWidth();		//DONT
		int x1 = 640;
		int y1 = 320;
		x = 754;
		y = 431;
		
		GRect area = new GRect(LEFT_MARGIN,VERTICAL_MARGIN,x-LEFT_MARGIN-RIGHT_MARGIN,y-2*VERTICAL_MARGIN);	
		add(area);
		
		addComponentListener(this);
		
	}
	
	
	/**
	* Clears the current entry stored inside this class. This method should 
	* not affect the appearance of the graph; that is done by calling update.
	*/
	public void clear() {
		// TODO implement this method
		removeAll();
	}
	
	
	/**
	* Specifies a BiasBarsEntry to be the entry shown on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(BiasBarsEntry entry) {
		this.entry = entry;
	}
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the current entry. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		
		if(entry!=null) {

			
		removeAll();
			
		int w = getWidth();
		int h = getHeight();
		int section,hmax, hbar,count=0;
		int xx,yy,ww,hh;
		float perc;
		String msg;
		
		String [] labs = {"Face(pol)", "Face(cel)", "TEDTalks", "Reddit", "Fitocracy"}; 

		section = (w-LEFT_MARGIN-RIGHT_MARGIN)/16;

		
		GRect area = new GRect(LEFT_MARGIN,VERTICAL_MARGIN,w-LEFT_MARGIN-RIGHT_MARGIN,h-2*VERTICAL_MARGIN);	
		add(area);

		
		hmax = entry.getMaxFreq();
		
		for(int i = 0; i<=5 ; i++) {
			float h2 = (float)((h-2*VERTICAL_MARGIN)*0.2*i) + VERTICAL_MARGIN;
			GLine line = new GLine(LEFT_MARGIN - TICK_MARK_LENGTH ,h2,LEFT_MARGIN,h2);
			add(line);
			int calc=(int)(hmax*(1-0.2*i));
			String s = ""+calc;
			GLabel label = new GLabel(s);
			label.setFont("*-BOLD-10");
			add(label,LEFT_MARGIN - TICK_MARK_LENGTH - s.length()*8,h2);

		}
		
		float h2 = (float)(hmax) + VERTICAL_MARGIN;
		GLine line = new GLine(LEFT_MARGIN - TICK_MARK_LENGTH ,h2,LEFT_MARGIN,h2);
		//add(line);
		
		f = entry.getFrequencies('w');
		
		for(Integer n : f) {
			xx = LEFT_MARGIN+section*(3*count+1);
			yy = VERTICAL_MARGIN;
			ww = section;
			perc=(float)(1.0*n/hmax);
			GRect r = new GRect(xx,(h-2*VERTICAL_MARGIN)*(1-perc)+VERTICAL_MARGIN,ww, (h-2*VERTICAL_MARGIN)*perc);
			r.setFilled(true);
			r.setFillColor(Color.RED);
			add(r);
			msg = labs[count];
			GLabel label = new GLabel(msg);
			add(label,xx+section/2, h-VERTICAL_MARGIN + 20);
			count++;
		}

		System.out.println(w + " "  + h + " " + hmax );

		
		f = entry.getFrequencies('m');
		count=0;
		for(Integer n : f) {
			xx = LEFT_MARGIN+section*(3*count+2);
			yy = VERTICAL_MARGIN;
			ww = section;
			perc=(float)(1.0*n/hmax);
			GRect r = new GRect(xx,(h-2*VERTICAL_MARGIN)*(1-perc)+VERTICAL_MARGIN,ww,(h-2*VERTICAL_MARGIN)*perc);
			r.setFilled(true);
			r.setFillColor(Color.BLUE);
			add(r);
			
			count++;
		}
			
		//removeAll();

		}else
			System.out.println("NULL Sir");

	}
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
