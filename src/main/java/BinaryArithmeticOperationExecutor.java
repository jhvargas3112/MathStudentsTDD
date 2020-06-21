import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;

import java.util.ArrayList;

public class BinaryArithmeticOperationExecutor {
  private ArithmeticExpressionParser arithmeticExpressionParser;
  private ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator;

  public BinaryArithmeticOperationExecutor(
      ArithmeticExpressionParser arithmeticExpressionParser,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.arithmeticExpressionParser = arithmeticExpressionParser;
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }

  public int doAddition(String arithmeticExpression)
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException,
          InvalidArithmeticExpressionException {

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionParser.parse(arithmeticExpression);

    return proxyIntegerArithmeticCalculator.doBinaryOperation(
        BinaryArithmeticOperation.ADDITION,
        Integer.parseInt(arithmeticExpressionTokens.get(0).getToken()),
        Integer.parseInt(arithmeticExpressionTokens.get(2).getToken()));
  }

  public ProxyIntegerArithmeticCalculator getProxyIntegerArithmeticCalculator() {
    return proxyIntegerArithmeticCalculator;
  }

  public void setProxyIntegerArithmeticCalculator(
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }
}
