package parsers;

import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;

public class MultiplicationOperator extends MathOperator {
  public MultiplicationOperator() {
    setToken("*");
    setPrecedence(2);
  }

  @Override
  public int resolve(
      int leftValue,
      int rightValue,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator)
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException {
    return proxyIntegerArithmeticCalculator.doBinaryOperation(
        BinaryArithmeticOperation.MULTIPLICATION, leftValue, rightValue);
  }
}
