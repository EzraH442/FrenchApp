package conjugation;

import reader.FrenchEnglishPair;

public class ConjugationEngine {
	
	public static String conjugateWord(FrenchEnglishPair word, GENDER g, TENSE t, boolean isPlural) {
		
		switch (word.getType()) {
		case NOUN:

			break;
		case VERB:
			
			break;
		case ADJECTIVE:
			
			break;
		case PHRASE:
			
			break;
		
		default:
			return word.getFrenchWord();
		}
		return word.getEnglishWord();
	}
	
	public String conjugateNoun(String s, boolean isPlural) {
		if (!isPlural) {
			return s;
		}
		else if (isPlural) {
			return PluralReplacer.makePlural(s);
		}
		return s + " has no plural tag";
	}
	public String conjugateAdjective(String s, GENDER g, boolean isPlural) {
		if (g == GENDER.M) {
			return (isPlural) ? AdjectiveConjugator.conjugateMasculinePlural(s) : s;
		}
		else if (g == GENDER.F) {
			return (isPlural) ? AdjectiveConjugator.conjugateFemininePlural(s) : AdjectiveConjugator.conjugateFeminine(s);
		}
		return s + " is missing flags";
	}
	/*
	public String conjugateVerb(String s, GENDER g, boolean isPlural, TENSE t) {
		
	}
	*/
}
