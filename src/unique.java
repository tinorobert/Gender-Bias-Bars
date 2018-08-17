import acm.program.*;
import java.util.*;

public class unique extends ConsoleProgram {

	
	 public void run() {
		 
		String word= "hi";
		ArrayList <String> unik = new ArrayList<>();
		HashMap <String, Integer> dupli = new HashMap<>();
		Integer temp, old, dummy;
		boolean cond;
		//int temp;
		
		while(!word.equals("")) {
		
			
		word = readLine("Enter Name: ");
		//unik.add(word);
		temp = dupli.get(word);
		
		//alt
		//cond = !dupli.containsKey(word);
		
		//WHY ERROR ??????????????????

		dummy = null;

		//THIS WORKS NOT BOOOOOOOO!!!
		//cond = temp.equals(dummy);
		//THIS WORKS  YAYYYYYYYYYYY!!!
		cond = temp==dummy;
		
		
		//temp.
		
		if (cond)
			dupli.put(word, 1);
		else
			{
			old = dupli.get(word);
			dupli.put(word,old+1);
		}
		}
		
		/*unik.remove(unik.size()-1);
		
		for(int i=0; i<unik.size(); i++) {
			
			word = unik.get(i);
			
			for(int j=i+1; j<unik.size()-1; j++)
			{
				if(word.equals(unik.get(j)))
					unik.remove(j);
			}
			
		}
		
		println("List of unique names");
		println(unik.size());
		
		for(String w:unik)
			println(w);*/
		
		println(dupli);
			
		
	}
}
