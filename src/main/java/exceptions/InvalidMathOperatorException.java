package exceptions;

public class InvalidMathOperatorException extends Exception {
  public InvalidMathOperatorException() {
    super("The given token is not a valid math operator.");
  }

  public InvalidMathOperatorException(String msg) {
    super(msg);
  }
}
