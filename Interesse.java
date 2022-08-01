import java.util.HashMap;

public class Interesse {

  String interesseNavn;
  HashMap<String,Integer> interesseVerdier;

  public Interesse(String n) {
    interesseNavn = n;
    interesseVerdier = new HashMap<String,Integer>();
  }//Metoden konstruktør slutter.

  public String toString() {
    return interesseNavn;
  }//Metoden toString slutter.

//----------------------------------------------------------------
  public String hentInteresseNavn() {
    return interesseNavn;
  }//Metoden hentInteresseNavn slutter.

  public HashMap<String,Integer> hentinteresseVerdier() {
    return interesseVerdier;
  }//Metoden hentInteresseVerdier slutter.

  public String hentLagerStreng() {
    String lagerStrengen = interesseNavn;
    for(String kallenavn: interesseVerdier.keySet()) {
      lagerStrengen += (";" + kallenavn + ";" + interesseVerdier.get(kallenavn));
    }
    return lagerStrengen;
  }//Metoden hentLagerStreng slutter.

  public void leggTilVerdi(String k, String v) {
    interesseVerdier.put(k, Integer.parseInt(v));
  }//Metoden leggTilVerdi slutter.

//----------------------------------------------------------------
}//Klassen Interesse slutter.
