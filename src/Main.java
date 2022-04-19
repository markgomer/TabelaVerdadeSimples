import Util.Render;
import Util.Input;

class Main {

  
  public static void main(String[] args) {
    // pegar variáveis 
    System.out.println("Dados de entrada: ");
    String var1 = Input.readString("Variavel 1: ");
    String var2 = Input.readString("Variavel 2: ");

    // imprimir tabela
    Render.renderTable(var1, var2);

  }
}