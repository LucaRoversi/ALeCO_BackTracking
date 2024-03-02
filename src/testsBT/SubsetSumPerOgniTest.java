package testsBT;

import org.junit.jupiter.api.Test;
import subsetsumBT.*;

class SubsetSumPerOgniTest {

  @Test
  void testHorowitz() {
    int[] insieme = { 24, 11, 13, 7 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 31, soluzione, 0);
  }

  @Test
  void testErickson() {
    int[] insieme = { 8, 6, 7, 5, 3, 10, 9 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 15, soluzione, 0);
  }

  @Test
  void testBase00() {
    int[] insieme = { 24 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 24, soluzione, 0);
  }

  @Test
  void testBase01() {
    int[] insieme = { 24 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 25, soluzione, 0);
  }

  @Test
  void testBase02() {
    int[] insieme = { 1, 1 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 2, soluzione, 0);
  }

  @Test
  void testBase03() {
    int[] insieme = { 1, 1 };
    int[] soluzione = new int[insieme.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    SubsetSumPerOgni.risposte(insieme, 1, soluzione, 0);
  }
}
