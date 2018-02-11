
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
}
