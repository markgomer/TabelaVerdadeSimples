package Util;

public class Render {
  public static void renderTable(String var1, String var2) {
    final Object[][] tabela = new String[5][];
    tabela[0] = new String[] {var1,var2,var1 + " v " + var2,var1 + " ^ " + var2,var1 + " -> " + var2,var1 + " <-> " + var2};
    tabela[1] = new String[] {"V", "V", "V", "V", "V", "V"};
    tabela[2] = new String[] {"V", "F", "V", "F", "F", "F"};
    tabela[3] = new String[] {"F", "V", "V", "F", "V", "F"};
    tabela[4] = new String[] {"F", "F", "F", "F", "V", "V"};
    
    for (final Object[] row : tabela) {
      System.out.format("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", row);
      System.out.println("-----");
    }
  }
}
