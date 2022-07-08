package jlox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Lox interpreter.
 * TODO: Make expression type instead of string.
 */
public final class App {
  public static void main(final String[] args) throws IncorrectInputException, IOException {
    if (args.length > 1) {
      throw new IncorrectInputException("Usage: ./jlox <script>");
    } else if (args.length == 1) {
      runFile(args[0]);
    } else {
      runPromt();
    }
  }

  public static void runFile(final String path) throws IOException {
    final var bytes = Files.readAllBytes(Path.of(path));
    run(new String(bytes, Charset.defaultCharset()));
  }

  /**
   * Read Eval Print Loop.
   *
   * @throws IOException
   */
  private static void runPromt() throws IOException {
    final var input = new InputStreamReader(System.in);
    final var reader = new BufferedReader(input);
    while (true) {
      System.out.print("> ");
      final var line = reader.readLine();
      if (line == null) // EOF
        break;
      run(line);
    }
  }

  /**
   * Evaluate expression.
   * TODO: rename to `evaluate` and return evaluated expression value as string.
   *
   * @param string expession
   */
  private static void run(final String string) {
  }

}
