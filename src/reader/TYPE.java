package reader;

public enum TYPE {
	NOUN,
	VERB,
	ADJECTIVE,
	PHRASE,
	OTHER;
	
	public static TYPE determineType(String s) {
		TYPE type = null;
		switch (s) {
		case "noun":
			type = NOUN;
			break;
		case "n":
			type = NOUN;
			break;
		case "verb":
			type = VERB;
			break;
		case "v":
			type = VERB;
			break;
		case "adjective":
			type = ADJECTIVE;
			break;
		case "a":
			type = ADJECTIVE;
			break;
		case "phrase":
			type = PHRASE;
			break;
		case "p":
			type = PHRASE;
			break;
		default:
			type = OTHER;
		}
		return type;
	}
}
