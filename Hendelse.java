public class Hendelse {
  String hendelsesnavn;
  int startaar;
  int startmnd;
  int startdag;
  int startklokken;
  String beskrivelse;

  public Hendelse(String h) {
    hendelsesnavn = h;
    startaar = 0;
    startmnd = 0;
    startdag = 0;
    startklokken = 0;
    beskrivelse = null;
  }//Metoden konstruktør (1) slutter.

  public Hendelse(String n, int aa, int m, int d, int k) {
    hendelsesnavn = n;
    startaar = aa;
    startmnd = m;
    startdag = d;
    startklokken = k;
    beskrivelse = null;
  }//Metoden konstruktør (2) slutter.

  public Hendelse(String n, int aa, int m, int d, int k, String b) {
    hendelsesnavn = n;
    startaar = aa;
    startmnd = m;
    startdag = d;
    startklokken = k;
    beskrivelse = b;
  }//Metoden konstruktør (3) slutter.

  public String toString() {
    return hendelsesnavn + "(" + startaar + "-" + startmnd + "-" + startdag + ")";
  }//Metoden toString slutter.

//----------------------------------------------------------------
  public String hentHendelsesnavn() {
    return hendelsesnavn;
  }//Metoden hentHendelsesnavn slutter.

  public int hentStartaar() {
    return startaar;
  }//Metoden hentStartaar slutter.

  public int hentStartmnd() {
    return startmnd;
  }//Metoden hentStartmnd slutter.

  public int hentStartdag() {
    return startdag;
  }//Metoden hentStartdag slutter.

  public int hentStartklokken() {
    return startklokken;
  }//Metoden hentStartklokken slutter.

  public String hentBeskrivelse() {
    return beskrivelse;
  }//Metoden hentBeskrivelse slutter.

  public String hentHendelseMedDato() {
    String hmd = hendelsesnavn;

    if(startaar >= 1) {
      hmd = hmd.concat(" (" + startaar);
    }
    else {
      hmd = hmd.concat(" (????");
    }

    if(startmnd >= 1) {
      hmd = hmd.concat("-" + startmnd);
    }
    else {
      hmd = hmd.concat("-??");
    }

    if(startdag >= 1) {
      hmd = hmd.concat("-" + startdag);
    }
    else {
      hmd = hmd.concat("-??");
    }

    hmd = hmd.concat(")");

    return hmd;
  }//Metoden hentHendelseMedDato.

  public String hentLagerStreng() {
    return hendelsesnavn + ";" + startaar + ";" + startmnd + ";" + startdag + ";" + startklokken + ";" + beskrivelse;
  }//Metoden hentLagerStreng slutter.

//----------------------------------------------------------------
}//Klassen Hendelse slutter.
