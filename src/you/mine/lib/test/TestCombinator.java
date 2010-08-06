package you.mine.lib.test;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import you.mine.lib.Combinator;
import you.mine.lib.Pair;
import static org.junit.Assert.*;

public class TestCombinator {
	@BeforeClass
	public static void beforeClass() {
		
	}
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		List<Pair<Integer, Integer>> ans = Combinator.createPairCombination(list);
		
		List<Pair<Integer, Integer>> exp = new ArrayList<Pair<Integer,Integer>>();
		exp.add(new Pair<Integer, Integer>(1, 2));
		exp.add(new Pair<Integer, Integer>(1, 3));
		exp.add(new Pair<Integer, Integer>(2, 3));
		assertEquals(exp, ans);
	}
}
