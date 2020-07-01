package parsers;

import exceptions.InvalidArithmeticExpressionException;
import exceptions.InvalidMathOperatorException;
import org.apache.commons.lang3.StringUtils;
import validators.ArithmeticExpressionValidator;

import java.util.ArrayList;
import java.util.Stack;

public class ArithmeticExpressionParser {
  private ArithmeticExpressionValidator arithmeticExpressionValidator;

  public ArithmeticExpressionParser(ArithmeticExpressionValidator arithmeticExpressionValidator) {
    this.arithmeticExpressionValidator = arithmeticExpressionValidator;
  }

  public ArrayList<ArithmeticExpressionToken> parse(String arithmeticExpression)
      throws InvalidArithmeticExpressionException {
    if (!arithmeticExpressionValidator.arithmeticExpressionIsValid(arithmeticExpression)) {
      throw new InvalidArithmeticExpressionException();
    }

    ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens = new ArrayList();

    String[] arithmeticExpressionStringTokens = splitArithmeticExpression(arithmeticExpression);

    for (String arithmeticExpressionStringToken : arithmeticExpressionStringTokens) {
      arithmeticExpressionTokens.add(
          new ArithmeticExpressionToken(arithmeticExpressionStringToken));
    }

    return arithmeticExpressionTokens;
  }

  public ArrayList<String> getExpressions(String arithmeticExpression) {
    char[] arithmeticExpressionStringTokens = arithmeticExpression.toCharArray();

    ArrayList<String> expressions = new ArrayList<>();

    Stack<Character> parenthesis = new Stack<>();

    for (Character token : arithmeticExpressionStringTokens) {
      int actualExpressionIndex = expressions.size() - 1;
      if (token.equals('(')) {
        parenthesis.push(token);
        expressions.add(new String());
      } else if (token.equals(')')) {
        parenthesis.pop();
      } else {
        expressions.set(
            actualExpressionIndex, expressions.get(actualExpressionIndex).concat(token.toString()));
      }
    }

    clearEmptyExpressions(expressions);

    return expressions;
  }

  private void clearEmptyExpressions(ArrayList<String> expressions) {
    for (String expression : expressions) {
      if (StringUtils.isBlank(expression)) {
        expressions.remove(expression);
      }
    }
  }

  public MathOperator getMaxPrecedenceOperator(
      ArrayList<ArithmeticExpressionToken> arithmeticExpressionTokens)
      throws InvalidMathOperatorException {
    int precedence = -1;
    MathOperator maxPrecedenceOperator = null;

    int index = -1;

    for (ArithmeticExpressionToken arithmeticExpressionToken : arithmeticExpressionTokens) {
      index++;

      if (arithmeticExpressionToken.isOperator()) {
        MathOperator mathOperator = MathOperatorFactory.create(arithmeticExpressionToken);
        if (mathOperator.getPrecedence() > precedence) {
          precedence = mathOperator.getPrecedence();
          maxPrecedenceOperator = mathOperator;
          maxPrecedenceOperator.setIndex(index);
        }
      }
    }
    return maxPrecedenceOperator;
  }

  public String[] splitArithmeticExpression(String arithmeticExpression) {
    return StringUtils.split(arithmeticExpression);
  }

  public ArithmeticExpressionValidator getArithmeticExpressionValidator() {
    return arithmeticExpressionValidator;
  }
}
