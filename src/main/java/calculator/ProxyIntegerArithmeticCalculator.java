package calculator;

import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;
import validators.CalculatorValidator;

public class ProxyIntegerArithmeticCalculator {
  private IntegerArithmeticCalculator integerArithmeticCalculator;
  private CalculatorValidator calculatorValidator;

  public ProxyIntegerArithmeticCalculator(
      IntegerArithmeticCalculator integerCalculator, CalculatorValidator calculatorValidator) {
    this.integerArithmeticCalculator = integerCalculator;
    this.calculatorValidator = calculatorValidator;
  }

  public int doBinaryOperation(
      BinaryArithmeticOperation binaryArithmeticOperation, int operator1, int operator2)
      throws ResultOutOfMinimumValueLimitException, OperatorOutOfMinimumValueLimitException,
          ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException {
    calculatorValidator.validateOperatorsValueLimits(operator1, operator2);

    int result = 0;

    switch (binaryArithmeticOperation) {
      case ADDITION:
        result = integerArithmeticCalculator.add(operator1, operator2);
        break;
      case SUBTRACTION:
        result = integerArithmeticCalculator.subtract(operator1, operator2);
        break;
    }

    calculatorValidator.validateResultValueLimit(result);

    return result;
  }

  public IntegerArithmeticCalculator getIntegerArithmeticCalculator() {
    return integerArithmeticCalculator;
  }

  public void setIntegerArithmeticCalculator(
      IntegerArithmeticCalculator integerArithmeticCalculator) {
    this.integerArithmeticCalculator = integerArithmeticCalculator;
  }

  public CalculatorValidator getCalculatorValidator() {
    return calculatorValidator;
  }

  public void setCalculatorValidator(CalculatorValidator calculatorValidator) {
    this.calculatorValidator = calculatorValidator;
  }
}
