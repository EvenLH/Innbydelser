public class Hendelse {
  String hendelsesnavn;
  String startaar;
  String startmnd;
  String startdag;
  String startklokken;
  String beskrivelse;

  public Hendelse(String h) {
    hendelsesnavn = h;
    startaar = "";
    startmnd = "";
    startdag = "";
    startklokken = "";
    beskrivelse = "";
  }//Metoden konstruktør (1) slutter.

  public Hendelse(String h, String aa, String m, String d, String k, String b) {
    hendelsesnavn = h;
    startaar = aa;
    startmnd = m;
    startdag = d;
    startklokken = k;
    beskrivelse = b;
  }//Metoden konstruktør (2) slutter.

  public String toString() {
    return hendelsesnavn + "(" + startaar + "-" + startmnd + "-" + startdag + ")";
  }//Metoden toString slutter.

//----------------------------------------------------------------
  public String hentHendelsesnavn() {
    return hendelsesnavn;
  }//Metoden hentHendelsesnavn slutter.

  public String hentStartaar() {
    return startaar;
  }//Metoden hentStartaar slutter.

  public String hentStartmnd() {
    return startmnd;
  }//Metoden hentStartmnd slutter.

  public String hentStartdag() {
    return startdag;
  }//Metoden hentStartdag slutter.

  public String hentStartklokken() {
    return startklokken;
  }//Metoden hentStartklokken slutter.

  public String hentBeskrivelse() {
    return beskrivelse;
  }//Metoden hentBeskrivelse slutter.

  public String hentHendelseMedDato() {
    String hmd = "* ";

    if(!startaar.isEmpty()) {
      hmd = hmd.concat(startaar + "-");
    }
    else {
      hmd = hmd.concat("????-");
    }

    if(!startmnd.isEmpty()) {
      hmd = hmd.concat(startmnd + "-");
    }
    else {
      hmd = hmd.concat("??-");
    }

    if(!startdag.isEmpty()) {
      hmd = hmd.concat(startdag + " ");
    }
    else {
      hmd = hmd.concat("?? ");
    }

    hmd = hmd.concat(hendelsesnavn);

    return hmd;
  }//Metoden hentHendelseMedDato.

  public long hentStarttidSomTall() {
    String datoStreng = "";

    if(!startaar.isEmpty()) {
      datoStreng = datoStreng.concat(startaar);
    }
    else {
      datoStreng = datoStreng.concat("9999");
    }

    if(!startmnd.isEmpty()) {
      datoStreng = datoStreng.concat(startmnd);
    }
    else {
      datoStreng = datoStreng.concat("99");
    }

    if(!startdag.isEmpty()) {
      datoStreng = datoStreng.concat(startdag);
    }
    else {
      datoStreng = datoStreng.concat("99");
    }

    if(!startklokken.isEmpty()) {
      datoStreng = datoStreng.concat(startklokken);
    }
    else {
      datoStreng = datoStreng.concat("9999");
    }

    return Long.parseLong(datoStreng);
  }//Metoden hentStarttidSomTall slutter.

  public String hentLagerStreng() {
    return hendelsesnavn + ";" + startaar + ";" + startmnd + ";" + startdag + ";" + startklokken + ";" + beskrivelse;
  }//Metoden hentLagerStreng slutter.

  public void endreHendelsesnavn(String n) {
    hendelsesnavn = n;
  }//Metoden endreHendelsesnavn slutter.

  public void endreStartAar(String aa) {
    startaar = aa;
  }//Metoden endreStartAar slutter.

  public void endreStartMnd(String m) {
    startmnd = m;
  }//Metoden endreStartMnd slutter.

  public void endreStartDag(String d) {
    startdag = d;
  }//Metoden endreStartDag slutter.

  public void endreStartklokken(String k) {
    startklokken = k;
  }//Metoden endreStartklokken slutter.

  public void endreBeskrivelse(String b) {
    beskrivelse = b;
  }//Metoden endreBeskrivelse slutter.

//----------------------------------------------------------------
}//Klassen Hendelse slutter.
