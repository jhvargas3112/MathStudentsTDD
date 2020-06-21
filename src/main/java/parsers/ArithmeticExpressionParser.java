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

  public String[] splitArithmeticExpression(String arithmeticExpression) {
    return StringUtils.splitByCharacterType(StringUtils.deleteWhitespace(arithmeticExpression));
  }

  public ArithmeticExpressionValidator getArithmeticExpressionValidator() {
    return arithmeticExpressionValidator;
  }

  public void setArithmeticExpressionValidator(
      ArithmeticExpressionValidator arithmeticExpressionValidator) {
    this.arithmeticExpressionValidator = arithmeticExpressionValidator;
  }
}
