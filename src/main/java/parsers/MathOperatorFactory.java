package parsers;

import org.apache.commons.lang3.StringUtils;

public class MathOperatorFactory {
  public static MathOperator create(ArithmeticExpressionToken arithmeticExpressionToken) {
    MathOperator mathOperator = null;

    String operatorToken = arithmeticExpressionToken.getToken();

    if (StringUtils.equals(operatorToken, "*") || StringUtils.equals(operatorToken, "/")) {
      mathOperator = new MathOperator(operatorToken, 2);
    } else {
      mathOperator = new MathOperator(operatorToken, 0);
    }

    return mathOperator;
  }
}
