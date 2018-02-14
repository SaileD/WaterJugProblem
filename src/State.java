
public class State implements Comparable<State>{
	public int one;
	public int two;
	State prevState;

	public State(int x, int y) {
		one = x;
		two = y;
	}
	
	public State(int x, int y, State s) {
		one = x;
		two = y;
		prevState = s;
	}

	@Override
	public int compareTo(State o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + one;
        result = prime * result + two;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        State other = (State) obj;
        if (one != other.one) {
            return false;
        }
        if (two != other.two) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (prevState != null) {
            builder.append(prevState);
        }
        builder.append(one);
        builder.append("    ").append(two).append("\n");
        return builder.toString();
    }
}
