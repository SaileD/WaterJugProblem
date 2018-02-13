import java.io.PrintWriter;
import java.util.*;;

public class StrategyB {
	private Jug jugA;
	private Jug jugB;
	private int goalA;
	private int goalB;
	private PrintWriter out;
	private Map<State, Boolean> stateMap;
	private Queue<State> visited;

	public StrategyB(int jugA_cap, int jugB_cap, int jugA_init, int jugB_init, int jugA_goal, int jugB_goal,
			PrintWriter out) {
		jugA = new Jug(jugA_cap, jugA_init);
		jugB = new Jug(jugB_cap, jugB_init);

		goalA = jugA_goal;
		goalB = jugB_goal;

		this.out = out;

		stateMap = new HashMap<State, Boolean>();
		visited = new PriorityQueue<State>();
		visited.add(new State(0, 0));

		run();
	}

	public boolean run() {
		System.out.println("Strategy B");

		out.println("Strategy B");

		System.out.println("Starting out with a " + jugA.getTotalCapacity() + "-gallon jug and a "
				+ jugB.getTotalCapacity() + "-gallon jug\t\t --- state: (" + jugA.getCurrentCapacity() + ", "
				+ jugB.getCurrentCapacity() + ")");

		out.println("Starting out with a " + jugA.getTotalCapacity() + "-gallon jug and a " + jugB.getTotalCapacity()
				+ "-gallon jug\t\t\t --- state: (" + jugA.getCurrentCapacity() + ", " + jugB.getCurrentCapacity()
				+ ")");

		while (!visited.isEmpty()) {
			State s = visited.peek();

			visited.remove();

			// check to see if state is already visited, if it is, move on
			if (stateMap.get(s).equals(true)) {
				continue;
			}
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
