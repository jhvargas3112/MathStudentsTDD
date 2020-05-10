import Exceptions.*;
import Validators.CalculatorValidator;

public class Calculator {
    private CalculatorValidator calculatorValidator;

    public Calculator(CalculatorValidator calculatorValidator) {
        this.calculatorValidator = calculatorValidator;
    }

    public int add(int operator1, int operator2) throws OperatorOutOfMinimumValueLimitException,
            OperatorOutOfMaximumValueLimitException, ResultOutOfMinimumValueLimitException,
            ResultOutOfMaximumValueLimitException {
        calculatorValidator. validateOperatorsValueLimits(operator1, operator2);
        int result = operator1 + operator2;
        calculatorValidator.validateResultValueLimit(result);

        return result;
    }

    public int subtract(int operator1, int operator2) throws OperatorOutOfMinimumValueLimitException,
            OperatorOutOfMaximumValueLimitException, ResultOutOfMinimumValueLimitException,
            ResultOutOfMaximumValueLimitException {
        calculatorValidator.validateOperatorsValueLimits(operator1, operator2);
        int result = operator1 - operator2;
        calculatorValidator.validateResultValueLimit(result);

        return result;
    }

    public CalculatorValidator getCalculatorValidator() {
        return calculatorValidator;
    }

    public void setCalculatorValidator(CalculatorValidator calculatorValidator) {
        this.calculatorValidator = calculatorValidator;
    }
}
