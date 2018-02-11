import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WaterJugProblem {

	public static void main(String[] args) throws FileNotFoundException {
		File inFile = new File("Examples/input1.txt");
		Scanner in = new Scanner(inFile);

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
		
		System.out.println(jugAInitial + " " + jugBInitial + " " + jugAGoal + " " + jugBGoal);
	}

}