
public class Jug {
	private int totalCapacity;
	private int currCapacity;
	
	public Jug(int cap) {
		totalCapacity = cap;
		currCapacity = 0;
	}
	
	public int getTotalCapacity() {
		return totalCapacity;
	}
	
	public int getCurrentCapacity() {
		return currCapacity;
	}
	
	public boolean fill() {
		currCapacity = totalCapacity;
		return true;
	}
	
	public boolean fillFrom(Jug j) {
		currCapacity += j.currCapacity;
		j.currCapacity = 0;
		
		if(currCapacity > totalCapacity) {
			int temp = currCapacity - totalCapacity;
			currCapacity = totalCapacity;
			j.currCapacity = temp;
		}
		return true;
	}
	
	public boolean empty() {
		currCapacity = 0;
		return true;
	}
}
