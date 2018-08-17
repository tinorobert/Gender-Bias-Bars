import acm.program.*;
import java.util.*;

public class MutualFriends extends ConsoleProgram{
	public void run() {
		HashMap <String, Integer> p1= new HashMap<>();
		HashMap <String, Integer> p2= new HashMap<>();
		HashMap <String, Integer> friends= new HashMap<>();
		//HashMap <String, Integer> friends= {("a":900)};
		
		
		p1.put("a",100);
		p1.put("b",200);
		p1.put("c",300);
		p1.put("m",500);
		p2.put("a",1000);
		p2.put("b",200);
		p2.put("d",100);
		p2.put("m",500);
		
		for(String name: p1.keySet()) {
			
			if(p2.containsKey(name))
				if(p1.get(name).equals(p2.get(name)))
					friends.put(name, p1.get(name));
			
			

		
		}
		
		println(friends.toString());
		println(friends);
		println(friends.keySet());

	}
}
