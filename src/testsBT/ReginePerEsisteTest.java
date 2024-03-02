package testsBT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regineBT.*;

class ReginePerEsisteTest {

  /* Configurazione iniziale con tute le 
   * regine sulla diagonale. Chiaramente
   * sara' rifiutata.                      */
  private static int[] initRegine(int l) {
    int[] regine = new int[l];
    for (int i = 0; i < l; i++)
      regine[i] = i;
    return regine;
  }
  
  @Test
  void test01() {
    ReginePerEsiste.soluzione(initRegine(1), 0);
    System.out.println("---------------");
  }

  @Test
  void test02() {
    ReginePerEsiste.tentativi = 0;
    ReginePerEsiste.soluzione(initRegine(2), 0);
    System.out.println("---------------");
  }
  
  @Test
  void test03() {
    ReginePerEsiste.tentativi = 0;
    ReginePerEsiste.soluzione(initRegine(3), 0);
    System.out.println("---------------");
  }
  
  @Test
  void test04() {
    ReginePerEsiste.tentativi = 0;
    ReginePerEsiste.soluzione(initRegine(4), 0);
    System.out.println("---------------");
  }
  
  @Test
  void test05() {
    ReginePerEsiste.tentativi = 0;
    ReginePerEsiste.soluzione(initRegine(5), 0);
    System.out.println("---------------");
  }
  @Test
  void test08() {
    ReginePerEsiste.tentativi = 0;
    ReginePerEsiste.soluzione(initRegine(8), 0);
    System.out.println("---------------");
  }
}
