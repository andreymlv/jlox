package jlox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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

  /**
   * Read file and run.
   *
   * @param path to file
   * @throws IOException
   */
  public static void runFile(final String path) throws IOException {
    final var bytes = Files.readAllBytes(Paths.get(path));
    try {
      run(new String(bytes, Charset.defaultCharset()));
    } catch (final RuntimeErrorException e) {
      // TODO: handle exception
    }
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
      try {
        run(line);
      } catch (final RuntimeErrorException e) {
        // TODO: handle exception
      }
    }
  }

  /**
   * Evaluate expression.
   * TODO: rename to `evaluate` and return evaluated expression value as string.
   *
   * @param string expession
   */
  private static void run(final String source) throws RuntimeErrorException {
    final var scanner = new Scanner(source);
    if (scanner.hasNext()) {
      final var tokens = scanner.next().toCharArray();
      scanner.close();
      for (final var token : tokens) {
        System.out.println(token);
      }
    }
  }
}
