package you.mine.lib;

import java.util.regex.Matcher;

public class ReplaceResult {
	public final boolean isMatched;
	public final String replacedText;
	public final Matcher matcher;
	public ReplaceResult(boolean isMatched, String replacedText, Matcher matcher) {
		this.isMatched = isMatched;
		this.replacedText = replacedText;
		this.matcher = matcher;
	}
}
