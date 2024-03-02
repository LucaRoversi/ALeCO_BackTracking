package testsBT;

import org.junit.jupiter.api.Test;

import subsetsumBT.*;

class SubsetSumSotEsisteTest {

  @Test
  void testHorowitz() {
    int[] insieme = { 24, 11, 13, 7 };
    SubsetSumSotEsiste.risposta(insieme, 31, new boolean[insieme.length], 0);
  }

  @Test
  void testErickson() {
    int[] insieme = new int[] { 8, 6, 7, 5, 3, 10, 9 };
    SubsetSumSotEsiste.risposta(insieme, 15, new boolean[insieme.length], 0);
  }

  @Test
  void test01() {
    int[] insieme = { 2, 3, 1 };
    SubsetSumSotEsiste.risposta(insieme, 3, new boolean[insieme.length], 0);
  }

  @Test
  void test02() {
    int[] insieme = { 3, 2, 1 };
    SubsetSumSotEsiste.risposta(insieme, 3, new boolean[insieme.length], 0);
  }

  @Test
  void test03() {
    int[] insieme = { 2, 1 };
    SubsetSumSotEsiste.risposta(insieme, 3, new boolean[insieme.length], 0);
  }
}