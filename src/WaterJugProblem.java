import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WaterJugProblem {

	public static void main(String[] args) throws IOException {
		// TODO: change new File("inputx.txt"); to new File(args[0]);
		File inFile = new File("Examples/input1.txt");
		Scanner in = new Scanner(inFile);
		PrintWriter out = new PrintWriter(new FileWriter("Examples/output.txt"));

		String jugAInfo = in.nextLine();
		String jugBInfo = in.nextLine();
		String initialState = in.nextLine();
		String goal = in.nextLine();

		in.close();

		// Begin extraction here
		String[] jugA = jugAInfo.split("Capacity of jug A: ");
		String[] jugB = jugBInfo.split("Capacity of jug B: ");
		String[] state = initialState.split("Initial state: ");
		String[] goalState = goal.split("Goal state: ");

		// After below, jugA and jugB are good to go, just need parsing.
		jugAInfo = jugA[1];
		jugBInfo = jugB[1];
		initialState = state[1];
		goal = goalState[1];

		// Let's parse jugA and B, and split initial and goal
		int capacityA = Integer.parseInt(jugAInfo);
		int capacityB = Integer.parseInt(jugBInfo);
		String[] initialStatePair = initialState.split(" ");
		String[] goalStatePair = goal.split(" ");

		// Parse initial and goal
		int jugAInitial = Integer.parseInt(initialStatePair[0]);
		int jugBInitial = Integer.parseInt(initialStatePair[1]);
		int jugAGoal = Integer.parseInt(goalStatePair[0]);
		int jugBGoal = Integer.parseInt(goalStatePair[1]);

		StrategyA run_1 = new StrategyA(capacityA, capacityB, jugAInitial, jugBInitial, jugAGoal, jugBGoal, out);

		out.println();

		StrategyB run_2 = new StrategyB(capacityA, capacityB, jugAInitial, jugBInitial, jugAGoal, jugBGoal, out);

		out.close();

		System.out.println(run_1 + "\n" + run_2);
	}

}
