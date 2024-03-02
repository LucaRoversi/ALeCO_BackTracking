package motivazionaliBT;

/** Sia dato un array di interi a.
 * L'ordinamento si a[0 ... a.length) puo' essere pensato come ricerca 
 * esaustiva di una risposta nello spazio di tutte le possibili permutazioni 
 * di a:
 * la ricerca visita tutte le permutazioni e stampa solo quella
 * che soddisfa il criterio di accettazione:
 * 
 *               a [k] <= a [k + 1] per ogni 0 <= k < a.length-1.           */

import java.util.Arrays;

public class OrdinamentoPer {

  public static boolean ordinamento(int[] a, int j) {

    if (!completa(a, j)) {
      if (!rifiuta(a, j)) {
        boolean ordinato = false;
        int i = j;
        while (i < a.length && !ordinato) {
          swap(a, i, j);
          ordinato = ordinamento(a, j + 1);
          swap(a, i, j);
          i++;
        }
        return ordinato;
      } else {
        return false;
      }
    } else {
      boolean accetta = accetta(a, j);
      if (accetta)
        risposta(a, j);
      return accetta;
    }
  }

  /*
   * La precondizione di applicazione e' che j == a.length, ovvero abbiamo
   * completato la soluzione in a[0..j) che coincide con a[0..a.length) 
   * e che puo' contenere una risposta, ovvero tutti gli elementi ordinati 
   * in ordine non decrescente.
   * Siccome siamo arrivati sino a questo punto, a[0..a.length-2] deve
   * necessariamente essere ordinata, altrimenti l'avremmo gia' scartata. 
   * Quindi, se a.length e' almeno 2, e' necessario controllare che 
   * l'ultimo elemento inserito, ovvero a[a.length-1] sia nell'ordine giusto 
   * rispetto ad a[a.length-2]. Accettare in questo punto, e' confermare che
   * a[0]<=a[1]<=..<=a[a.length-2]<=a[a.length-1], ovvero che siamo di fronte 
   * ad una risposta.                                                        */
  public static boolean accetta(int[] a, int j) {
    return 2 <= j && a[j - 2] <= a[j - 1];
  }

  /* Stampa la risposta .                                                  */
  public static void risposta(int[] a, int j) {
    System.out.println(Arrays.toString(a));
  }

  /* Una soluzione e' completa quando include tutti gli elementi.          */
  public static boolean completa(int[] a, int j) {
    return j == a.length;
  }

  /* La precondizione di applicazione e' che j < a.length, ovvero non 
   * abbiamo una soluzione completa.
   *  
   * Rifiuta se gli ultimi due elementi nella soluzione sono fuori ordine. */
  public static boolean rifiuta(int[] a, int j) {
    return 2 <= j && a[j - 2] > a[j - 1];
  }

  public static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}