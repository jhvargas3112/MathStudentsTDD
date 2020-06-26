import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionToken;
import parsers.MathOperator;
import parsers.MathOperatorFactory;

public class MathOperatorFactoryTests {
  @Test
  public void multiplicationOperatorPrecedenceIsSetted() {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("*"));

    Assertions.assertEquals(2, mathOperator.getPrecedence());
  }

  @Test
  public void quotientOperatorPrecedenceIsSetted() {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("/"));

    Assertions.assertEquals(1, mathOperator.getPrecedence());
  }

  @Test
  public void additionOperatorPrecedenceIsSetted() {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("+"));

    Assertions.assertEquals(0, mathOperator.getPrecedence());
  }

  @Test
  public void subtractionOperatorPrecedenceIsSetted() {
    MathOperator mathOperator = MathOperatorFactory.create(new ArithmeticExpressionToken("-"));

    Assertions.assertEquals(0, mathOperator.getPrecedence());
  }
}
