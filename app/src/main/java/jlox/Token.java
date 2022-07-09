
package jlox;

/**
 * Token container.
 */
public final class Token {
  private final TokenType type;
  private final String lexeme;
  private final Object literal;
  private final int line;

  public Token(final TokenType type, final String lexeme, final Object literal, final int line) {
    this.type = type;
    this.lexeme = lexeme;
    this.literal = literal;
    this.line = line;
  }

  @Override
  public String toString() {
    return "Token [lexeme=" + lexeme + ", line=" + line + ", literal=" + literal + ", type=" + type + "]";
  }
}
