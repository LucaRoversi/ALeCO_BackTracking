package testsBT;

import org.junit.jupiter.api.Test;

import motivazionaliBT.*;
import supportoBT.GenPair;

import java.util.Arrays;

class ValutazioniSotTest {
  /*
   * Ogni istanza (vm, va) di Pair e' associata ad una domanda in un test. La
   * componente vm e' il voto massimo per la risposta data a quella domanda. La
   * componente va e' il voto effettivamente ottenuto.
   */
  static GenPair<Integer, Float>[] bTTest = new GenPair[4];
  static GenPair<Integer, Float>[] originale = new GenPair[50];

  @Test
  void testSmall() {
    initBTTest();
    boolean[] soluzione = new boolean[bTTest.length];
    boolean[] risposta = new boolean[bTTest.length];
    ValutazioniSot.valutazioniSot(bTTest, 13, risposta, soluzione, 0);
    System.out.println("Soluzione: " + Arrays.toString(risposta));
  }

  @Test
  void test() {
    initOriginale();
    boolean[] soluzione = new boolean[originale.length];
    boolean[] risposta = new boolean[originale.length];
    ValutazioniSot.valutazioniSot(originale, 100, risposta, soluzione, 0);
    System.out.println("Soluzione: " + Arrays.toString(risposta));
  }
  
  /* Istanza ridotta del test di riferimento. */
  public static void initBTTest() {
    bTTest[0] = new GenPair<Integer, Float>( 4, 3.0f);
    bTTest[1] = new GenPair<Integer, Float>(10, 8.0f);
    bTTest[2] = new GenPair<Integer, Float>( 3, 1.5f);
    bTTest[3] = new GenPair<Integer, Float>( 2, 2.0f);
  }

  /* Istanza originale di test nell'articolo di riferimento. */
  public static void initOriginale() {
    originale[0] = new GenPair<Integer, Float>(3, 1.0f);
    originale[1] = new GenPair<Integer, Float>(3, 1.0f);
    originale[2] = new GenPair<Integer, Float>(3, 3.0f);
    originale[3] = new GenPair<Integer, Float>(3, 1.0f);
    originale[4] = new GenPair<Integer, Float>(3, 3.0f);
    originale[5] = new GenPair<Integer, Float>(3, 0.0f);
    originale[6] = new GenPair<Integer, Float>(3, 3.0f);
    originale[7] = new GenPair<Integer, Float>(3, 3.0f);
    originale[8] = new GenPair<Integer, Float>(3, 1.0f);
    originale[9] = new GenPair<Integer, Float>(3, 3.0f);
    originale[10] = new GenPair<Integer, Float>(3, 3.0f);
    originale[11] = new GenPair<Integer, Float>(3, 0.0f);
    originale[12] = new GenPair<Integer, Float>(3, 3.0f);
    originale[13] = new GenPair<Integer, Float>(3, 3.0f);
    originale[14] = new GenPair<Integer, Float>(3, 1.0f);
    originale[15] = new GenPair<Integer, Float>(2, 2.0f);
    originale[16] = new GenPair<Integer, Float>(2, 2.0f);
    originale[17] = new GenPair<Integer, Float>(2, 2.0f);
    originale[18] = new GenPair<Integer, Float>(2, 2.0f);
    originale[19] = new GenPair<Integer, Float>(2, 2.0f);
    originale[20] = new GenPair<Integer, Float>(10, 6.0f);
    originale[21] = new GenPair<Integer, Float>(2, 2.0f);
    originale[22] = new GenPair<Integer, Float>(2, 1.0f);
    originale[23] = new GenPair<Integer, Float>(2, 2.0f);
    originale[24] = new GenPair<Integer, Float>(2, 2.0f);
    originale[25] = new GenPair<Integer, Float>(2, 1.0f);
    originale[26] = new GenPair<Integer, Float>(2, 2.0f);
    originale[27] = new GenPair<Integer, Float>(2, 2.0f);
    originale[28] = new GenPair<Integer, Float>(2, 2.0f);
    originale[29] = new GenPair<Integer, Float>(2, 0.0f);
    originale[30] = new GenPair<Integer, Float>(2, 1.0f);
    originale[31] = new GenPair<Integer, Float>(1, 1.0f);
    originale[32] = new GenPair<Integer, Float>(1, 1.0f);
    originale[33] = new GenPair<Integer, Float>(1, 1.0f);
    originale[34] = new GenPair<Integer, Float>(1, 1.0f);
    originale[35] = new GenPair<Integer, Float>(1, 1.0f);
    originale[36] = new GenPair<Integer, Float>(1, 1.0f);
    originale[37] = new GenPair<Integer, Float>(1, 1.0f);
    originale[38] = new GenPair<Integer, Float>(1, 1.0f);
    originale[39] = new GenPair<Integer, Float>(1, 1.0f);
    originale[40] = new GenPair<Integer, Float>(1, 1.0f);
    originale[41] = new GenPair<Integer, Float>(2, 2.0f);
    originale[42] = new GenPair<Integer, Float>(2, 2.0f);
    originale[43] = new GenPair<Integer, Float>(2, 2.0f);
    originale[44] = new GenPair<Integer, Float>(2, 2.0f);
    originale[45] = new GenPair<Integer, Float>(2, 0.0f);
    originale[46] = new GenPair<Integer, Float>(3, 3.0f);
    originale[47] = new GenPair<Integer, Float>(3, 3.0f);
    originale[48] = new GenPair<Integer, Float>(4, 2.0f);
    originale[49] = new GenPair<Integer, Float>(10, 8.0f);
  }
}
