package testsBT;

import org.junit.jupiter.api.Test;
import subsetsumBT.*;

class SubsetSumPerEsisteTest {

  @Test
  void testHorowitz() {
    int[] insieme = { 24, 11, 13, 7 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerEsiste.risposta(insieme, 31, soluzione, 0);
  }

  @Test
  void testErickson() {
    int[] insieme = { 8, 6, 7, 5, 3, 10, 9 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerEsiste.risposta(insieme, 15, soluzione, 0);
  }

  @Test
  void testBase() {
    int[] insieme = { 1, 1 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerEsiste.risposta(insieme, 2, soluzione, 0);
  }
}
