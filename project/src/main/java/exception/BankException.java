package exception;

public class BankException extends RuntimeException {
    public BankException() {
        super();
    }

    public BankException(final String message) {
        super(message);
    }
}
