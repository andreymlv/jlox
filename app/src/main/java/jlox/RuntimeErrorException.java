package jlox;

/**
 * Runtime error exception.
 */
public class RuntimeErrorException extends Exception {
  public RuntimeErrorException() {
    super();
  }

  public RuntimeErrorException(final int line, final String where, final String message) {
    super("[line " + line + "] Error " + where + ": " + message);
  }
}
