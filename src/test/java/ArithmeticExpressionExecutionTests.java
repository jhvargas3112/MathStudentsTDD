import calculator.BinaryArithmeticOperation;
import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import validators.ArithmeticExpressionValidator;
import validators.CalculatorValidator;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ArithmeticExpressionExecutionTests {
  @Test
  public void executeAddition()
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException,
          InvalidArithmeticExpressionException {
    BinaryArithmeticOperationExecutor binaryArithmeticOperationExecutor =
        new BinaryArithmeticOperationExecutor(
            new ArithmeticExpressionParser(new ArithmeticExpressionValidator()),
            new ProxyIntegerArithmeticCalculator(
                new IntegerArithmeticCalculator(), new CalculatorValidator(-100, 100)));

    Assertions.assertEquals(4, binaryArithmeticOperationExecutor.doAddition("2 + 2"));
  }

  @Test
  public void executeAdditionColaborationWithParserAndProxyCalculator()
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException,
          InvalidArithmeticExpressionException {
    ArithmeticExpressionParser arithmeticExpressionParser = mock(ArithmeticExpressionParser.class);

    BinaryArithmeticOperationExecutor binaryArithmeticOperationExecutor =
        new BinaryArithmeticOperationExecutor(
            arithmeticExpressionParser,
            new ProxyIntegerArithmeticCalculator(
                new IntegerArithmeticCalculator(), new CalculatorValidator(-100, 100)));

    String arithmeticExpression = "2 + 2";

    binaryArithmeticOperationExecutor.doAddition(arithmeticExpression);

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList<>();
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("+"));
    arithmeticExpressionTokens.add(new ArithmeticExpressionToken("2"));

    when(arithmeticExpressionParser.parse(arithmeticExpression))
        .thenReturn(arithmeticExpressionTokens);

    verify(arithmeticExpressionParser).parse(arithmeticExpression);
  }
}
