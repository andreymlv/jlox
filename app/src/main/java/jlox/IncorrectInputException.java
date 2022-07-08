package jlox;

/**
 * This exception for incorrect input.
 */
public final class IncorrectInputException extends Exception {
  public IncorrectInputException(final String errorMessage) {
    super(errorMessage);
  }
}
