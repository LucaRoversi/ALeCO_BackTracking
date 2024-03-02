package testsBT;

import org.junit.jupiter.api.Test;

import hamiltonianoBT.*;

class CamminoHamiltonianoPerOgniTest {

  @Test
  void testCamminoHam() {
    boolean[][] grafo = { { false, false, true, true   }
                        , { false, false, true, true   }
                        , { true , true , false, false }
                        , { true , true , false, false } };
    int[] soluzione = new int[grafo.length];
    for (int i = 0; i < 4; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    CamminoHamiltonianoPerOgni.risposte(grafo, soluzione, 0);
  }

  @Test
  void testSlideVerde() {
    System.out.println("---------------");
    boolean[][] grafo = { { false, true , false, false, false }
                        , { false, false, true , false, true  }
                        , { false, false, false, true , false } 
                        , { true , false, false, false, true  }
                        , { true , false, true , false, false } };
    int[] soluzione = new int[grafo.length];
    for (int i = 0; i < soluzione.length; i++)
      soluzione[i] = i;
    CamminoHamiltonianoPerOgni.risposte(grafo, soluzione, 0);
  }
  
  @Test
  void test00() {
    boolean[][] grafo = { { false } };
    int[] soluzione = new int[grafo.length];
    for (int i = 0; i < 1; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    CamminoHamiltonianoPerOgni.risposte(grafo, soluzione, 0);
  }

  @Test
  void test01() {
    boolean[][] grafo = { { true } };
    int[] soluzione = new int[grafo.length];
    for (int i = 0; i < 1; i++)
      soluzione[i] = i;
    System.out.println("---------------");
    CamminoHamiltonianoPerOgni.risposte(grafo, soluzione, 0);
  }
}