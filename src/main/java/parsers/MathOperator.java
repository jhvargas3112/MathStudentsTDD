package parsers;

import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;

public abstract class MathOperator {
  private String token;
  private int precedence;
  private int index;

  public abstract int resolve(
      int leftValue,
      int rightValue,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator)
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public int getPrecedence() {
    return precedence;
  }

  public void setPrecedence(int precedence) {
    this.precedence = precedence;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
