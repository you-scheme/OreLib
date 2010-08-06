package you.mine.lib.test;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import you.mine.lib.CombinationIteratorCreator;
import you.mine.lib.Combinator;
import you.mine.lib.Pair;
import static org.junit.Assert.*;

public class TestCombinationIteratorCreator {
	@BeforeClass
	public static void beforeClass() {
		
	}
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Iterator<Pair<Integer, Integer>> iter = CombinationIteratorCreator.createCombinationIterator(list);
		List<Pair<Integer, Integer>> ans = new ArrayList<Pair<Integer,Integer>>();
		while (iter.hasNext())
			ans.add(iter.next());
		
		List<Pair<Integer, Integer>> exp = new ArrayList<Pair<Integer,Integer>>();
		exp.add(new Pair<Integer, Integer>(1, 2));
		exp.add(new Pair<Integer, Integer>(1, 3));
		exp.add(new Pair<Integer, Integer>(2, 3));
		assertEquals(exp, ans);
	}
}
