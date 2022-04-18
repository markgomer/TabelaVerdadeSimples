package Util;

import java.io.*;
import java.nio.charset.*;

public class UI {
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
      System.out.println("UI.readString: " + ioe.getMessage());
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

  public static String readLine() {
    String s = "";
    try {
      char tmp = (char) in.read();
      while (tmp != '\n' && tmp != (char) -1) {
        if (tmp != '\r')
          s += tmp;
        tmp = (char) in.read();
      }
    } catch (IOException ioe) {
      System.out.println("UI.readLine: " + ioe.getMessage());
    }
    return s;
  }

  public static String readLine(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readLine();
  }

  public static char readChar() {
    char resp = ' ';
    try {
      resp = (char) in.read();
    } catch (Exception e) {
    }
    return resp;
  }

  public static char readChar(String str) {
    try {
      PrintStream out = new PrintStream(System.out, true, charset);
      out.print(str);
    } catch (UnsupportedEncodingException e) {
      System.out.println("Erro: charset invalido");
    }
    return readChar();
  }

  public static void pause() {
    try {
      in.read();
    } catch (Exception e) {
    }
  }

}