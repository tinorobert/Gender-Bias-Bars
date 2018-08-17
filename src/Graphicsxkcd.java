import acm.program.*;
import acm.util.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class Graphicsxkcd extends Program{

	private JButton button1, button2;

	Canvasxkcd canvas = new Canvasxkcd();
	JTextField field;
	HashMap <String,String> colors = new HashMap <>(); 

		
	public void init() {
		canvas.setBackground(Color.BLUE);
		canvas.setSize(2000, 1000);
		add(canvas);
		
		
		
		JLabel label = new JLabel("Enter color: ");
		add(label, SOUTH);
		button1 = new JButton("Show");
		add(button1, SOUTH);
		button2 = new JButton("Random");
		add(button2, SOUTH);
		field = new JTextField(10);
		field.addActionListener(this);
		field.setActionCommand("Show");
		//button2.setActionCommand("write here");
		add(field, SOUTH);
		field.setText("blue");
		addActionListeners();
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String col, rgb;
		StringTokenizer t;
		String r,g,b;
		int r1=0,g1=0,b1=0;
		
		if(e.getActionCommand().equals("Show")) 
		//if(e.getSource().equals(button1)) 
		{
			col=field.getText();
			rgb = colors.get(col);
			
			
			if(rgb!=null){
				t = new StringTokenizer(rgb);
				

				r =  t.nextToken();
				//t.n
				g = t.nextToken();
				b = t.nextToken();
				//Color c = new Color(r,g,b);
				print(r + g + b);

				r1 = convertNumbers(r);
				g1 = convertNumbers(g);
				b1 = convertNumbers(b);
				
				Color a1 = new Color(r1,g1,b1);
				canvas.setBackground(a1);



			}
			else
				println("NO COLOR");
			
			//Color a1 = new Color(20,20,20);
			//Color a = new Color(20,20,20);

			//canvas.setBackground(Color.GRAY);
			//add(canvas);
			//lookupColor()
		}
		
		
		if(e.getActionCommand().equals("Random")) {
					
			canvas.setBackground(rgen.nextColor());
		}

			
		//println(field.getText());
			
	}
	
	
		
	private void createMap() {
		
		String  key, val;
		String r,g,b;
		//int[] array = new int[3]; 
		//println("hey");
		
		try {
			Scanner in = new Scanner(new File("Example colors.txt"));
			
			while(in.hasNextLine()) {
				key = in.nextLine();
				//println(key);
				val = in.nextLine();

				
				colors.put(key, val);
				
			}
			
		} catch(FileNotFoundException e){
			println("Not Found");
			}
		
		println(colors);
		
	}
	
	private int convertNumbers(String n) {
		int a, b, c;
		int l, number=0;

		l = n.length();
		
		if (l==1) {
			number = n.charAt(0)-48;
			//println("number "+a);
		}
		
		if (l==2) {
			a = n.charAt(0)-48;
			b = n.charAt(1)-48;
			number = 10*a+b;
			//println("number "+a);
		}
		
		
		if (l==3) {
			a = n.charAt(0)-48;
			b = n.charAt(1)-48;
			c = n.charAt(2)-48;
			number = 100*a+10*b+c;
			//println("number "+a);
		}
		
		
		//println("number: "+ number);

		return number;
		
	}
	
	
	public void run() {
		
		createMap();

	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
