
public class Jug {
	private int totalCapacity;
	private int currCapacity;

	public Jug(int cap, int start) {
		totalCapacity = cap;
		currCapacity = start;
	}

	public int getTotalCapacity() {
		return totalCapacity;
	}

	public int getCurrentCapacity() {
		return currCapacity;
	}

	public boolean fill() {
		if (currCapacity != totalCapacity) {
			currCapacity = totalCapacity;
			return true;
		} else {
			return false;
		}
	}

	public boolean fillFrom(Jug j) {
		if (j.getCurrentCapacity() == 0 || currCapacity == totalCapacity) {
			return false;
		}

		currCapacity += j.currCapacity;
		j.currCapacity = 0;

		if (currCapacity > totalCapacity) {
			int temp = currCapacity - totalCapacity;
			currCapacity = totalCapacity;
			j.currCapacity = temp;
		}
		return true;
	}

	public boolean empty() {
		if (currCapacity == 0) {
			return false;
		} else {
			currCapacity = 0;
			return true;
		}
	}
}
