package testsBT;

import org.junit.jupiter.api.Test;
import subsetsumBT.*;

class SubsetSumSotOgniTest {

  @Test
  void testHorowitz() {
    int[] insieme = { 24, 11, 13, 7 };
    System.out.println("------------------");
    SubsetSumSotOgni.risposte(insieme, 31, new boolean[insieme.length], 0);
  }

  @Test
  void testErickson() {
    System.out.println("------------------");
    int[] insieme = { 8, 6, 7, 5, 3, 10, 9 };
    SubsetSumSotOgni.risposte(insieme, 15, new boolean[insieme.length], 0);
  }

  @Test
  void test() {
    System.out.println("------------------");
    int[] insieme = { 1, 1 };
    SubsetSumSotOgni.risposte(insieme, 2, new boolean[insieme.length], 0);
  }
}