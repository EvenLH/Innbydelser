public class Evensinnbydelser {

  public static Venneoversikt venneoversikten;
  public static Hendelsesoversikt hendelsesoversikten;
  public static Interesseoversikt interesseoversikten;

  public static void main(String[] args) {
    Evensinnbydelser.oppstart();
    Evensinnbydelser.bruk();
  }//Metoden main slutter.

  public static void oppstart() {
    System.out.println("Velkommen til Evens innbydelser!");

    venneoversikten = new Venneoversikt();
    hendelsesoversikten = new Hendelsesoversikt();
    interesseoversikten = new Interesseoversikt();

    venneoversikten.lesVenner("Venner.txt");
    hendelsesoversikten.lesHendelser("Hendelser.txt");
    interesseoversikten.lesInteresser("Interesser.txt");

    //TESTER
    venneoversikten.visVenner();
    hendelsesoversikten.visHendelser();
  }//Metoden oppstart slutter.

  public static void bruk() {}//Metoden bruk slutter.

//----------------------------------------------------------------
}//Klassen Evenkalender slutter.
