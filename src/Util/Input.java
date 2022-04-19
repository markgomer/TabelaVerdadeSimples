package Util;

import java.io.*;
import java.nio.charset.*;

/**
 * Classe para receber entrada do usuário
 * Chamada na Main para alterar o nome das variáveis
 */

public class Input {
  private static BufferedReader in = new BufferedReader(
      new InputStreamReader(System.in, Charset.forName("UTF-8")));
  private static String charset = "UTF-8";

  public static String readString() {
    String s = "";
    try {
      char tmp = (char) in.read();
      while (tmp != '\n' && tmp != ' ' && tmp != '\t' && tmp != (char) -1) {
        if (tmp != '\r')
          s += tmp;
        tmp = (char) in.read();
      }
    } catch (IOException ioe) {
      System.out.println("Input.readString: " + ioe.getMessage());
    }
    return s;
  }

  public static String readString(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readString();
  }

}