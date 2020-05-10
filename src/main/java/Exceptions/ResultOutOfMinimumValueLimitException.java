package Exceptions;

public class ResultOutOfMinimumValueLimitException extends Exception {
    public ResultOutOfMinimumValueLimitException(int minimumValueLimit) {
        super("Result out of minimum value limit. " +
                "Minimum value limit is " + minimumValueLimit + ".");
    }

    public ResultOutOfMinimumValueLimitException(String msg) {
        super(msg);
    }
}
