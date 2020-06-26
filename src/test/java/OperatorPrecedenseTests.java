import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import parsers.MathOperator;
import validators.ArithmeticExpressionValidator;

import java.util.ArrayList;

public class OperatorPrecedenseTests {
  @Test
  public void getMaxPrecedence() {
    ArithmeticExpressionParser arithmeticExpressionParser =
        new ArithmeticExpressionParser(new ArithmeticExpressionValidator());

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList<>();
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("3"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("+"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("*"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));

    MathOperator mathOperator =
        arithmeticExpressionParser.getMaxPrecedenceOperator(arithmeticExpressionTokens);

    Assertions.assertEquals("*", mathOperator.getToken());
  }
}
