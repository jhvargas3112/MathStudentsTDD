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
  public void getMathTokens() {
    MathToken[] mathTokens = mathOperationExpressionParser.getMathTokens("2 + 2");

    Assertions.assertEquals(3, mathTokens.length);

    Assertions.assertEquals("2", mathTokens[0].getToken());
    Assertions.assertEquals("+", mathTokens[1].getToken());
    Assertions.assertEquals("2", mathTokens[2].getToken());
  }

  @Test
  public void mathExpressionIsValidWithOnlyOneDigitOperands() {
    Assertions.assertTrue(mathOperationExpressionParser.simpleMathExpressionIsValid("2 + 2"));
  }

  @Test
  public void mathExpressionIsValidWithMoreThanOneDigitsOperands() {
    Assertions.assertTrue(mathOperationExpressionParser.simpleMathExpressionIsValid("25 + 287"));
  }
}
