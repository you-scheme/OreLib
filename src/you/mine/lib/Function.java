package you.mine.lib;

/**
 * Function that returns value of type B using value of type A.
 */
public interface Function<A, B> {
	public B apply(A element);
}
