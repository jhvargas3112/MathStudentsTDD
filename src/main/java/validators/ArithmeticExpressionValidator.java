package validators;

public class ArithmeticExpressionValidator {
  public boolean arithmeticExpressionIsValid(String mathOperationExpression) {
    return mathOperationExpression.matches(
        "^(-{0,1}\\d+\\s*[\\+\\-\\*\\/]{1}\\s*-{0,1}\\d+)(\\s*[\\+\\-\\*\\/]{1}\\s*-{0,1}\\d+)*$");
  }
}
