import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathExpressionTests {
  private MathOperationExpressionParser mathOperationExpressionParser;

  @BeforeEach
  public void setup() {
    mathOperationExpressionParser = new MathOperationExpressionParser();
  }

  @Test
  public void getArithmeticExpressionTokens() {
    MathToken[] mathTokens = mathOperationExpressionParser.getMathTokens("2 + 2");

    Assertions.assertEquals(3, mathTokens.length);

    Assertions.assertEquals("2", mathTokens[0].getToken());
    Assertions.assertEquals("+", mathTokens[1].getToken());
    Assertions.assertEquals("2", mathTokens[2].getToken());
  }

  @Test
  public void simpleArithmeticExpressionWithAllOperators() {
    char[] operators = new char[]{'+', '-', '*', '/'};

    for (char operator : operators) {
      Assertions.assertTrue(mathOperationExpressionParser.simpleMathExpressionIsValid("25 " + operator + " 287"));
    }
  }

  @Test
  public void simpleArithmeticExpressionWithMoreThanOneBlankSpaces() {
    Assertions.assertTrue(mathOperationExpressionParser.simpleMathExpressionIsValid("25   +   287"));
  }

  @Test
  public void simpleArithmeticExpressionWithOutBlankSpaces() {
    Assertions.assertTrue(mathOperationExpressionParser.simpleMathExpressionIsValid("25+287"));
  }

  @Test
  public void complexArithmeticExpression() {
    Assertions.assertTrue(mathOperationExpressionParser.complexMathExpressionIsValid("5 + 4 * 2 / 2"));
  }
}
