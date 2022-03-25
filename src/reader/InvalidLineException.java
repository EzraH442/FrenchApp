package reader;

@SuppressWarnings("serial")
public class InvalidLineException extends Exception {
    public InvalidLineException(String message) {
        super(message);
    }
}
