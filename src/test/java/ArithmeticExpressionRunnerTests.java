import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import parsers.ArithmeticExpressionToken;
import simplifiers.ArithmeticExpressionSimplifier;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ArithmeticExpressionRunnerTests {
  private ArithmeticExpressionRunner arithmeticExpressionRunner;

  @BeforeEach
  public void setup() {
    arithmeticExpressionRunner = new ArithmeticExpressionRunner();
  }

  @Test
  public void runAdditionActionWithArithmeticExpressionSimplifierAndProxyCalculator()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator =
        mock(ProxyIntegerArithmeticCalculator.class);
    ArithmeticExpressionSimplifier arithmeticExpressionSimplifier =
        mock(ArithmeticExpressionSimplifier.class);

    String arithmeticExpression = "2 + 2";

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList<>();

    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("+"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));

    when(arithmeticExpressionSimplifier.simplifyDoingMultiplicationsAndQuotients(
            arithmeticExpression))
        .thenReturn(arithmeticExpressionTokens);

    arithmeticExpressionRunner.setArithmeticExpressionSimplifier(arithmeticExpressionSimplifier);
    arithmeticExpressionRunner.setProxyIntegerArithmeticCalculator(
        proxyIntegerArithmeticCalculator);

    arithmeticExpressionRunner.run(arithmeticExpression);

    verify(proxyIntegerArithmeticCalculator)
        .doBinaryOperation(BinaryArithmeticOperation.ADDITION, 2, 2);
  }

  @Test
  public void runSimpleAdditionArithmeticExpression()
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException,
          InvalidArithmeticExpressionException {
    Assertions.assertEquals(4, arithmeticExpressionRunner.run("2 + 2"));
  }

  @Test
  public void runSimpleSubtractionArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    Assertions.assertEquals(-6, arithmeticExpressionRunner.run("-7 - -1"));
  }

  @Test
  public void runSimpleMultiplicationArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    Assertions.assertEquals(54, arithmeticExpressionRunner.run("9 * 6"));
  }

  @Test
  public void runSimpleQuotientArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    Assertions.assertEquals(2, arithmeticExpressionRunner.run("8 / 4"));
  }

  @Test
  public void runComplexArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    Assertions.assertEquals(9, arithmeticExpressionRunner.run("5 + 4 * 2 / 2"));
  }

  @Test
  public void runHardComplexArithmeticExpression()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    Assertions.assertEquals(-12, arithmeticExpressionRunner.run("-7 - -1 * 2 / 3 + -5"));
  }
}
