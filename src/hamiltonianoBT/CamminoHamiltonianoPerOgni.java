package hamiltonianoBT;

/** Dato un grafo, anche orientato (diretto), con m nodi elenca 
 * tutti i cammini (n_1..n_m) hamiltoniani del grafo: in 
 * (n_1..n_m) tutti i nodi sono distinti e n_{i} e' adiacente a
 * n_{i+1}.                                                     
 * 
 * L'ipotesi sulla direzionalita' degli archi si esprime dicendo 
 * che se l'arco e' (a,b), allora si puo' andare dal nodo a al 
 * nodo b, ma non vice versa.                                     */

public class CamminoHamiltonianoPerOgni {

  public static void risposte(boolean[][] grafo, int[] soluzione, int j) {
    if (!completa(soluzione, j)) {
      if (!rifiuta(grafo, soluzione, j)) {
        int i = j;
        while (i < soluzione.length) {
          swap(soluzione, i, j);
          risposte(grafo, soluzione, j + 1);
          swap(soluzione, i, j);
          i++;
        }
      } else {
        System.out.println("Rifiuta: " + toString(soluzione, j));
      }
    } else {
      if (accetta(grafo, soluzione, j))
        System.out.println("Accetta: " + toString(soluzione, j));
    }
  }

  private static boolean completa(int[] soluzione, int j) {
    return j == soluzione.length;
  }

  /* Ha senso rifiutare se il grafo contiene almeno due nodi
   * e il cammino costruito in soluzione[0..j) ha almeno due nodi.
   * Altrimenti il cammino e' ovviamente Hamiltoniano, includendo
   * anche il cammino vuoto.
   * Nel caso di almeno due nodi nel grafo ed in soluzione[0..j),
   * si rifiuta se non c'e' l'arco tra il penultimo nodo di
   * soluzione[0..j) e l'ultimo nodo in soluzione[0..j).           */
  private static boolean rifiuta(boolean[][] grafo, int[] soluzione, int j) {
    boolean rifiuta = false;
    if (grafo.length > 1 && 2 <= j) 
      rifiuta = !grafo[soluzione[j - 2]][soluzione[j - 1]];
    return rifiuta;
  }

  /* Se il grafo contiene meno di due nodi o soluzione[0..j) non ha
   * almeno due nodi il cammino e' Hamiltoniano, includendo anche 
   * il cammino vuoto.
   * Nel caso di almeno due nodi nel grafo ed in soluzione[0..j),
   * si accetta c'e' l'arco tra il penultimo nodo di soluzione[0..j) 
   * e l'ultimo nodo in soluzione[0..j).           */
  private static boolean accetta(boolean[][] grafo, int[] soluzione, int j) {
    boolean accetta = true;
    if (grafo.length > 1 && 2 <= j) 
      accetta = grafo[soluzione[j - 2]][soluzione[j - 1]];
    return accetta;
  }

  private static void swap(int[] soluzione, int i, int j) {
    int tmp = soluzione[i];
    soluzione[i] = soluzione[j];
    soluzione[j] = tmp;
  }

  private static String toString(int[] soluzione, int j) {
    String stringa = "";
    for (int i = 0; i < j; i++)
      stringa += soluzione[i];
    return stringa;
  }
}