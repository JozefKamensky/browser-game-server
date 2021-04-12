package exceptions;

public class BarracksNotBuiltException extends Exception {
    public BarracksNotBuiltException() {
        super("You need to build barracks to train troops.");
    }
}
