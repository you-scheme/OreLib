package you.mine.lib;

import java.util.*;

public class CombinationIteratorCreator {
	public static <E> CombinationIterator<E> createCombinationIterator(List<E> list) {
		return new CombinationIterator<E>(list);
	}
}
