package you.mine.lib;

public class Tuple3<A,B,C> {
	private A first;
	private B second;
	private C third;
	public Tuple3(A one, B two, C three) {
		this.first = one;
		this.second = two;
		this.third = three;
	}
	public A getFirst() {
		return first;
	}
	public void setFirst(A one) {
		this.first = one;
	}
	public B getSecond() {
		return second;
	}
	public void setSecond(B two) {
		this.second = two;
	}
	public C getThird() {
		return third;
	}
	public void setThird(C three) {
		this.third = three;
	}
	@Override
	public String toString() {
		return "Tuple3 [one=" + first + ", three=" + third + ", two=" + second + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((third == null) ? 0 : third.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple3 other = (Tuple3) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (third == null) {
			if (other.third != null)
				return false;
		} else if (!third.equals(other.third))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
}
