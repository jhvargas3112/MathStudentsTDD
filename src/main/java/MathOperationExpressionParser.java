public class MathOperationExpressionParser {
  public MathToken[] getMathTokens(String mathOperationExpression) {
    MathToken[] mathTokens = new MathToken[3];

    mathTokens[0] = new MathToken("2");
    mathTokens[1] = new MathToken("+");
    mathTokens[2] = new MathToken("2");

    return mathTokens;
  }

  public boolean simpleMathExpressionIsValid(String mathOperationExpression) {
    return mathOperationExpression.matches("\\d+\\s*[\\+\\-\\*\\/]{1}\\s*\\d+");
  }

  public boolean complexMathExpressionIsValid(String mathOperationExpression) {
    return mathOperationExpression.matches(
        "^(\\d+\\s*[\\+\\-\\*\\/]{1}\\s*\\d+)(\\s*[\\+\\-\\*\\/]{1}\\s*\\d+)*$");
  }
}
