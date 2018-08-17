import acm.program.*;
import java.util.*;

public class Reverse extends ConsoleProgram{

	public void run() {
		
		HashMap <Integer, String> map= new HashMap <>();
		HashMap <String, Integer> reverse= new HashMap <>();
		String temp;
		
		//map = {42=Marty, 81=Cynthia, 17=Dan, 31=Emma, 56=Dan, 3=Marty, 29=Dan};
		map.put(42, "m");
		map.put(81, "c");
		map.put(17, "d");
		map.put(31, "e");
		map.put(56, "d");
		map.put(3, "m");
		map.put(29, "d");
		
		for(Integer key: map.keySet()) {
			temp = map.get(key);
			reverse.put(temp, key);
		}

		System.out.println(map);
		println(map);
		System.out.println(reverse);
		println(reverse);
	}
	
}
