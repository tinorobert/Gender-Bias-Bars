import acm.program.*;
import java.util.*;

public class Airport extends ConsoleProgram{
	
	
	public void run() {
	
		ArrayList<Airplane> planes = new ArrayList <>();
		
		Airplane a = new Airplane();
		Airplane b = new Airplane();
		planes.add(a);
		planes.add(b);
		
		b.takeoff();
		
		Airplane c = new Airplane();
		planes.add(c);
		
		for(Airplane plane: planes) {
			if(!plane.isAirborne())
				plane.takeoff();
		}
	}

}
