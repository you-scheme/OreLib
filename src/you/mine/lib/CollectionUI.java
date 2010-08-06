package you.mine.lib;
import java.util.*;
public class CollectionUI {
	private CollectionUI() {}
	public static <T0, T1> List<T1> map(Collection<T0> collection, Function<T0, T1> each) {
		List<T1> result = new ArrayList<T1>(collection.size());
		for (T0 element : collection) {
			result.add(each.apply(element));
		}
		return result;
	}
	
	public static <T0> List<T0> filter(Collection<T0> collection, Function<T0, Boolean> each) {
		List<T0> result = new ArrayList<T0>();
		for (T0 element : collection) {
			if (each.apply(element)) result.add(element);
		}
		return result;
	}
	
	public static <T0, T1> T1 foldLeft(Collection<T0> collection, Procedure<T0, T1> each) {
		for (T0 element : collection) {
			each.apply(element);
		}
		
		return each.get();
	}
	
}
