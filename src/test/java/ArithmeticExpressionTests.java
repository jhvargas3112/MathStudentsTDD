import validators.ArithmeticExpressionValidator;
import exceptions.InvalidArithmeticExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;

import java.util.ArrayList;

public class ArithmeticExpressionTests {
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
  public void simpleArithmeticExpressionWithAllOperators() {
    char[] operators = new char[] {'+', '-', '*', '/'};

    for (char operator : operators) {
      Assertions.assertTrue(
          arithmeticExpressionValidator.arithmeticExpressionIsValid("25 " + operator + " 287"));
    }
  }

  @Test
  public void simpleArithmeticExpressionWithMoreThanOneBlankSpaces() {
    Assertions.assertTrue(
        arithmeticExpressionValidator.arithmeticExpressionIsValid("25   +   287"));
  }

  @Test
  public void simpleArithmeticExpressionWithOutBlankSpaces() {
    Assertions.assertTrue(arithmeticExpressionValidator.arithmeticExpressionIsValid("25+287"));
  }

  @Test
  public void simpleWrongArithmeticExpression() {
    Assertions.assertFalse(arithmeticExpressionValidator.arithmeticExpressionIsValid("2a7"));
  }

  @Test
  public void arithmeticExpressionWithRepeatedOperator() {
    Assertions.assertFalse(arithmeticExpressionValidator.arithmeticExpressionIsValid("5 + 4 **"));
  }

  @Test
  public void complexArithmeticExpression() {
    Assertions.assertTrue(
        arithmeticExpressionValidator.arithmeticExpressionIsValid("5 + 4 * 2 / 2"));
  }

  @Test
  public void arithmeticExpressionWithIncompleteOperands() {
    Assertions.assertFalse(arithmeticExpressionValidator.arithmeticExpressionIsValid("*45-2-"));
  }

  @Test
  public void complexWrongArithmeticExpressionWithInvalidSubexpression() {
    Assertions.assertFalse(
        arithmeticExpressionValidator.arithmeticExpressionIsValid("2 + 7 - 2 a 3 b"));
  }

  @Test
  public void arithmeticExpressionWithNegativeOperand() {
    Assertions.assertTrue(arithmeticExpressionValidator.arithmeticExpressionIsValid("-7 + 1"));
  }

  @Test
  public void arithmeticExpressionWithNegativeOperandAtTheEnd() {
    Assertions.assertTrue(arithmeticExpressionValidator.arithmeticExpressionIsValid("7 - -1"));
  }

  @Test
    public void veryComplexArithmeticExpression() {
    Assertions.assertTrue(arithmeticExpressionValidator.arithmeticExpressionIsValid("-7 -  -1 * 2 / 3 +  -5"));
  }
}
