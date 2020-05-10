import Exceptions.*;
import Validators.CalculatorValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class IntegerArithmeticOperationsTests {
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator(new CalculatorValidator(-100, 100));
    }

    @Test
    public void addReturningPositiveResult() {
        try {
            Assertions.assertEquals(4, calculator.add(2, 2));
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addReturningNegativeResult() {
        try {
            Assertions.assertEquals(-3, calculator.add(2, -5));
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void subtractReturningPositiveResult() {
        try {
            Assertions.assertEquals(2, calculator.subtract(5, 3));
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void subtractReturningNegativeResult() {
        try {
            Assertions.assertEquals(-2, calculator.subtract(3, 5));
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculatorValidatorForAddOperation() throws OperatorOutOfMinimumValueLimitException,
            OperatorOutOfMaximumValueLimitException, ResultOutOfMinimumValueLimitException,
            ResultOutOfMaximumValueLimitException {
        CalculatorValidator calculatorValidator = mock(CalculatorValidator.class);

        calculator.setCalculatorValidator(calculatorValidator);

        int operator1 = calculatorValidator.getMinimumValueLimit() - 1;
        int operator2 = calculatorValidator.getMaximumValueLimit() + 1;

        int result = calculator.add(operator1, operator2);

        verify(calculatorValidator).validateOperatorsValueLimits(operator1, operator2);
        verify(calculatorValidator).validateResultValueLimit(result);
    }

    @Test
    public void calculatorValidatorForSubtractOperation() throws ResultOutOfMinimumValueLimitException,
            OperatorOutOfMinimumValueLimitException, ResultOutOfMaximumValueLimitException,
            OperatorOutOfMaximumValueLimitException {
        CalculatorValidator calculatorValidator = mock(CalculatorValidator.class);

        calculator.setCalculatorValidator(calculatorValidator);

        int operator1 = calculatorValidator.getMinimumValueLimit() - 1;
        int operator2 = calculatorValidator.getMaximumValueLimit() + 1;

        int result = calculator.subtract(operator1, operator2);

        verify(calculatorValidator).validateOperatorsValueLimits(operator1, operator2);
        verify(calculatorValidator).validateResultValueLimit(result);
    }

    @Test
    public void getAndSetMinimumValueLimit() {
        Assertions.assertEquals(-100, calculator.getCalculatorValidator().getMinimumValueLimit());
        calculator.getCalculatorValidator().setMinimumValueLimit(-500);
        Assertions.assertEquals(-500, calculator.getCalculatorValidator().getMinimumValueLimit());
    }

    @Test
    public void getAndSetMaximumValueLimit() {
        Assertions.assertEquals(100, calculator.getCalculatorValidator().getMaximumValueLimit());
        calculator.getCalculatorValidator().setMaximumValueLimit(500);
        Assertions.assertEquals(500, calculator.getCalculatorValidator().getMaximumValueLimit());
    }
}
