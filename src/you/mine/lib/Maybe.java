package you.mine.lib;

class Maybe<A> {
	final A a;
	final boolean _hasValue; 
	public Maybe(A a) {
		this.a = a;
		_hasValue=true;
	}
	public Maybe() {
		a = null;
		_hasValue=false;
	}

	public boolean hasValue() {
		return _hasValue;
	}
	public A Some() throws Nothing{
		if (_hasValue)
			return a;
		else
			throw new Nothing();
	}
			
}
