package parsers;

import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;

public class QuotientOperator extends MathOperator {
  public QuotientOperator() {
    setToken("/");
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
        BinaryArithmeticOperation.QUOTIENT, leftValue, rightValue);
  }
}
