import acm.program.*;
import java.util.*;

public class Tokenizer extends ConsoleProgram{

	public void run() {
		
		String word;
		
		word = readLine("line: ");
		println(word);
		
		StringTokenizer tokenizer = new StringTokenizer(word);
		
		println(tokenizer.countTokens());
		
		while(tokenizer.hasMoreTokens()) {
			println(tokenizer.nextToken());
			//println(tokenizer.nextToken(","));
		}
		
		
	}
}
