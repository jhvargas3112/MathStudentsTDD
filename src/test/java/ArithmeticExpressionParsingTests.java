import exceptions.InvalidArithmeticExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import validators.ArithmeticExpressionValidator;

import java.util.ArrayList;

public class ArithmeticExpressionParsingTests {
  private ArithmeticExpressionValidator arithmeticExpressionValidator;

  @BeforeEach
  public void setup() {
    arithmeticExpressionValidator = new ArithmeticExpressionValidator();
  }

  @Test
  public void getArithmeticExpressionTokens() throws InvalidArithmeticExpressionException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        new ArithmeticExpressionParser(arithmeticExpressionValidator).parse("-5 + 5");

    Assertions.assertEquals(4, arithmeticExpressionTokens.size());

    Assertions.assertEquals("-", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("5", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(2).getToken());
    Assertions.assertEquals("5", arithmeticExpressionTokens.get(3).getToken());
  }

  @Test
  public void getTokensOfArithmeticExpressionWithMoreThanOneWhiteSpaces()
      throws InvalidArithmeticExpressionException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        new ArithmeticExpressionParser(arithmeticExpressionValidator).parse("5 -   88");

    Assertions.assertEquals(3, arithmeticExpressionTokens.size());

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("88", arithmeticExpressionTokens.get(2).getToken());
  }

  @Test
  public void getTokensOfAnInvalidArithmeticExpression() {
    Exception exception =
        Assertions.assertThrows(
            InvalidArithmeticExpressionException.class,
            () -> {
              ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
                  new ArithmeticExpressionParser(arithmeticExpressionValidator).parse("2 - 1++ 3");
            });
  }
}
