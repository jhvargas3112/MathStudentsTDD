package parsers;

import org.apache.commons.lang3.StringUtils;

public class MathOperator {
  private String token;
  private int precedence;
  private int index;

  public MathOperator(String token, int precedence) {
    this.token = token;
    this.precedence = precedence;
  }

  public int resolve(int leftValue, int rightValue) {
    int result = 0;

    if (StringUtils.equals(token, "*")) {
      result = leftValue * rightValue;
    } else if (StringUtils.equals(token, "/")) {
      result = leftValue / rightValue;
    } else if (StringUtils.equals(token, "+")) {
      result = leftValue + rightValue;
    } else if (StringUtils.equals(token, "-")) {
      result = leftValue - rightValue;
    }

    return result;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public int getPrecedence() {
    return precedence;
  }

  public void setPrecedence(int precedence) {
    this.precedence = precedence;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
}
