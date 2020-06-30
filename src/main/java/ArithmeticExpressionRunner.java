import calculator.BinaryArithmeticOperation;
import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import parsers.MathOperator;
import validators.ArithmeticExpressionValidator;
import validators.CalculatorValidator;

import java.util.ArrayList;

public class ArithmeticExpressionRunner {
  private ArithmeticExpressionParser arithmeticExpressionParser;
  private ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator;

  public ArithmeticExpressionRunner() {
    proxyIntegerArithmeticCalculator =
        new ProxyIntegerArithmeticCalculator(
            new IntegerArithmeticCalculator(),
            new CalculatorValidator(Integer.MIN_VALUE, Integer.MAX_VALUE));

    arithmeticExpressionParser =
        new ArithmeticExpressionParser(new ArithmeticExpressionValidator());
  }

  public int run(String arithmeticExpression)
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
      OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
      OperatorOutOfMaximumValueLimitException, InvalidMathOperatorException {

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionParser.parse(arithmeticExpression);

    while (arithmeticExpressionTokens.size() > 1) {
      MathOperator mathOperator =
          arithmeticExpressionParser.getMaxPrecedenceOperator(arithmeticExpressionTokens);

      int leftIntegerValue = arithmeticExpressionTokens.get(mathOperator.getIndex() - 1).intValue();
      int rightIntegerValue =
          arithmeticExpressionTokens.get(mathOperator.getIndex() + 1).intValue();

      int result =
          mathOperator.resolve(
              leftIntegerValue,
              rightIntegerValue,
              new ProxyIntegerArithmeticCalculator(
                  new IntegerArithmeticCalculator(),
                  new CalculatorValidator(Integer.MIN_VALUE, Integer.MAX_VALUE)));

      replaceArithmeticExpressionTokensWithResult(
          arithmeticExpressionTokens, mathOperator.getIndex(), result);
    }

    return Integer.parseInt(arithmeticExpressionTokens.get(0).getToken());
  }

  private void replaceArithmeticExpressionTokensWithResult(
      ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens, int index, int result) {
    arithmeticExpressionTokens.set(
        index - 1, new ArithmeticExpressionToken(String.valueOf(result)));

    arithmeticExpressionTokens.remove(index);
    arithmeticExpressionTokens.remove(index);
  }

  public ArithmeticExpressionParser getArithmeticExpressionParser() {
    return arithmeticExpressionParser;
  }

  public void setArithmeticExpressionParser(ArithmeticExpressionParser arithmeticExpressionParser) {
    this.arithmeticExpressionParser = arithmeticExpressionParser;
  }

  public ProxyIntegerArithmeticCalculator getProxyIntegerArithmeticCalculator() {
    return proxyIntegerArithmeticCalculator;
  }

  public void setProxyIntegerArithmeticCalculator(
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }
}
