import calculator.BinaryArithmeticOperation;
import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import simplifiers.ArithmeticExpressionSimplifier;
import validators.ArithmeticExpressionValidator;
import validators.CalculatorValidator;

import java.util.ArrayList;

public class ArithmeticExpressionRunner {
  private ArithmeticExpressionSimplifier arithmeticExpressionSimplifier;
  private ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator;

  public ArithmeticExpressionRunner() {
    proxyIntegerArithmeticCalculator =
        new ProxyIntegerArithmeticCalculator(
            new IntegerArithmeticCalculator(),
            new CalculatorValidator(Integer.MIN_VALUE, Integer.MAX_VALUE));

    arithmeticExpressionSimplifier =
        new ArithmeticExpressionSimplifier(
            new ArithmeticExpressionParser(new ArithmeticExpressionValidator()),
            proxyIntegerArithmeticCalculator);
  }

  public int run(String arithmeticExpression)
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplicationsAndQuotients(
            arithmeticExpression);

    int result = arithmeticExpressionTokens.get(0).intValue();

    int i = 1;

    while (i <= arithmeticExpressionTokens.size() - 2) {
      ArithmeticExpressionToken arithmeticExpressionToken = arithmeticExpressionTokens.get(i);

      if (arithmeticExpressionToken.isAdditionOperator()) {
        result =
            proxyIntegerArithmeticCalculator.doBinaryOperation(
                BinaryArithmeticOperation.ADDITION,
                result,
                arithmeticExpressionTokens.get(i + 1).intValue());

      } else {
        result =
            proxyIntegerArithmeticCalculator.doBinaryOperation(
                BinaryArithmeticOperation.SUBTRACTION,
                result,
                arithmeticExpressionTokens.get(i + 1).intValue());
      }

      i = i + 2;
    }

    return result;
  }

  public ArithmeticExpressionSimplifier getArithmeticExpressionSimplifier() {
    return arithmeticExpressionSimplifier;
  }

  public void setArithmeticExpressionSimplifier(
      ArithmeticExpressionSimplifier arithmeticExpressionSimplifier) {
    this.arithmeticExpressionSimplifier = arithmeticExpressionSimplifier;
  }

  public ProxyIntegerArithmeticCalculator getProxyIntegerArithmeticCalculator() {
    return proxyIntegerArithmeticCalculator;
  }

  public void setProxyIntegerArithmeticCalculator(
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }
}
