package you.mine.lib;

/**
 * Foldable has a function and a state (like a closure).
 */
public interface Procedure<A, B> extends Function<A, B> {
	
	public B get();

}