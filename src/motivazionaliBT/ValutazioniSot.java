package motivazionaliBT;
/**
 * Dato un array a, stampa tutte le sue permutazioni senza
 * alcuna ripetizione di elementi.
 * La forma dell'algoritmo e' orientata a costituire 
 * il punto di partenza per realizzare algoritmi di backtracking
 * con strutture uniformi.
 * 
 * In generale, al fine di applicare il algoritmi di backtracking,
 * la risposta (answer) cercata deve essere un tupla (x1,...,xn)
 * dove ogni xi e' scelto in un insieme finito Si che esprime una
 * istanza del problema da risolvere. 
 * 
 * Spesso, il problema su cui si applica un algoritmo di 
 * backtrackingla richiede la ricerca di un vettore che massimizza
 * (minimizza, soddisfa) una funzione di accettazione della soluzione 
 * che, proprio perche' accettata, diventa "risposta" (xi, ..., xn).
 * Altre volte, e' possible dover cercare tutte le risposte
 * disponibili nello spazio degli stati.                          */

import supportoBT.GenPair;

public class ValutazioniSot {

  public static void valutazioniSot(GenPair<Integer, Float>[] a, 
      int votoMaxConsentito, boolean[] risposta, boolean[] soluzione, int j) {

    if (!completa(soluzione, j)) {
      if (!rifiuta(a, votoMaxConsentito, soluzione, j)) {
        valutazioniSot(a, votoMaxConsentito, risposta, soluzione, j + 1);
        soluzione[j] = true;
        valutazioniSot(a, votoMaxConsentito, risposta, soluzione, j + 1);
        soluzione[j] = !soluzione[j];
      }
    } else
    if (accetta(a, votoMaxConsentito, risposta, soluzione, j))
      risposta(a, votoMaxConsentito, risposta, soluzione, j);
  }
	
  /* Restituisce true quando soluzione[0..j) puo' essere 
   * una soluzione.                                          */
  public static boolean completa(boolean[] soluzione, int j) {
    return j == soluzione.length;
  }

  /* La precondizione di utilizzo e' che la nuova potenziale soluzione 
   * non sia ancora in soluzione[0..j), cioe' j < soluzione.length.
   * 
   * In tal caso, se il voto massimo distribuibile da soluzione[0..j) 
   * e' gia' superiore a votoMaxConsentito, e' inutile continuare 
   * ad estendere soluzione[0..j), restituendo true.                  */
  public static boolean rifiuta(GenPair<Integer, Float>[] a, 
      int votoMaxConsentito, boolean[] soluzione, int j) {

    float votoMaxCorrente = 0.0f;
    /* Voto massimo assegnato da soluzione[0..j). */
    for (int i = 0; i < j; i++)
      votoMaxCorrente += (soluzione[i] ? a[i].pi0() : 0.0f);
    return votoMaxCorrente > votoMaxConsentito;
  }

  /* La precondizione di utilizzo e' che la nuova potenziale soluzione sia in
   * soluzione[0..j) && j == soluzione.length.
   * 
   * Nel caso in esame, soluzione[0..j) e' accettata, cioe' e' una risposta,
   * se il votoMaxCorrente che puo' assegnare non supera votoMaxConsentito 
   * e la votazioneCorrente che soluzione[0..j) assegna e' superiore alla 
   * miglioreVotazioneAttuale offerta da risposta[0..risposta.length).           */
  public static boolean accetta(GenPair<Integer, Float>[] a, int votoMaxConsentito, 
		  boolean[] risposta, boolean[] soluzione, int j) {

    /* Voto massimo che soluzione[0..j) assegnerebbe. */
    int votoMaxCorrente = 0;
    for (int i = 0; i < j; i++)
      votoMaxCorrente += (soluzione[i] ? a[i].pi0() : 0);

    /* Voto che soluzione[0..j) assegna. */
    float votazioneCorrente = 0.0f;
    for (int i = 0; i < j; i++)
      votazioneCorrente += (soluzione[i] ? a[i].pi1() : 0.0f);

    /* Migliore votazione trovata sinora data da risposta[0..j). */
    float miglioreVotazioneAttuale = 0.0f;
    for (int i = 0; i < j; i++)
      miglioreVotazioneAttuale += (risposta[i] ? a[i].pi1() : 0.0f);

    /* Trovata nuova soluzione? */
    return votoMaxCorrente <= votoMaxConsentito 
                   && miglioreVotazioneAttuale < votazioneCorrente;
  }

  /* Aggiorna la soluzione. La stampa anche a titolo didattico. */
  public static void risposta(GenPair<Integer, Float>[] a, 
		  int votoMaxConsentito, boolean[] risposta, boolean[] soluzione, int j) {

    /* Aggiorna risposta con quella migliore in sottoinsieme[0..sottoinsieme.length). */
    for (int i = 0; i < risposta.length; i++)
      risposta[i] = soluzione[i];

    /* Stampa la nuova solution migliore, appena trovata. */
    String s = "[";
    for (int i = 0; i < a.length; i++)
      s += (risposta[i] ? "(" + a[i].pi0() + "," + a[i].pi1() + ")" : "");
    System.out.println(s + "]");
  }
}