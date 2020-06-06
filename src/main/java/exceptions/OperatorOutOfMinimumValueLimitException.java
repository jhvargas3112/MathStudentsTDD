package exceptions;

public class OperatorOutOfMinimumValueLimitException extends Exception {
  public OperatorOutOfMinimumValueLimitException(int operatorPosition, int minimumValueLimit) {
    super(
        "The operator of the position "
            + operatorPosition
            + " is out of minimum value limit. "
            + "Minimum value limit is "
            + minimumValueLimit
            + ".");
  }

  public OperatorOutOfMinimumValueLimitException(String msg) {
    super(msg);
  }
}
