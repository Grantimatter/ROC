package exceptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
        super();
    }

    public InvalidInputException(final String message) {
        super(message);
    }
}
