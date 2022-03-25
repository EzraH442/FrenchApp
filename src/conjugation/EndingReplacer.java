package conjugation;

import java.util.regex.Pattern;

public class EndingReplacer {
	private String replacedText;
	private String newText;
	private int replacedTextLength;
	Pattern pattern;
	public EndingReplacer(String replacedT, String newT) {
		this.replacedText = replacedT;
		this.newText = newT;
		this.pattern = Pattern.compile(".*" + replacedText);
		this.replacedTextLength = replacedText.length();
	}
	
	public String replaceWord(String s) {
		return s.substring(0, (s.length()-replacedTextLength)) + newText;
	}
	
	public boolean stringMatches(String s) {
		return pattern.matcher(s).matches();
	}
	
}
