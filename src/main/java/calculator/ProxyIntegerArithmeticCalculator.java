package calculator;

import Exceptions.OperatorOutOfMaximumValueLimitException;
import Exceptions.OperatorOutOfMinimumValueLimitException;
import Exceptions.ResultOutOfMaximumValueLimitException;
import Exceptions.ResultOutOfMinimumValueLimitException;
import Validators.CalculatorValidator;

public class ProxyIntegerArithmeticCalculator {
    private IntegerArithmeticCalculator integerArithmeticCalculator;
    private CalculatorValidator calculatorValidator;

    public ProxyIntegerArithmeticCalculator(IntegerArithmeticCalculator integerCalculator, CalculatorValidator calculatorValidator) {
        this.integerArithmeticCalculator = integerCalculator;
        this.calculatorValidator = calculatorValidator;
    }

    public int doBinaryOperation(BinaryArithmeticOperation binaryArithmeticOperation, int operator1, int operator2) throws ResultOutOfMinimumValueLimitException,
            OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException, OperatorOutOfMaximumValueLimitException {
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
}
