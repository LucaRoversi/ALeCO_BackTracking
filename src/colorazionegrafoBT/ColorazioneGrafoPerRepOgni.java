package colorazionegrafoBT;

/** Dato un grafo, rappresentato come matrice di adiacenza, e
 * un array di colori, rappresentati da numeri interi, a partire
 * da 0, fornisce l'elenco di sequenze (c_0,..,c_n) tali che c_i 
 * e' il colore del nodo di indice i del grafo a patto nodi 
 * adiacenti del grafo abbiano colori distinti.
 * 
 * Lo spazio degli stati e' rappresentato tramite permutazioni con
 * ripetizione dei colori disponibili che sono tanti quanti i nodi
 * del grafo. Quindi, almeno una colorazione esiste sempre.
 * Ogni livello dello spazio degli stati e' associato all'indice del 
 * nodo da colorare. Leggendo un intero ramo dello spazio degli stati 
 * si ha la tupla (c_0,..,c_n).                                      */

public class ColorazioneGrafoPerRepOgni {
	
  public static void risposte(boolean[][] grafo, int[] colori, int[] soluzione, int j) {

    if (!completa(soluzione, j)) {
      if (!rifiuta(grafo, soluzione, j)) {
        int i = 0;
        while (i < grafo.length) {
          soluzione[j] = colori[i];
          swap(colori, i, j);
          risposte(grafo, colori, soluzione, j + 1);
          swap(colori, i, j);
          i++;
        }
      } else {
        System.out.println("Rifiuta 0: " + toString(soluzione, j));        
      }
    } else {
      if (accetta(grafo, soluzione, j))
        System.out.println("Accetta: " + toString(soluzione, j));
      else
        System.out.println("Rifiuta 1: " + toString(soluzione, j));
    }
  }

  /* Un soluzione e' completa se conosciamo il colore per ogni nodo del 
   * grafo: occorre, quindi, che la soluzione sia lunga quanto un intero 
   * ramo dello spazio degli stati.                                     */
  public static boolean completa(int[] a,  int j) {
    return j == a.length;
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
      for (int i = 0; i < j & !rifiuta; i++)
        if (grafo[j - 1][i] || grafo[i][j - 1])
          rifiuta = soluzione[j - 1] == soluzione[i];
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
      for (int i = 0; i < j & accetta; i++)
        if (grafo[j - 1][i] || grafo[i][j - 1])
          accetta = soluzione[j - 1] != soluzione[i];
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
      stringa +=  soluzione[i];
    return stringa;  
  }
}