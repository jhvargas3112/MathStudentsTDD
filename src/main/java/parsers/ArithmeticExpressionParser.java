package parsers;

import validators.ArithmeticExpressionValidator;
import exceptions.InvalidArithmeticExpressionException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class ArithmeticExpressionParser {
  public ArrayList<ArithmeticExpressionToken> parse(String arithmeticExpression)
      throws InvalidArithmeticExpressionException {
    if (!new ArithmeticExpressionValidator().arithmeticExpressionIsValid(arithmeticExpression)) {
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
