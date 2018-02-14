import java.io.PrintWriter;
import java.util.*;

public class StrategyB {
	private Jug jugA;
	private Jug jugB;
	private int goalA;
	private int goalB;
	private PrintWriter out;
	private LinkedList<State> stateList;
	private State finalState;
	private Queue<State> visited;

	public StrategyB(int jugA_cap, int jugB_cap, int jugA_init, int jugB_init, int jugA_goal, int jugB_goal,
			PrintWriter out) {
		jugA = new Jug(jugA_cap, jugA_init);
		jugB = new Jug(jugB_cap, jugB_init);

		goalA = jugA_goal;
		goalB = jugB_goal;

		this.out = out;

		finalState = new State(jugA_goal, jugB_goal);

		stateList = new LinkedList<State>();
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

			if (solutionReached(s)) {
				finalState = s;
				break;
			}

			if (s.one == 0) {
				State next = fillJugA(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}

			if (s.two == 0) {
				State next = fillJugB(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}

			if (s.one > 0) {
				State next = emptyJugA(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}

			if (s.two > 0) {
				State next = emptyJugB(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}

			if (s.one > 0 && s.two != jugB.getTotalCapacity()) {
				State next = fillJugBFromA(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}

			if (s.two > 0 && s.one != jugA.getTotalCapacity()) {
				State next = fillJugAFromB(s);
				if (!stateList.contains(next)) {
					visited.add(next);
					stateList.add(next);
				}
			}
		}
		if (finalState != null) {
			System.out.println(finalState);
			out.println(finalState);
		} else {
			System.out.println("Not Possible");
			out.println("Not possible");

		}
		return true;
	}

	// Operator 1
	public State fillJugA(State s) {
		return new State(jugA.getTotalCapacity(), s.two, s, "Fill the " + jugA.getTotalCapacity()
				+ "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: (" + jugA.getTotalCapacity() + ", " + s.two + ")");

	}

	// Operator 2
	public State fillJugB(State s) {
		return new State(s.one, jugB.getTotalCapacity(), s, "Fill the " + jugB.getTotalCapacity()
				+ "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: (" + s.one + ", " + jugB.getTotalCapacity() + ")");
	}

	// Operator 5
	public State emptyJugA(State s) {
		return new State(0, s.two, s, "Empty the " + jugA.getTotalCapacity()
				+ "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: (0" + ", " + s.two + ")");
	}

	// Operator 6
	public State emptyJugB(State s) {
		return new State(s.one, 0, s, "Empty the " + jugB.getTotalCapacity()
				+ "-gallon jug\t\t\t\t\t\t\t\t\t\t --- state: (" + s.one + ", 0" + ")");
	}

	// This comprises both operators 7 and 9
	public State fillJugAFromB(State s) {
		int one = s.one;
		int two = s.two;

		one += two;
		two = 0;

		if (one > jugA.getTotalCapacity()) {
			int temp = one - jugA.getTotalCapacity();
			one = jugA.getTotalCapacity();
			two = temp;
		}

		return new State(one, two, s, "Pour water from the " + jugA.getTotalCapacity() + "-gallon jug into the "
				+ jugB.getTotalCapacity() + "-gallon jug\t\t --- state: (" + one + ", " + two + ")");
	}

	// This comprises both operators 8 and 10
	public State fillJugBFromA(State s) {
		int one = s.one;
		int two = s.two;

		two += one;
		one = 0;

		if (two > jugB.getTotalCapacity()) {
			int temp = two - jugB.getTotalCapacity();
			two = jugB.getTotalCapacity();
			one = temp;
		}
		return new State(one, two, s, "Pour water from the " + jugB.getTotalCapacity() + "-gallon jug into the "
				+ jugA.getTotalCapacity() + "-gallon jug\t\t --- state: (" + one + ", " + two + ")");
	}

	// Pour water from the 7-gallon jug into the 4-gallon jug
	public boolean solutionReached(State s) {
		if (goalA == -1 && goalB == -1) {
			return true;
		}

		if (goalA == -1) {
			if (s.two == goalB)
				return true;
			else
				return false;

		} else if (goalB == -1) {
			if (s.one == goalA)
				return true;
			else
				return false;

		} else {
			if (s.one == goalA && s.two == goalB)
				return true;
			else
				return false;

		}
	}
}
