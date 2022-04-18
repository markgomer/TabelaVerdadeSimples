import Util.Render;
import Util.UI;

class Main {

  
  public static void main(String[] args) {
    // pegar variáveis 
    System.out.println("Dados de entrada: ");
    String var1 = UI.readString("Variavel 1: ");
    String var2 = UI.readString("Variavel 2: ");

    // imprimir tabela
    Render.renderTable(var1, var2);

  }
}