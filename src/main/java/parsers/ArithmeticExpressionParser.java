package parsers;

import exceptions.InvalidArithmeticExpressionException;
import exceptions.InvalidMathOperatorException;
import org.apache.commons.lang3.StringUtils;
import validators.ArithmeticExpressionValidator;

import java.util.ArrayList;

public class ArithmeticExpressionParser {
  private ArithmeticExpressionValidator arithmeticExpressionValidator;

  public ArithmeticExpressionParser(ArithmeticExpressionValidator arithmeticExpressionValidator) {
    this.arithmeticExpressionValidator = arithmeticExpressionValidator;
  }

  public ArrayList<ArithmeticExpressionToken> parse(String arithmeticExpression)
      throws InvalidArithmeticExpressionException {
    if (!arithmeticExpressionValidator.arithmeticExpressionIsValid(arithmeticExpression)) {
      throw new InvalidArithmeticExpressionException();
    }

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList();

    String[] arithmeticExpressionStringTokens = splitArithmeticExpression(arithmeticExpression);

    for (String arithmeticExpressionStringToken : arithmeticExpressionStringTokens) {
      arithmeticExpressionTokens.add(
          new ArithmeticExpressionToken(arithmeticExpressionStringToken));
    }

    return arithmeticExpressionTokens;
  }

  public MathOperator getMaxPrecedenceOperator(
      ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens)
      throws InvalidMathOperatorException {
    int precedence = -1;
    MathOperator maxPrecedenceOperator = null;

    int index = -1;

    for (ArithmeticExpressionToken arithmeticExpressionToken : arithmeticExpressionTokens) {
      index++;

      if (arithmeticExpressionToken.isOperator()) {
        MathOperator mathOperator = MathOperatorFactory.create(arithmeticExpressionToken);
        if (mathOperator.getPrecedence() > precedence) {
          precedence = mathOperator.getPrecedence();
          maxPrecedenceOperator = mathOperator;
          maxPrecedenceOperator.setIndex(index);
        }
      }
    }
    return maxPrecedenceOperator;
  }

  public String[] splitArithmeticExpression(String arithmeticExpression) {
    return StringUtils.split(arithmeticExpression);
  }

  public ArithmeticExpressionValidator getArithmeticExpressionValidator() {
    return arithmeticExpressionValidator;
  }
}
