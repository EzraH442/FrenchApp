package conjugation;

public class AdjectiveConjugator {
	public static String conjugateMasculinePlural(String s) {
		return PluralReplacer.makePlural(s);
	}
	public static String conjugateFeminine(String s) {
		return (s.endsWith("e")) ? s : s.concat("e");
		
	}
	public static String conjugateFemininePlural(String s) {
		return s;
	}
}
