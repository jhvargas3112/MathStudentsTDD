package Exceptions;

public class OperatorOutOfMaximumValueLimitException extends Exception {
    public OperatorOutOfMaximumValueLimitException(int operatorPosition, int maximumValueLimit) {
        super("The operator of the position " + operatorPosition +
                " is out of maximum value limit. " +
                "Maximum value limit is " + maximumValueLimit + ".");
    }

    public OperatorOutOfMaximumValueLimitException(String msg) {
        super(msg);
    }
}
