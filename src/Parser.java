public class Parser {
  
  // numero máximo de variáveis dentro de uma expressão booleana
  static final int max = 3;

  static int cursorPos;  // posicao do cursor de leitura
  static boolean[] valores = new boolean[max];  // array com valores dos operandos
  

  // recebe linha da expressao booleana e retorna o resultado em boolean
  static boolean calculaExpressaoBooleana(String linha) {
    boolean resp = true; // resposta será inserida nessa variável

    // identificar operacoes
    // cursorPos++ anda com o cursor para a direita da expressão
    switch(linha.charAt(cursorPos++)) {  // identifica proximo caracter
      case 'A': resp = valores[0]; // se o caracter lido for 'A', insere seu valor no array
        break;  
      case 'B': resp = valores[1];
        break;
      case 'C': resp = valores[2];
        break;  
        
      // operador = and
      // se o caracter lido for 'a', será o início de uma operação 'and'
      case 'a':
        cursorPos += 3;  // pula o "nd("
        resp = calculaExpressaoBooleana(linha);  // chamada recursiva
        while(linha.charAt(cursorPos) == ',') {  // continua lendo se encontrar uma virgula
          cursorPos++;
          // resp recebe o valor do método and(bool,bool)
          resp = and(resp, calculaExpressaoBooleana(linha));
        }
        cursorPos++;  // pula o ')'
        break;
      
      // operador = or
      // se o caracter lido for 'o', será o início de uma operação 'or'
      case 'o':  
        cursorPos += 2;  // pula o "r("
        resp = calculaExpressaoBooleana(linha);  // chamada recursiva
        while(linha.charAt(cursorPos) == ',') {  // continua lendo se encontrar uma virgula
          cursorPos++;
          resp = or(resp, calculaExpressaoBooleana(linha));  // acumulando os resultados em resp
        }
        cursorPos++;  // pula o ')'
        break;
      
      // operador = not
      // se o caracter lido for 'n', será o início de uma operação 'not'
      case 'n':  
        cursorPos += 3;  // pula o "ot("
        resp = not(calculaExpressaoBooleana(linha));  // chamada recursiva
        cursorPos++;  // pula o ')'
        break;
    }
    
    return resp;
  }


  /*
   * recebe String relativa a uma expressão booleana e
   * retorna a mesma sem os espaços em branco
   */
  static String removeEspacos(String s) {
    String semEspacos = "";  // string para retorno
    for(int i = 0; i < s.length(); i++) {  // percorre string recebida
      if(s.charAt(i) != ' ') {  // ignora espaco em branco
        semEspacos += s.charAt(i);
      } 
    }
    return semEspacos;
  }

  
  // converte inteiro recebido para true ou false
  // 0 => false
  // qualquer outro valor retorna true
  static boolean toBool(int x) {
    return x == 0 ? false : true;
  }
  
  // operacoes booleanas
  static boolean and(boolean A, boolean B)  {return A && B;}
  static boolean or(boolean A, boolean B)   {return A || B;}
  static boolean not(boolean A)             {return !A;}


  /*
   * método para determinar se deve continuar lendo expressões
   * se receber um 0, retorna true
   * qualquer outra String, retorna false
   */
  public static boolean isFim(String s){
    return (s.length() >= 1 && s.charAt(0) == '0');
  }

  public static void exibeInstrucoes() {
    System.out.println("Insira múltiplas expressões no formato:\n<numero de variaveis> <valores das variaveis (0 ou 1)> <expressão>");
    System.out.println("Separe as expressões com ENTER");
    System.out.println("Insira uma expressão apenas com \"0\" para exibir os resultados das expressões e encerrar o programa");
    System.out.println("Exemplos:\n"+ 
    "2 0 1 and(not(A) , not(B))\n" +
    "3 1 1 1 or(and(A , B , C) , and(or(A , B) , C))");
  }


}