package you.mine.lib;
import java.util.*;

public class Combinator {
	private Combinator() {
	}
	
	public static <T> List<Pair<T, T>> createPairCombination(List<T> list) {
		assert (list != null);
		List<Pair<T, T>> pairList = new ArrayList<Pair<T,T>>();
		if (list.size() == 1)
			return pairList;
		for (int i =0; i<list.size()-1; i++) {
			final List<T> sublist = list.subList(i+1, list.size());
			final T comb = list.get(i);
			for (final T t : sublist) {
				pairList.add(new Pair<T,T>(comb, t));
			}
		}
		return pairList;
	}
	
}
