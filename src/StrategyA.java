/**
 * Runs the random attempt at solving the water jug problem, note that operators 3 and 4 are not included per the instructions.
 * @author Saile Daimwood
 *
 */
public class StrategyA {
	private Jug jugA;
	private Jug jugB;
	private int goalA;
	private int goalB;
	
	public StrategyA(int jugA_cap, int jugB_cap, int jugA_init, int jugB_init, int jugA_goal, int jugB_goal) {
		jugA = new Jug(jugA_cap, jugA_init);
		jugB = new Jug(jugB_cap, jugB_init);
		
		goalA = jugA_goal;
		goalB = jugB_goal;
		
		beginRun();
	}
	
	public boolean beginRun() {
		
		return true;
	}
	
	// Operator 1
	public void fillJugA() {
		jugA.fill();
	}
	
	// Operator 2
	public void fillJugB() {
		jugB.fill();
	}
	
	//Operator 5
	public void emptyJugA() {
		jugA.empty();
	}
	
	//Operator 6
	public void emptyJugB() {
		jugB.empty();
	}
	
	// This comprises both operators 7 and 9 
	public void fillJugAFromB() {
		jugA.fillFrom(jugB);
	}
	
	// This comprises both operators 8 and 10
	public void fillJugBFromA() {
		jugB.fillFrom(jugA);
	}
}
