package you.mine.lib.test;


import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import you.mine.lib.StringUtils;
import static org.junit.Assert.*;


public class TestStringUtils {
	@BeforeClass
	public static void beforeClass() {
		
	}
	@Test
	public void testEqIgnorecase() {
		List<String> A = Arrays.asList("abc", "efG");
		List<String> B = Arrays.asList("AbC", "Efg");
		
		assertEquals(true, StringUtils.eqIgnorecase(A, B));
		
		A = Arrays.asList("AAA", "efG");
		B = Arrays.asList("AbC", "Eg");
		
		assertEquals(false, StringUtils.eqIgnorecase(A, B));
	}
	
	@Test
	public void testJoin() {
		List<String> A = Arrays.asList("Is", "A", "Map");
		assertEquals("IsAMap", StringUtils.join(A));
	}
	
	@Test
	public void testConvertType() {
		String s = "java.util.List<A>";
		assertEquals("List", StringUtils.convertTypeName(s));
		
		s = "int";
		assertEquals("Int", StringUtils.convertTypeName(s));
	}
}
