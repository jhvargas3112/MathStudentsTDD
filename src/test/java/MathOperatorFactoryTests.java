import exceptions.InvalidMathOperatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionToken;
import parsers.MathOperator;
import parsers.MathOperatorFactory;

public class MathOperatorFactoryTests {
  @Test
  public void additionOperatorPrecedenceIsSetted() throws InvalidMathOperatorException {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("+"));

    Assertions.assertEquals(0, mathOperator.getPrecedence());
  }

  @Test
  public void subtractionOperatorPrecedenceIsSetted() throws InvalidMathOperatorException {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("-"));

    Assertions.assertEquals(0, mathOperator.getPrecedence());
  }

  @Test
  public void multiplicationOperatorPrecedenceIsSetted() throws InvalidMathOperatorException {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("*"));

    Assertions.assertEquals(2, mathOperator.getPrecedence());
  }

  @Test
  public void quotientOperatorPrecedenceIsSetted() throws InvalidMathOperatorException {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("/"));

    Assertions.assertEquals(1, mathOperator.getPrecedence());
  }
}
