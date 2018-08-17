import acm.program.*;
import java.util.*;

public class switchPairs extends ConsoleProgram{

	public void run() {
		
		//HOW TO INITIALIZE ARRAYLISTS???
		//ArrayList<String> pairs= <"four", "score", "and", "seven", "years", "ago">;
		List<String> pairs = Arrays.asList("four", "score", "and", "seven", "years", "ago", "mango");
		//ArrayList<String> pairs= new ArrayList<>();
		String temp;
		
		for(int i=0; i<pairs.size()-1; i+=2) {
			temp = pairs.get(i);
			pairs.set(i, pairs.get(i+1));
			pairs.set(i+1, temp);
		}
		
		println(pairs);

	}
}
