import calculator.BinaryArithmeticOperation;
import calculator.IntegerArithmeticCalculator;
import calculator.ProxyIntegerArithmeticCalculator;
import exceptions.OperatorOutOfMaximumValueLimitException;
import exceptions.OperatorOutOfMinimumValueLimitException;
import exceptions.ResultOutOfMaximumValueLimitException;
import exceptions.ResultOutOfMinimumValueLimitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import validators.CalculatorValidator;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ProxyCalculatorTests {
  private ProxyIntegerArithmeticCalculator proxyIntegerCalculator;

  @BeforeEach
  public void setup() {
    proxyIntegerCalculator =
        new ProxyIntegerArithmeticCalculator(
            new IntegerArithmeticCalculator(), new CalculatorValidator(-100, 100));
  }

  @Test
  public void addReturningPositiveResult() {
    try {
      Assertions.assertEquals(
          4, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.ADDITION, 2, 2));
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
      Assertions.assertEquals(
          -3, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.ADDITION, 2, -5));
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
      Assertions.assertEquals(
          2, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.SUBTRACTION, 5, 3));
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
      Assertions.assertEquals(
          -2,
          proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.SUBTRACTION, 3, 5));
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
  public void addWithOperatorOutOfMinimumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            OperatorOutOfMinimumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.ADDITION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit() - 1,
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit()));
  }

  @Test
  public void subtractWithOperatorOutOfMinimumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            OperatorOutOfMinimumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.SUBTRACTION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit() - 1,
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit()));
  }

  @Test
  public void addWithOperatorOutOfMaximumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            OperatorOutOfMaximumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.ADDITION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit(),
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit() + 1));
  }

  @Test
  public void subtractWithOperatorOutOfMaximumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            OperatorOutOfMaximumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.SUBTRACTION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit(),
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit() + 1));
  }

  @Test
  public void addWithResultOutOfMinimumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            ResultOutOfMinimumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.ADDITION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit(),
                    -1));
  }

  @Test
  public void subtractWithResultOutOfMinimumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            ResultOutOfMinimumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.SUBTRACTION,
                    proxyIntegerCalculator.getCalculatorValidator().getMinimumValueLimit(),
                    1));
  }

  @Test
  public void addWithResultOutOfMaximumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            ResultOutOfMaximumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.ADDITION,
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit(),
                    1));
  }

  @Test
  public void subtractWithResultOutOfMaximumValueLimit() {
    Exception exception =
        Assertions.assertThrows(
            ResultOutOfMaximumValueLimitException.class,
            () ->
                proxyIntegerCalculator.doBinaryOperation(
                    BinaryArithmeticOperation.SUBTRACTION,
                    proxyIntegerCalculator.getCalculatorValidator().getMaximumValueLimit(),
                    -1));
  }

  @Test
  public void multiplyReturningPositiveResult() {
    try {
      Assertions.assertEquals(
          56,
          proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.MULTIPLICATION, 7, 8));
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
  public void quotientReturningPositiveResult() {
    try {
      Assertions.assertEquals(
          2, proxyIntegerCalculator.doBinaryOperation(BinaryArithmeticOperation.QUOTIENT, 6, 3));
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
