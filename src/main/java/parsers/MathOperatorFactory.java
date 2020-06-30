package parsers;

import exceptions.InvalidMathOperatorException;
import org.apache.commons.lang3.StringUtils;

public class MathOperatorFactory {
  public static MathOperator create(ArithmeticExpressionToken arithmeticExpressionToken)
      throws InvalidMathOperatorException {
    MathOperator mathOperator = null;

    String operatorToken = arithmeticExpressionToken.getToken();

    if (StringUtils.equals(operatorToken, "+")) {
      mathOperator = new AdditionOperator();
    } else if (StringUtils.equals(operatorToken, "-")) {
      mathOperator = new SubtractionOperator();
    } else if (StringUtils.equals(operatorToken, "*")) {
      mathOperator = new MultiplicationOperator();
    } else if (StringUtils.equals(operatorToken, "/")) {
      mathOperator = new QuotientOperator();
    } else {
      throw new InvalidMathOperatorException();
    }

    return mathOperator;
  }
}
