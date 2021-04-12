package exceptions;

public class MaximumNumberOfTroopsReached extends Exception{
    public MaximumNumberOfTroopsReached() {
        super("Maximum number of troops reached, upgrade supply center.");
    }
}
