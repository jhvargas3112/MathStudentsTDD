import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parsers.ArithmeticExpressionParser;
import validators.ArithmeticExpressionValidator;

import java.util.ArrayList;

public class ArithmeticExpressionWithParenthesisTests {
  private ArithmeticExpressionParser arithmeticExpressionParser;

  @BeforeEach
  public void setup() {
    arithmeticExpressionParser =
        new ArithmeticExpressionParser(new ArithmeticExpressionValidator());
  }

  @Test
  public void getExpressionWith1Parenthesis() {
    ArrayList<String> expressions = arithmeticExpressionParser.getExpressions("(2 + 2)");

    Assertions.assertEquals(1, expressions.size());
    Assertions.assertEquals("2 + 2", expressions.get(0));
  }

  @Test
  public void getExpressionWithNestedParenthesis() {
    ArrayList<String> expressions = arithmeticExpressionParser.getExpressions("((2) + 2)");

    Assertions.assertEquals(1, expressions.size());
    Assertions.assertEquals("2 + 2", expressions.get(0));
  }

  @Test
  public void getNestedExpressions() {
    ArrayList<String> expressions = arithmeticExpressionParser.getExpressions("((2 + 1) + 2)");

    Assertions.assertEquals(3, expressions.size());

    for (String expression : expressions) {
      if (!StringUtils.equals(expression, "2 + 1")
          && !StringUtils.equals(expression, "+")
          && !StringUtils.equals(expression, "2")) {
        Assertions.fail("Wrong expression split.");
      }
    }
  }
}
