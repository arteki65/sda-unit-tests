package pl.aptewicz.unittests;

public class InvalidNumberProvidedException extends RuntimeException {
    public InvalidNumberProvidedException(String message) {
        super(message);
    }
}
