package reader;

//import conjugation.GENDER;
//import conjugation.TENSE;

public class MetaReader {
	private final String raw;
	
	private String[] args;
	public MetaReader(final String input) {
		this.raw = input;
		args = getArgs(raw);
	}
	
	public String[] getArgs(String raw) {
		String s = raw.substring(1);
		s = s.strip();
		args = s.split(",");
		return args;
	}
	
	public Metadata getData() {
		TYPE type = null;
		//final GENDER gender;
		//final TENSE tense;
		
		for (String argument : args) {
			String key = argument.split("=")[0].strip();
			String value = argument.split("=")[1].strip();
			
			switch (key) {
			case "type":
				type = TYPE.determineType(value);
				break;
			}
			
		}

		return new Metadata(type);
	}
}
/*
<default = deteriminetype >

possible arguments:
- type: the type word the file contains
	- verb/noun/adjective

*/