package testsBT;

import org.junit.jupiter.api.Test;

import motivazionaliBT.*;

public class OrdinamentoPerTest {

  // @Test
  void test00() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] {}, 0);
  }
  
  // @Test
  void test01() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] { 1 }, 0);
  }
  
  // @Test
  void test02() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] { 2, 1 }, 0);
  }
  
  // @Test
  void test03() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] { 1, 2, 3, 4 }, 0);
  }
  
  @Test
  void test04() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] { 2, 1, 4, 3 }, 0);
  }

   @Test
   void test05() {
     System.out.println("-------------------------");
     OrdinamentoPer.ordinamento(new int[] { 32, 3, 2, 4, 1, 3, 5, 6, 7, 2 }, 0);
   }
   
  
//   @Test
  void test06() {
    System.out.println("-------------------------");
    OrdinamentoPer.ordinamento(new int[] { 1, 3, 2, 4 }, 0);
  }
}