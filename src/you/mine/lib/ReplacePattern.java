package you.mine.lib;
import java.util.regex.*;
import java.util.*;
public class ReplacePattern {
	final Pattern pattern;
	final String ReplaceText;
	Boolean isMatch = null;
	final boolean isGlobalReplace;
	public ReplacePattern(Pattern pattern, String ReplaceText, boolean isGlobalReplace) {
		this.pattern = pattern;
		this.ReplaceText = ReplaceText;
		this.isGlobalReplace = isGlobalReplace; 
	}
	
	public ReplaceResult MatchAndReplace(String str) {
		Matcher m = pattern.matcher(str);
		if(m.matches()) {
			if (isGlobalReplace) {
				return new ReplaceResult(true, m.replaceAll(ReplaceText), m);
			} else {
				return new ReplaceResult(true, m.replaceFirst(ReplaceText),m);
			}
		} else {
			return new ReplaceResult(false, str,m);
		}
	}
	
	public boolean isMatch(String str) {
		return pattern.matcher(str).matches(); 
	}
}
