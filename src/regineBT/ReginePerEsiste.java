package regineBT;

/** Stampa la prima configurazione di n regine piazzate
 * su una scacchiera n*n in modo che nessuna sia 
 * minacciata dalle restanti.
 * 
 * Lo spazio degli stati e' generato come permutazione 
 * (suffisso "Per") di indici nell'array regine: 
 * l'elemento regina[i] indica la i-esima regina in 
 * colonna regina[i]-esima.                         */

public class ReginePerEsiste {

  public static int tentativi = 0;

  public static boolean soluzione(int[] regine, int j) {
    if (!completa(regine, j)) {
      if (!rifiuta(regine, j)) {
        boolean soluzione = false;
        int i = j;
        while (i < regine.length && !soluzione) {
          swap(regine, i, j);
          soluzione = soluzione(regine, j + 1);
          swap(regine, i, j);
          i++;
        }
        return soluzione;
      } else {
        System.out.println(toString(regine, j) + "<-- rifiuta. Tentativo " + ++tentativi);
        return false;
      }
    } else {
      boolean accetta = accetta(regine, j);
      if (accetta)
        System.out.println(toString(regine, j) + "<-- accetta. Tentativo " + ++tentativi);
      else
        System.out.println(toString(regine, j) + "<-- rifiuta. Tentativo " + ++tentativi);
      return accetta;
    }
  }


  /* Tutte le regine sono state piazzate.                                    */
  public static boolean completa(int[] regine, int j) {
    return j == regine.length;
  }

  /* Rifiuta a[0..j) se almeno due regine sono piazzate e l'ultima piazzata, cioe'
   * j-1 e' minacciata da qualcuna delle altre regine gia' piazzate, ovvero 0..j-2. */
  private static boolean rifiuta(int[] regine, int j) {
    boolean rifiuta = false;
    /* Dalla regina 0, sino alla penultima regina piazzata j-2 ... */
    for (int i = 0; i < j - 1 && !rifiuta; i++) {
      rifiuta = regine[j - 1] == regine[i] // stessa colonna?
        || Math.abs(regine[j - 1] - regine[i]) == Math.abs((j - 1) - i); // stessa diagonale? 
    }
    return rifiuta && 2 <= j;
  }

  /* Accetta se ci sono almeno due regine piazzate, oppure, essendo almeno due, 
   * accetta se l'ultima regina piazzata, cioe' j-1, non e' minacciata da alcuna 
   * delle altre gia' piazzate, ovvero 0..j-2.                               */
  public static boolean accetta(int[] regine, int j) {
    boolean accetta = true;
    for (int i = 0; i < j - 1 && accetta; i++) 
      accetta = regine[j - 1] != regine[i] // regina i e regina j-1 nella stessa colonna
        /* i e j-1 sono sulla stessa diagonale se la differenza tra le righe su 
         * cui si trovano e' identica alla differenza tra le due loro colonne    */
          && Math.abs(regine[j - 1] - regine[i]) != Math.abs((j - 1) - i);
    return regine.length <= 1 || accetta;
  }

  private static void swap(int[] regine, int i, int j) {
    int tmp = regine[i];
    regine[i] = regine[j];
    regine[j] = tmp;
  }

  private static String toString(int[] regine, int j) {
    String stringa = "";
    for (int i = 0; i < j; i++)
      stringa += "(" + i + "," + regine[i] + ")";
    return stringa;
  }
}