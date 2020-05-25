import Exceptions.OperatorOutOfMaximumValueLimitException;
import Exceptions.OperatorOutOfMinimumValueLimitException;
import Exceptions.ResultOutOfMaximumValueLimitException;
import Exceptions.ResultOutOfMinimumValueLimitException;
import Validators.CalculatorValidator;
import calculator.BinaryArithmeticOperation;
import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProxyCalculatorTests {
    private ProxyIntegerArithmeticCalculator proxyIntegerCalculator;

    @BeforeEach
    public void setup() {
        proxyIntegerCalculator = new ProxyIntegerArithmeticCalculator(new IntegerArithmeticCalculator(), new CalculatorValidator(-100, 100));
    }

    @Test
    public void addReturningPositiveResult() {
        try {
            Assertions.assertEquals(4, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.ADDITION, 2, 2));
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addReturningNegativeResult() {
        try {
            Assertions.assertEquals(-3, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.ADDITION, 2, -5));
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void subtractReturningPositiveResult() {
        try {
            Assertions.assertEquals(2, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.SUBTRACTION, 5, 3));
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void subtractReturningNegativeResult() {
        try {
            Assertions.assertEquals(-2, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.SUBTRACTION, 3, 5));
        } catch (OperatorOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        } catch (OperatorOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMinimumValueLimitException e) {
            e.printStackTrace();
        } catch (ResultOutOfMaximumValueLimitException e) {
            e.printStackTrace();
        }
    }
}
