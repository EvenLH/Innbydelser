public class Venn {

  String fornavn;
  String mellomnavn;
  String etternavn;
  String kallenavn;

  public Venn(String f, String m, String e, String k) {
    fornavn = f;
    mellomnavn = m;
    etternavn = e;
    kallenavn = k;
  }//Metoden konstruktør slutter.

  public String toString() {
    return this.hentFulltNavn();
  }//Metoden toString slutter.

//----------------------------------------------------------------
  public String hentFornavn() {
    return fornavn;
  }//Metoden hentFornavn slutter.

  public String hentMellomnavn() {
    return mellomnavn;
  }//Metoden hentMellomnavn slutter.

  public String hentEtternavn() {
    return etternavn;
  }//Metoden hentEtternavn slutter.

  public String hentKallenavn() {
    return kallenavn;
  }//Metoden hentKallenavn slutter.

  public String hentFulltNavn() {
    String fulltNavn = "";

    if(fornavn.length() >= 1) {
      fulltNavn = fulltNavn.concat(fornavn + " ");
    }
    if(mellomnavn.length() >= 1) {
      fulltNavn = fulltNavn.concat(mellomnavn + " ");
    }
    if(etternavn.length() >= 1) {
      fulltNavn = fulltNavn.concat(etternavn + " ");
    }
    fulltNavn = fulltNavn.concat("(" + kallenavn + ")");

    return fulltNavn;
  }//Metoden hentFulltNavn slutter.

  public String hentLagerStreng() {
    return fornavn + ";" + mellomnavn + ";" + etternavn + ";" + kallenavn;
  }//Metoden hentLagerStreng slutter.

  public void endreFornavn(String f) {
    fornavn = f;
  }//Metoden endreFornavn slutter.

  public void endreMellomnavn(String m) {
    mellomnavn = m;
  }//Metoden endreMellomnavn slutter.

  public void endreEtternavn(String e) {
    etternavn = e;
  }//Metoden endreEtternavn slutter.

  public void endreKallenavn(String k) {
    kallenavn = k;
  }//Metoden endreKallenavn slutter.

//----------------------------------------------------------------
}//Klassen Venn slutter.
