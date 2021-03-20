package exceptions;

public class NotEnoughResourcesException extends Exception {
    public NotEnoughResourcesException() {
        super("Not enough resources, cannot perform action.");
    }
}
