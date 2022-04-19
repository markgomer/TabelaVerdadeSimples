package Util;

public class Calculador {
  // métodos para serem chamados no momento da impressão da tabela verdade
  
  public Calculador() {}

  // calcula conjunção entre duas variáveis
  public boolean conj(boolean var1, boolean var2){
    return var1||var2;
  }
  
  // calcula disjunção entre duas variáveis
  public boolean disj(boolean var1, boolean var2){
    return var1&&var2;
  }
  
  // calcula implicação entre duas variáveis
  public boolean impl(boolean var1, boolean var2){
    return var1 ? var2 : true;
  }
  
  // calcula dupla implicação entre duas variáveis
  public boolean dupImpl(boolean var1, boolean var2){
    return !(var1^var2);
  }




}
