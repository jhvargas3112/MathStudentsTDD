package parsers;

import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;

public class SubtractionOperator extends MathOperator {
  public SubtractionOperator() {
    setToken("-");
    setPrecedence(0);
  }

  @Override
  public int resolve(
      int leftValue,
      int rightValue,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator)
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException {
    return proxyIntegerArithmeticCalculator.doBinaryOperation(
        BinaryArithmeticOperation.SUBTRACTION, leftValue, rightValue);
  }
}
