package subsetsumBT;

/** Dato un insieme X, rappresentato da un array insieme, ed un 
 * valore sommaCercata, individua tutti i sottoinsiemi di X i 
 * cui elementi, sommati, ammontano a sommaCercata.
 * 
 * Lo spazio degli stati e' costruito generando in 
 * soluzione[0..insieme.length) tutti i sottoinsiemi (suffisso 
 * "Sot") di insieme[0..insieme.length).                        */

public class SubsetSumSotOgni {

  public static void risposte(int[] insieme, int sommaCercata, 
      boolean[] soluzione, int j) {

    if (!completa(soluzione, j)) {
      if (!rifiuta(insieme, sommaCercata, soluzione, j)) {
        soluzione[j] = true;
        risposte(insieme, sommaCercata, soluzione, j + 1);
        soluzione[j] = !soluzione[j];
        risposte(insieme, sommaCercata, soluzione, j + 1);
      } 
    } else 
      if (accetta(insieme, sommaCercata, soluzione)) 
        System.out.println(toString(insieme, sommaCercata, soluzione));
  }

  private static boolean completa(boolean[] soluzione, int j) {
    return soluzione.length == j;
  }

  /* La condizione di rifiuto e' in due fasi, quando j < insieme.length,
   * cioe' quando soluzione non contiene ancora tutti i possibili 
   * elementi dell'insieme.
   * Si rifiuta se la somma degli elementi gia' in soluzione[0..j)
   * sfora il valore sommaCercata.                                     
   * Se, invece la somma degli elementi in soluzione[0..j) e'
   * inferiore a sommaCercata, non e' detto che, sommati a tutti
   * quelli che potremmo ancora mettere in soluzione[0..j) possano
   * far raggiungere sommaCercata. Si rifiuta anche in quel caso.    */ 
  private static boolean rifiuta(int[] insieme, int sommaCercata, 
                                          boolean[] soluzione, int j) {

    /* La somma degli elementi in soluzione[0..j) supera sommaCercata? */
    int somma = 0;
    for (int i = 0; i < j; i++)
      somma += (soluzione[i]) ? insieme[i] : 0;
    
    /* L'estensione di soluzione[0..j) con gli elementi non ancora 
     * usati permettono di arrivare ad almeno sommaCercata.           */
    int estensioneSomma = 0;
    if (somma < sommaCercata)
      for (int i = j; i < soluzione.length; i++)
        estensioneSomma += insieme[i];
    
    return (somma > sommaCercata) || (somma + estensioneSomma < sommaCercata);
  }

  /* Quando soluzione[0..j) e' completa si verifica se la somma degli
   * elementi che essa contiene ammonta a sommaCercata.                */ 
  public static boolean accetta(int[] insieme, int sommaCercata, 
      boolean[] soluzione) {
    int somma = 0;
    for (int i = 0; i < soluzione.length ; i++)
      somma += (soluzione[i]) ? insieme[i] : 0;
    return somma == sommaCercata;
  }

  private static String toString(int[] insieme, int sommaCercata, 
      boolean[] risposta) {
    String stringa = "";
    for (int i = 0; i < risposta.length; i++)
      stringa += ((risposta[i]) ? insieme[i] : 0) + "+";
    return stringa.substring(0, stringa.length() - 1) 
         + " == " + sommaCercata;
  }
}