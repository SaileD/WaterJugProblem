public class State implements Comparable<State> {
	public int one;
	public int two;
	private State prevState;
	private String description;

	public State(int x, int y) {
		one = x;
		two = y;
		description = "";
	}

	public State(int x, int y, State s, String d) {
		one = x;
		two = y;
		prevState = s;
		description = d;
	}

	@Override
	public int compareTo(State o) {
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
		if (prevState != null)
			builder.append(prevState);

		if (!description.equals(""))
			builder.append(description).append("\n");
		return builder.toString();
	}
}
