import acm.program.*;
import java.util.*;


public class Student {

	private String name;
	private int id, units;
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public int getUnits() {
		return units;
	}
	
	public void incrementUnits(int units) {
		this.units += units;
	}
	
	public boolean hasEnoughUnits() {
		return units>= 180;
	}
	
	public String toString() {
		return name + " (#" + id + ")";
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
		units = 0;
	}
	
}
