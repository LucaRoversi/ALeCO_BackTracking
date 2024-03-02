package testsBT;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import colorazionegrafoBT.ColorazioneGrafoPerRepOgni;

class ColorazioneGrafoPerRepOgniTest {

  @Test
  void testSlideVerde2Colori() {
  System.out.println("---------------");
  boolean[][] grafo = { { false, true , false, false, false }
                      , { false, false, true , false, true  }
                      , { false, false, false, true , false } 
                      , { true , false, false, false, true  }
                      , { true , false, true , false, false } };
  // Al piu' tanti colori quanti sono i nodi.
  int[] colori = new int[grafo.length]; 
  for (int i = 0; i < colori.length; i++)
    colori[i] = i; 
  ColorazioneGrafoPerRepOgni.risposte(
      grafo, 
      colori, 
      new int[colori.length], // soluzione 
      0);
  }
  
  @Test
  void test00() {
  System.out.println("---------------");
  boolean[][] grafo = { { false, true , false }
                      , { true , false, true  }
                      , { false, true , false } };
  // Al piu' tanti colori quanti sono i nodi.
  int[] colori = new int[grafo.length]; 
  for (int i = 0; i < colori.length; i++)
    colori[i] = i; 
  ColorazioneGrafoPerRepOgni.risposte(
      grafo, 
      colori, 
      new int[colori.length], // soluzione 
      0);
  }

  @Test
  void test01() {
  System.out.println("---------------");
  boolean[][] grafo = { { false, true }
                      , { true , false  } };
  // Al piu' tanti colori quanti sono i nodi.
  int[] colori = new int[grafo.length]; 
  for (int i = 0; i < colori.length; i++)
    colori[i] = i;
  ColorazioneGrafoPerRepOgni.risposte(
      grafo, 
      colori, 
      new int[colori.length], // soluzione 
      0);
  }
}