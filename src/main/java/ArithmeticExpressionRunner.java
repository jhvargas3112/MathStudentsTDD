import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import org.apache.commons.lang3.StringUtils;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;

import java.util.ArrayList;

public class ArithmeticExpressionRunner {
  private ArithmeticExpressionParser arithmeticExpressionParser;
  private ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator;

  public ArithmeticExpressionRunner(
      ArithmeticExpressionParser arithmeticExpressionParser,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.arithmeticExpressionParser = arithmeticExpressionParser;
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }

  public int run(String arithmeticExpression)
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionParser.parse(arithmeticExpression);

    ArrayList<Integer> filteredArithmeticExpressionTokens = new ArrayList<>();

    for (int i = 0; i < arithmeticExpressionTokens.size(); i++) {
      if (StringUtils.equals(arithmeticExpressionTokens.get(i).getToken(), "*")
          || StringUtils.equals(arithmeticExpressionTokens.get(i).getToken(), "/")) {
        filteredArithmeticExpressionTokens.add(i);
      }
    }

    int i = 0;

    while (i < filteredArithmeticExpressionTokens.size()) {
      int j = filteredArithmeticExpressionTokens.get(i);

      if (StringUtils.equals(arithmeticExpressionTokens.get(j).getToken(), "*")) {
        arithmeticExpressionTokens.set(
            j - 1,
            new ArithmeticExpressionToken(
                String.valueOf(
                    proxyIntegerArithmeticCalculator.doBinaryOperation(
                        BinaryArithmeticOperation.MULTIPLICATION,
                        Integer.parseInt(arithmeticExpressionTokens.get(j - 1).getToken()),
                        Integer.parseInt(arithmeticExpressionTokens.get(j + 1).getToken())))));

        arithmeticExpressionTokens.remove(j);
        arithmeticExpressionTokens.remove(j);
      } else if (StringUtils.equals(arithmeticExpressionTokens.get(j).getToken(), "/")) {
        arithmeticExpressionTokens.set(
            j - 1,
            new ArithmeticExpressionToken(
                String.valueOf(
                    proxyIntegerArithmeticCalculator.doBinaryOperation(
                        BinaryArithmeticOperation.QUOTIENT,
                        Integer.parseInt(arithmeticExpressionTokens.get(j - 1).getToken()),
                        Integer.parseInt(arithmeticExpressionTokens.get(j + 1).getToken())))));

        arithmeticExpressionTokens.remove(j);
        arithmeticExpressionTokens.remove(j);
      }

      i++;

      if (i < filteredArithmeticExpressionTokens.size()) {
        filteredArithmeticExpressionTokens.set(i, filteredArithmeticExpressionTokens.get(i) - 2);
      }
    }

    int result = Integer.parseInt(arithmeticExpressionTokens.get(0).getToken());

    i = 1;

    while (i <= arithmeticExpressionTokens.size() - 2) {
      if (StringUtils.equals(arithmeticExpressionTokens.get(i).getToken(), "+")) {
        result =
            proxyIntegerArithmeticCalculator.doBinaryOperation(
                BinaryArithmeticOperation.ADDITION,
                result,
                Integer.parseInt(arithmeticExpressionTokens.get(i + 1).getToken()));

        i = i + 2;
      } else if (StringUtils.equals(arithmeticExpressionTokens.get(i).getToken(), "-")) {
        result =
            proxyIntegerArithmeticCalculator.doBinaryOperation(
                BinaryArithmeticOperation.SUBTRACTION,
                result,
                Integer.parseInt(arithmeticExpressionTokens.get(i + 1).getToken()));

        i = i + 2;
      }
    }

    return result;
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
