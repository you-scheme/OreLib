package you.mine.lib;
import java.io.PrintStream;
import java.util.*;
import java.util.Map.Entry;

public class MapUtils {
	public static <T> void countMap (T t, Map<T, Long> map) {
		if (map.containsKey(t)) {
			map.put(t, map.get(t)+1);
		} else {
			map.put(t, 1L);
		}
	}
	public static <T> void printMapEntry(Map<T, Long> map, PrintStream ps) {
		for (Entry<T, Long> entry : map.entrySet()) {
			ps.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}
