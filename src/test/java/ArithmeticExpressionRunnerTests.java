import exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithmeticExpressionRunnerTests {
  private ArithmeticExpressionRunner arithmeticExpressionRunner;

  @BeforeEach
  public void setup() {
    arithmeticExpressionRunner = new ArithmeticExpressionRunner();
  }

  @Test
  public void runSimpleAdditionArithmeticExpression()
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException,
          InvalidArithmeticExpressionException, InvalidMathOperatorException {
    Assertions.assertEquals(4, arithmeticExpressionRunner.run("2 + 2"));
  }

  @Test
  public void runSimpleSubtractionArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {
    Assertions.assertEquals(-6, arithmeticExpressionRunner.run("-7 - -1"));
  }

  @Test
  public void runSimpleMultiplicationArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {
    Assertions.assertEquals(54, arithmeticExpressionRunner.run("9 * 6"));
  }

  @Test
  public void runSimpleQuotientArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {
    Assertions.assertEquals(2, arithmeticExpressionRunner.run("8 / 4"));
  }

  @Test
  public void runComplexArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {
    Assertions.assertEquals(9, arithmeticExpressionRunner.run("5 + 4 * 2 / 2"));
  }

  @Test
  public void runComplexArithmeticExpressionWithAllOperators()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {
    Assertions.assertEquals(-12, arithmeticExpressionRunner.run("-7 - -1 * 2 / 3 + -5"));
  }
}
