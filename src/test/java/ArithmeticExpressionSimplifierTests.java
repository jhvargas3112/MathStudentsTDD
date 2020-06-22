import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import parsers.ArithmeticExpressionToken;
import simplifiers.ArithmeticExpressionSimplifier;
import validators.ArithmeticExpressionValidator;
import validators.CalculatorValidator;

import java.util.ArrayList;

public class ArithmeticExpressionSimplifierTests {
  private ArithmeticExpressionSimplifier arithmeticExpressionSimplifier;

  @BeforeEach
  public void setup() {
    arithmeticExpressionSimplifier =
        new ArithmeticExpressionSimplifier(
            new ArithmeticExpressionParser(new ArithmeticExpressionValidator()),
            new ProxyIntegerArithmeticCalculator(
                new IntegerArithmeticCalculator(),
                new CalculatorValidator(Integer.MIN_VALUE, Integer.MAX_VALUE)));
  }

  @Test
  public void simpleSimplificationDoingMultiplications()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplications("5 + 4 * 3");

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("12", arithmeticExpressionTokens.get(2).getToken());
  }

  @Test
  public void complexSimplificationDoingMultiplications()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplications("5 + 4 * 3 - 2 / 2");

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("12", arithmeticExpressionTokens.get(2).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(3).getToken());
    Assertions.assertEquals("2", arithmeticExpressionTokens.get(4).getToken());
    Assertions.assertEquals("/", arithmeticExpressionTokens.get(5).getToken());
    Assertions.assertEquals("2", arithmeticExpressionTokens.get(6).getToken());
  }

  @Test
  public void simpleSimplificationDoingMultiplicationsAndQuotients()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplicationsAndQuotients("5 + 4 * 2 / 2");

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("4", arithmeticExpressionTokens.get(2).getToken());
  }

  @Test
  public void complexSimplificationDoingMultiplicationsAndQuotients()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplicationsAndQuotients(
            "5 + 4 * 2 / 2 - 5 * 3 * 7");

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("4", arithmeticExpressionTokens.get(2).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(3).getToken());
    Assertions.assertEquals("105", arithmeticExpressionTokens.get(4).getToken());
  }

  @Test
  public void simpleExpressionWithoutMultiplicationsOrQuotients()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
      OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
      OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplications("2 + 2");

    Assertions.assertEquals("2", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("2", arithmeticExpressionTokens.get(2).getToken());
  }

  @Test
  public void complexExpressionWithoutMultiplicationsOrQuotients()
      throws InvalidArithmeticExpressionException, ResultOutOfMinimumValueLimitException,
          OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
          OperatorOutOfMaximumValueLimitException {
    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens =
        arithmeticExpressionSimplifier.simplifyDoingMultiplicationsAndQuotients(
            "5 + 4 - 2 + 2 - 5 + 3 - 7");

    Assertions.assertEquals("5", arithmeticExpressionTokens.get(0).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(1).getToken());
    Assertions.assertEquals("4", arithmeticExpressionTokens.get(2).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(3).getToken());
    Assertions.assertEquals("2", arithmeticExpressionTokens.get(4).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(5).getToken());
    Assertions.assertEquals("2", arithmeticExpressionTokens.get(6).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(7).getToken());
    Assertions.assertEquals("5", arithmeticExpressionTokens.get(8).getToken());
    Assertions.assertEquals("+", arithmeticExpressionTokens.get(9).getToken());
    Assertions.assertEquals("3", arithmeticExpressionTokens.get(10).getToken());
    Assertions.assertEquals("-", arithmeticExpressionTokens.get(11).getToken());
    Assertions.assertEquals("7", arithmeticExpressionTokens.get(12).getToken());
  }
}
