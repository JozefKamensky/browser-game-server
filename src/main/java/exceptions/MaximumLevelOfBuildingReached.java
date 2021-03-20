package exceptions;

public class MaximumLevelOfBuildingReached extends Exception{
    public MaximumLevelOfBuildingReached() {
        super("Maximum level of building reached, cannot perform action.");
    }
}
