package exceptions;

public class InvalidAttackException extends RuntimeException {

    public InvalidAttackException() {
        super();
    }

    public InvalidAttackException(final String message) {
        super(message);
    }
}
