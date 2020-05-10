package Validators;

import Exceptions.OperatorOutOfMaximumValueLimitException;
import Exceptions.OperatorOutOfMinimumValueLimitException;
import Exceptions.ResultOutOfMaximumValueLimitException;
import Exceptions.ResultOutOfMinimumValueLimitException;

public class CalculatorValidator {
    private int minimumValueLimit;
    private int maximumValueLimit;

    public CalculatorValidator(int minimumValueLimit, int maximumValueLimit) {
        this.minimumValueLimit = minimumValueLimit;
        this.maximumValueLimit = maximumValueLimit;
    }

    public void validateOperatorsValueLimits(int operator1, int operator2) throws OperatorOutOfMinimumValueLimitException,
            OperatorOutOfMaximumValueLimitException {
        if (operator1 < minimumValueLimit) {
            throw new OperatorOutOfMinimumValueLimitException(1, minimumValueLimit);
        }

        if (operator2 < minimumValueLimit) {
            throw new OperatorOutOfMinimumValueLimitException(2, minimumValueLimit);
        }

        if (operator1 > maximumValueLimit) {
            throw new OperatorOutOfMaximumValueLimitException(1, maximumValueLimit);
        }

        if (operator2 > maximumValueLimit) {
            throw new OperatorOutOfMaximumValueLimitException(2, maximumValueLimit);
        }
    }

    public void validateResultValueLimit(int result) throws ResultOutOfMinimumValueLimitException,
            ResultOutOfMaximumValueLimitException {
        if (result < getMinimumValueLimit()) {
            throw new ResultOutOfMinimumValueLimitException(minimumValueLimit);
        }

        if (result > getMaximumValueLimit()) {
            throw new ResultOutOfMaximumValueLimitException(maximumValueLimit);
        }
    }

    public int getMinimumValueLimit() {
        return minimumValueLimit;
    }

    public void setMinimumValueLimit(int minimumValueLimit) {
        this.minimumValueLimit = minimumValueLimit;
    }

    public int getMaximumValueLimit() {
        return maximumValueLimit;
    }

    public void setMaximumValueLimit(int maximumValueLimit) {
        this.maximumValueLimit = maximumValueLimit;
    }
}
