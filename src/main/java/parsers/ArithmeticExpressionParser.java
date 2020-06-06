package parsers;

import exceptions.InvalidArithmeticExpressionException;
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
    if (arithmeticExpressionValidator.arithmeticExpressionIsValid(arithmeticExpression)) {
      throw new InvalidArithmeticExpressionException();
    }

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList();

    arithmeticExpression = StringUtils.deleteWhitespace(arithmeticExpression);
    char[] chars = arithmeticExpression.toCharArray();

    for (char arithmeticExpressionToken : chars) {
      arithmeticExpressionTokens.add(
          new ArithmeticExpressionToken(Character.toString(arithmeticExpressionToken)));
    }

    return arithmeticExpressionTokens;
  }
}
