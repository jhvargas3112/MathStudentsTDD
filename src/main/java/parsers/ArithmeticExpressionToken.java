package parsers;

import org.apache.commons.lang3.StringUtils;

public class ArithmeticExpressionToken {
  private String token;

  public ArithmeticExpressionToken(String token) {
    this.token = token;
  }

  public boolean isOperator() {
    return token.matches("[\\+\\-\\*\\/]");
  }

  public boolean isAdditionOperator() {
    return isOperator() && StringUtils.equals(token, "+");
  }

  public boolean isSubtractionOperator() {
    return isOperator() && StringUtils.equals(token, "-");
  }

  public boolean isMultiplicationOperator() {
    return isOperator() && StringUtils.equals(token, "*");
  }

  public boolean isQuotientOperator() {
    return isOperator() && StringUtils.equals(token, "/");
  }

  public Integer intValue() {
    Integer intValue = null;

    if (!isOperator()) {
      intValue = Integer.parseInt(token);
    }

    return intValue;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
