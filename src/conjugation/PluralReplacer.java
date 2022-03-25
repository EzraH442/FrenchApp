package conjugation;

public class PluralReplacer {
	private static EndingReplacer[] replacers = {
			new EndingReplacer("u", "x"),		
			new EndingReplacer("al", "aux"), new EndingReplacer("ail", "aux"),
			new EndingReplacer("eau", "eaux"), new EndingReplacer("eu", "eux")
	};
	private static EndingReplacer replacerOU= new EndingReplacer("ou", "oux");
	private static String[] ouNouns = {
			"Bijou", "Caillou", "Chou", "Genou",
			"Hibou", "Joujou", "Pou", "Ripou",
	};
	public static String makePlural(String s) {
		if (s.endsWith("s") || s.endsWith("x") || s.endsWith("z")) {
			return s;
		}
		
		for (EndingReplacer replacer : replacers) {
			if (replacer.stringMatches(s)) {
				return replacer.replaceWord(s);
			}
		}
		
		for (String noun : ouNouns) {
			if (s.equals(noun)) {
				return replacerOU.replaceWord(s);
			}
		}
		return s.concat("s");
	}
	public static String makeFemininePlural(String s) {
		
		
		return s.concat("es");
	}
}
