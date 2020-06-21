import validators.ArithmeticExpressionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithmeticExpressionValidationTests {
  private ArithmeticExpressionValidator arithmeticExpressionValidator;

  @BeforeEach
  public void setup() {
    arithmeticExpressionValidator = new ArithmeticExpressionValidator();
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
    Assertions.assertFalse(arithmeticExpressionValidator.arithmeticExpressionIsValid("25+287"));
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
    Assertions.assertTrue(
        arithmeticExpressionValidator.arithmeticExpressionIsValid("-7 -  -1 * 2 / 3 +  -5"));
  }
}
