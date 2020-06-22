package simplifiers;

import calculator.BinaryArithmeticOperation;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;

import java.util.ArrayList;

public class ArithmeticExpressionSimplifier {
  private ArithmeticExpressionParser arithmeticExpressionParser;
  private ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator;

  public ArithmeticExpressionSimplifier(
      ArithmeticExpressionParser arithmeticExpressionParser,
      ProxyIntegerArithmeticCalculator proxyIntegerArithmeticCalculator) {
    this.arithmeticExpressionParser = arithmeticExpressionParser;
    this.proxyIntegerArithmeticCalculator = proxyIntegerArithmeticCalculator;
  }

  /**
   * O(n) time complexity.
   *
   * @param arithmeticExpression
   * @return
   * @throws InvalidArithmeticExpressionException
   * @throws ResultOutOfMinimumValueLimitException
   * @throws OperatorOutOfMinimumValueLimitException
   * @throws ResultOutOfMaximumValueLimitException
   * @throws OperatorOutOfMaximumValueLimitException
   */
  public ArrayList<ArithmeticExpressionToken> simplifyDoingMultiplications(
      String arithmeticExpression)
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionParser.parse(arithmeticExpression);

    ArrayList<Integer> indexOfMultiplicationOperators =
        getIndexOfMultiplicationOperators(arithmeticExpressionTokens);

    int i = 0;
    int j = 0;
    int nextOffsetForOperatorIndex = 0;

    if (!indexOfMultiplicationOperators.isEmpty()) {
      j = indexOfMultiplicationOperators.get(i) - nextOffsetForOperatorIndex;
    }

    while (i < indexOfMultiplicationOperators.size()) {
      if (arithmeticExpressionTokens.get(j).isMultiplicationOperator()) {
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
      }

      i++;
      nextOffsetForOperatorIndex = nextOffsetForOperatorIndex + 2;

      if (i < indexOfMultiplicationOperators.size()) {
        j = indexOfMultiplicationOperators.get(i) - nextOffsetForOperatorIndex;
      }
    }

    return arithmeticExpressionTokens;
  }

  public ArrayList<ArithmeticExpressionToken> simplifyDoingMultiplicationsAndQuotients(
      String arithmeticExpression)
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        simplifyDoingMultiplications(arithmeticExpression);

    ArrayList<Integer> indexOfQuotientOperators =
        getIndexOfQuotientOperators(arithmeticExpressionTokens);

    int i = 0;
    int j = 0;
    int nextOffsetForOperatorIndex = 0;

    if (!indexOfQuotientOperators.isEmpty()) {
      j = indexOfQuotientOperators.get(i) - nextOffsetForOperatorIndex;
    }

    while (i < indexOfQuotientOperators.size()) {
      if (arithmeticExpressionTokens.get(j).isQuotientOperator()) {
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
      nextOffsetForOperatorIndex = nextOffsetForOperatorIndex + 2;

      if (i < indexOfQuotientOperators.size()) {
        j = indexOfQuotientOperators.get(i) - nextOffsetForOperatorIndex;
      }
    }

    return arithmeticExpressionTokens;
  }

  private ArrayList<Integer> getIndexOfMultiplicationOperators(
      ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens) {
    ArrayList<Integer> filteredArithmeticExpressionTokens = new ArrayList<>();

    for (int i = 0; i < arithmeticExpressionTokens.size(); i++) {
      ArithmeticExpressionToken arithmeticExpressionToken = arithmeticExpressionTokens.get(i);

      if (arithmeticExpressionToken.isMultiplicationOperator()) {
        filteredArithmeticExpressionTokens.add(i);
      }
    }

    return filteredArithmeticExpressionTokens;
  }

  private ArrayList<Integer> getIndexOfQuotientOperators(
      ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens) {
    ArrayList<Integer> filteredArithmeticExpressionTokens = new ArrayList<>();

    for (int i = 0; i < arithmeticExpressionTokens.size(); i++) {
      ArithmeticExpressionToken arithmeticExpressionToken = arithmeticExpressionTokens.get(i);

      if (arithmeticExpressionToken.isQuotientOperator()) {
        filteredArithmeticExpressionTokens.add(i);
      }
    }

    return filteredArithmeticExpressionTokens;
  }
}
