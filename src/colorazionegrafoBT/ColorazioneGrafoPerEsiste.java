package colorazionegrafoBT;

/** Dato un grafo, rappresentato come matrice di adiacenza, e
 * un array di colori, rappresentati da numeri interi, restituisce 
 * una sequenza (c_0,..,c_n) di colori con n pari al minimo necessario
 * per colorare tutti i nodi del grafo, a patto che i nodi adiacenti 
 * nel grafo abbiano colori distinti.
 * 
 * Lo spazio degli stati e' rappresentato tramite permutazioni con
 * ripetizione (suffisso "Per") dei colori disponibili che sono tanti 
 * quanti i nodi del grafo.
 * Quindi, almeno una colorazione esiste sempre, siccome, alla peggio,
 * c'e' un colore per nodo.
 * Ogni livello dello spazio degli stati e' associato all'indice del 
 * nodo da colorare. Leggendo un intero ramo dello spazio degli stati 
 * si ha la tupla (c_0,..,c_n) di colori.                             */

public class ColorazioneGrafoPerEsiste {

  public static boolean risposta(boolean[][] grafo, int[] colori, 
      int[] soluzione, int j) {

    if (!completa(soluzione, j)) {
      if (!rifiuta(grafo, soluzione, j)) {
        boolean acetta = false;
        int i = 0;
        while (i < grafo.length && !acetta) {
          soluzione[j] = colori[i];
          swap(colori, i, j);
          acetta = risposta(grafo, colori, soluzione, j + 1);
          swap(colori, i, j);
          i++;
        }
        return acetta;
      } else 
        return false;
    } else {
      boolean accetta = accetta(grafo, soluzione, j);
      if (accetta)
        System.out.println(toString(soluzione, j));
      return accetta;
    }
  }

  /* Un soluzione e' completa se conosciamo il colore per ogni nodo del grafo:
   * occorre, quindi, che la soluzione sia lunga quanto un intero ramo dello
   * spazio degli stati.                                                       */
  public static boolean completa(int[] soluzione, int j) {
    return j == soluzione.length;
  }

  /* Ha senso rifiutare se il grafo ha almeno due nodi e sono stati colorati
   * almeno due nodi.
   * Altrimenti, il grafo e' ovviamente colorabile.
   * Avendo colorato almeno due nodi, se l'ultimo inserito in soluzione[0..j)
   * e' adiacente a qualche altro nodo gia' in soluzione[0..j-1), ed ha lo 
   * stesso colore, rifiuta.                                                  */
  private static boolean rifiuta(boolean[][] grafo, int[] soluzione, int j) {
    boolean rifiuta = false;
    if (grafo.length > 1 && 2 <= j) {
      for (int i = 0; i < j & !rifiuta; i++) // per ogni nodo già inserito
        if (grafo[j - 1][i] || grafo[i][j - 1]) // verifica adiacenza
          rifiuta = soluzione[j - 1] == soluzione[i]; // colore uguale?
    }
    return rifiuta;
  }

  /* Ha senso chiedersi se accettare se il grafo ha almeno due nodi e sono 
   * stati colorati almeno due nodi.
   * Altrimenti, il grafo e' ovviamente colorabile.
   * Avendo gia' colorato almeno due nodi, se l'ultimo inserito in 
   * soluzione[0..j) e' adiacente a qualche altro nodo gia' in soluzione[0..j-1), 
   * ma ha colore diverso, accetta.                                             */
  public static boolean accetta(boolean[][] grafo, int[] soluzione, int j) {
    boolean accetta = true ;
    if (grafo.length > 1 && 2 <= j) {
      for (int i = 0; i < j & accetta; i++) // per ogni nodo già inserito
        if (grafo[j - 1][i] || grafo[i][j - 1]) // verifica adiacenza
          accetta = soluzione[j - 1] != soluzione[i]; // colore uguale?
    }
    return accetta;
  }

  public static void swap(int[] soluzione, int i, int j) {
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