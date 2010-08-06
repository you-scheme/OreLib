package you.mine.lib;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringUtils {
	private StringUtils() {
	}
	public static boolean eqIgnorecase(String A, String B) {
		return (A.toLowerCase().equals(B.toLowerCase()));
	}
	public static boolean eqIgnorecase(List<String> A, List<String> B) {
		if (A.size() != B.size()) {
			return false;
		} else {
			for (int i = 0; i < A.size(); i++) {
				if (!eqIgnorecase(A.get(i), B.get(i))) {
					return false;
				}
			}
			return true;
		}
	}
	public static String join(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public final static Pattern shortTypeNameExtractPattern = Pattern.compile("^.+\\.(.+?)$");
	public final static Pattern genelicPattern = Pattern.compile("(<.+>)");
	
	public static String convertTypeName(String longType) {
		Matcher gene1 = genelicPattern.matcher(longType);
		String nonGeneType;
		if (gene1.find()) {
			nonGeneType = gene1.replaceFirst("");
		} else {
			nonGeneType = longType;
		}
		
		Matcher mm1 = shortTypeNameExtractPattern.matcher(nonGeneType);
		String shotType;
		if (mm1.find()) {
			shotType = mm1.group(1);
		} else {
			shotType = nonGeneType;
		}
		return StringUtils.join(Splitter.normalizeCamelNames(Splitter.splitOnStrictCamel(shotType)));
	}
}
