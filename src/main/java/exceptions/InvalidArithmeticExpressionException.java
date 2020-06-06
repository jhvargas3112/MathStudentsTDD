package exceptions;

public class InvalidArithmeticExpressionException extends Exception {
  public InvalidArithmeticExpressionException() {
    super("Invalid arithmetic expression");
  }

  public InvalidArithmeticExpressionException(String msg) {
    super(msg);
  }
}
