import java.io.PrintWriter;

/**
 * Runs the random attempt at solving the water jug problem, note that operators
 * 3 and 4 are not included per the instructions.
 * 
 * @author Saile Daimwood
 *
 */
public class StrategyA {
	private Jug jugA;
	private Jug jugB;
	private int goalA;
	private int goalB;
	private PrintWriter out;

	public StrategyA(int jugA_cap, int jugB_cap, int jugA_init, int jugB_init, int jugA_goal, int jugB_goal,
			PrintWriter out) {
		jugA = new Jug(jugA_cap, jugA_init);
		jugB = new Jug(jugB_cap, jugB_init);

		goalA = jugA_goal;
		goalB = jugB_goal;

		this.out = out;

		run();
	}

	// Random selection
	public boolean run() {
		System.out.println("Strategy A");

		out.println("Strategy A");

		System.out.println("Starting out with a " + jugA.getTotalCapacity() + "-gallon jug and a "
				+ jugB.getTotalCapacity() + "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", "
				+ jugB.getCurrentCapacity() + ")");

		out.println("Starting out with a " + jugA.getTotalCapacity() + "-gallon jug and a " + jugB.getTotalCapacity()
				+ "-gallon jug\t\t\t --- state: (" + jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity()
				+ ")");

		int counter = 0;
		while (!solutionReached() && counter < 250) {
			// generate random number between 0->5
			int choice = (int) (Math.random() * 6);

			switch (choice) {
			case 0:
				if (jugA.getCurrentCapacity() != jugA.getTotalCapacity())
					fillJugA();
				else
					continue;

				break;
			case 1:
				if (jugB.getCurrentCapacity() != jugB.getTotalCapacity())
					fillJugB();
				else
					continue;
				break;
			case 2:
				if (jugA.getCurrentCapacity() != 0)
					emptyJugA();
				else
					continue;
				break;
			case 3:
				if (jugB.getCurrentCapacity() != 0)
					emptyJugB();
				else
					continue;
				break;
			case 4:
				if (jugB.getCurrentCapacity() != 0 && jugA.getCurrentCapacity() != jugA.getTotalCapacity())
					fillJugAFromB();
				else
					continue;
				break;
			case 5:
				if (jugA.getCurrentCapacity() != 0 && jugB.getCurrentCapacity() != jugB.getTotalCapacity())
					fillJugBFromA();
				else
					continue;
				break;
			}

			counter++;
		}
		return true;
	}

	// Operator 1
	public void fillJugA() {
		jugA.fill();
		System.out.println("Fill the " + jugA.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");

		out.println("Fill the " + jugA.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// Operator 2
	public void fillJugB() {
		jugB.fill();
		System.out.println("Fill the " + jugB.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");

		out.println("Fill the " + jugB.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// Operator 5
	public void emptyJugA() {
		jugA.empty();
		System.out.println("Empty the " + jugA.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");

		out.println("Empty the " + jugA.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// Operator 6
	public void emptyJugB() {
		jugB.empty();
		System.out.println("Empty the " + jugB.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");

		out.println("Empty the " + jugB.getTotalCapacity() + "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: ("
				+ jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// This comprises both operators 7 and 9
	public void fillJugAFromB() {
		jugA.fillFrom(jugB);
		System.out.println("Pour water from the " + jugA.getTotalCapacity() + "-gallon jug into the "
				+ jugB.getTotalCapacity() + "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", "
				+ jugB.getCurrentCapacity() + ")");

		out.println("Pour water from the " + jugA.getTotalCapacity() + "-gallon jug into the " + jugB.getTotalCapacity()
				+ "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// This comprises both operators 8 and 10
	public void fillJugBFromA() {
		jugB.fillFrom(jugA);
		System.out.println("Pour water from the " + jugB.getTotalCapacity() + "-gallon jug into the "
				+ jugA.getTotalCapacity() + "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", "
				+ jugB.getCurrentCapacity() + ")");

		out.println("Pour water from the " + jugB.getTotalCapacity() + "-gallon jug into the " + jugA.getTotalCapacity()
				+ "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity() + ")");
	}

	// Pour water from the 7-gallon jug into the 4-gallon jug
	public boolean solutionReached() {
		if (goalA == -1 && goalB == -1) {
			return true;
		}

		if (goalA == -1) {
			if (jugB.getCurrentCapacity() == goalB)
				return true;
			else
				return false;

		} else if (goalB == -1) {
			if (jugA.getCurrentCapacity() == goalA)
				return true;
			else
				return false;

		} else {
			if (jugA.getCurrentCapacity() == goalA && jugB.getCurrentCapacity() == goalB)
				return true;
			else
				return false;

		}
	}
}
