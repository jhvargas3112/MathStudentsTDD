package Exceptions;

public class ResultOutOfMaximumValueLimitException extends Exception {
    public ResultOutOfMaximumValueLimitException(int maximumValueLimit) {
        super("Result out of maximum value limit. " +
                "Maximum value limit is " + maximumValueLimit + ".");
    }

    public ResultOutOfMaximumValueLimitException(String msg) {
        super(msg);
    }
}
