package Util;

public class Render {
  public static void renderTable(String var1, String var2) {
    Calculador c = new Calculador();

    // cabeçalho da tabela a ser impresso no final do método
    Object[] cabecalho = new String[] {var1,var2,var1 + " v " + var2,var1 + " ^ " + var2,var1 + " -> " + var2,var1 + " <-> " + var2};
    
    // tabela para ser impressa no final do método
    final Object[][] tabela = new Boolean[4][];
    tabela[0] = new Boolean[] {true, true, c.conj(true, true), c.disj(true, true), c.impl(true, true), c.dupImpl(true, true)};
    tabela[1] = new Boolean[] {true, false, c.conj(true, false), c.disj(true, false), c.impl(true, false), c.dupImpl(true, false)};
    tabela[2] = new Boolean[] {false, true, c.conj(false, true), c.disj(false, true), c.impl(false, true), c.dupImpl(false, true)};
    tabela[3] = new Boolean[] {false, false, c.conj(false, false), c.disj(false, false), c.impl(false, false), c.dupImpl(false, false)};
    

    System.out.format("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", cabecalho);
    for (final Object[] row : tabela) {
      System.out.format("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", row);
    }
  }
}
