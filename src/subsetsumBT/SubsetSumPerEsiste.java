package subsetsumBT;

/** Dato un insieme X, rappresentato da un array insieme, ed un 
 * valore sommaCercata, individua un sottoinsieme di X i 
 * cui elementi, sommati, ammontano a sommaCercata.
 * 
 * Lo spazio degli stati e' costruito generando in 
 * soluzione[0..insieme.length) tutti i sottoinsiemi (suffisso 
 * "Per") di insieme[0..insieme.length).                        */

public class SubsetSumPerEsiste {
  public static boolean risposta(int[] insieme, int sommaCercata, 
      int[] soluzione, int j) {

    if (!completa(insieme, sommaCercata, soluzione, j)) {
      if (!rifiuta(insieme, sommaCercata, soluzione, j)) {
        int i = j;
        boolean risposta = false;
        while (i < insieme.length && !risposta) {
          swap(soluzione, i, j);
          risposta = risposta(insieme, sommaCercata, soluzione, j + 1);
          swap(soluzione, i, j);
          i = i + 1;
        }
        return risposta;
      } else {
        System.out.println(toString(insieme, soluzione, j) + " != " 
               + sommaCercata + ", rifiuta.");
        return false;
      }
    } else {
      boolean accetta = accetta(insieme, sommaCercata, soluzione, j);
      if (accetta(insieme, sommaCercata, soluzione, j))
        System.out.println(toString(insieme, soluzione, j) + " == " 
               + sommaCercata + ", accetta.");
      else 
        System.out.println(toString(insieme, soluzione, j) + " != " 
               + sommaCercata + ", rifiuta.");
      return accetta;
    }
  }

  /* Lo spazio degli stati e' costituito da permutazioni di insieme[0..insieme.length).
   * La conseguenze sui metodi "completa" e "accetta" e' che "completa" ingloba "accetta". 
   * Il motivo e' che i sottoinsiemi cercati ora sono prefissi dei rami dello spazio degli
   * stati. Non possiamo sforare il numero degli elementi disponibili, ovvero insieme.length, 
   * ma la soluzione e' completa non appena contiene elementi che, sommati danno sommaCercata.  */
  private static boolean completa(int[] insieme, int sommaCercata, int[] soluzione, int j) {
    int somma = 0;
    for (int i = 0; i < j; i++)
      somma += insieme[soluzione[i]];
    return (j == insieme.length) || (somma == sommaCercata);
  }

  /* Rifiuta se la somma degli elementi in soluzione[0..j) supera sommaCercata.       */
  private static boolean rifiuta(int[] insieme, int sommaCercata, int[] soluzione, int j) {
      int somma = 0;
      for (int i = 0; i < j; i++)
        somma += insieme[soluzione[i]];
    return somma > sommaCercata;
  }

  /* Accetta se la somma degli elementi in soluzione[0..j) e' sommaCercata.       */
  public static boolean accetta(int[] insieme, int sommaCercata, int[] soluzione, int j) {
    int somma = 0;
    for (int i = 0; i < j; i++)
      somma += insieme[soluzione[i]];
    return somma == sommaCercata;
  }

  public static void swap(int[] soluzione, int i, int j) {
    int tmp = soluzione[i];
    soluzione[i] = soluzione[j];
    soluzione[j] = tmp;
  }

  private static String toString(int[] insieme, int[] soluzione, int j) {
    String stringa = "";
    for (int i = 0; i < j; i++)
      stringa += insieme[soluzione[i]] + "+";
    return stringa.substring(0, stringa.length() - 1);
  }
}