/*
* File: RandomCircles.java
* ------------------------
* This program draws a set of 10 circles with random sizes,
* positions, and colors. */
import acm.program.*;

	public class RandomCircles extends ConsoleProgram {
		/** Number of circles */
		private static final int NCIRCLES = 10; 
		RandomCircleCanvas canvas;
		
		public void init() {
			canvas = new RandomCircleCanvas();
            add(canvas);
      }
		public void run() {
			for (int i = 0; i < NCIRCLES; i++) {
			
		canvas.drawRandomCircle(); 
		}
			
		String word = readLine("name?: ");
		println("Well Done, "+ word);

		} 
		
	}
