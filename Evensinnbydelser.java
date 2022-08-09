import java.util.Scanner;

public class Evensinnbydelser {

  public static Venneoversikt venneoversikten;
  public static Hendelsesoversikt hendelsesoversikten;
  public static Interesseoversikt interesseoversikten;

  public static void main(String[] args) {
    Evensinnbydelser.oppstart();
    Evensinnbydelser.bruk();
    Evensinnbydelser.avslutning();
  }//Metoden main slutter.

  public static void oppstart() {
    System.out.println("----------------------------------------------------------------");
    System.out.println("Velkommen til Evens innbydelser!");

    venneoversikten = new Venneoversikt();
    hendelsesoversikten = new Hendelsesoversikt();
    interesseoversikten = new Interesseoversikt();

    venneoversikten.lesVenner("Venner.txt");
    hendelsesoversikten.lesHendelser("Hendelser.txt");
    interesseoversikten.lesInteresser("Interesser.txt");
  }//Metoden oppstart slutter.

  public static void bruk() {
    Evensinnbydelser.visValgHoved();

    Scanner leseren = new Scanner(System.in);
    String befaling = "0";

    while(!befaling.equalsIgnoreCase("Av")) {
      System.out.println(" ");
      System.out.print("Valg: ");
      befaling = leseren.nextLine();

      if(befaling.equalsIgnoreCase("V")) {
        Evensinnbydelser.visValgVenner();
      }
      else if(befaling.equalsIgnoreCase("H")) {
        Evensinnbydelser.visValgHendelser();
      }
      else if(befaling.equalsIgnoreCase("I")) {
        Evensinnbydelser.visValgInteresser();
      }

      else if(befaling.equalsIgnoreCase("vis V")) {
        venneoversikten.visVenner();
      }
      else if(befaling.equalsIgnoreCase("ny V")) {
        venneoversikten.nyVenn();
      }
      else if(befaling.equalsIgnoreCase("rediger V")) {
        venneoversikten.redigerVenn();
      }
      else if(befaling.equalsIgnoreCase("slett V")) {
        venneoversikten.slettVenn();
      }

      else if(befaling.equalsIgnoreCase("vis H")) {
        hendelsesoversikten.visHendelser();
      }
      else if(befaling.equalsIgnoreCase("ny H")) {
        hendelsesoversikten.nyHendelse();
      }
      else if(befaling.equalsIgnoreCase("rediger H")) {
        hendelsesoversikten.redigerHendelse();
      }
      else if(befaling.equalsIgnoreCase("slett H")) {
        hendelsesoversikten.slettHendelse();
      }

      else if(befaling.equalsIgnoreCase("vis I")) {
        interesseoversikten.visInteresser();
      }
      else if(befaling.equalsIgnoreCase("ny I")) {
        interesseoversikten.nyInteresse();
      }
      else if(befaling.equalsIgnoreCase("slett I")) {
        interesseoversikten.slettInteresse();
      }

      else if(befaling.equalsIgnoreCase("Av")) {}
      else {
        System.out.println("Ugyldig valg.");
      }
    }
  }//Metoden bruk slutter.

  public static void visValgHoved() {
    System.out.println(" ");
    System.out.println("Velg hva du vil se og redigere:");
    System.out.println("V - se valg for venner.");
    System.out.println("H - se valg for hendelser.");
    System.out.println("I - se valg for interesser.");
    System.out.println("Av - avslutt programmet.");
  }//Metoden valgHoved slutter.

  public static void visValgVenner() {
    System.out.println(" ");
    System.out.println("vis V - vis venner.");
    System.out.println("ny V - legg til venn.");
    System.out.println("rediger V - rediger venn.");
    System.out.println("slett V - slett venn.");
  }//Metoden valgVenner slutter.

  public static void visValgHendelser() {
    System.out.println(" ");
    System.out.println("vis H - vis hendelser.");
    System.out.println("ny H - legg til hendelse.");
    System.out.println("rediger H - rediger hendelse.");
    System.out.println("slett H - slett hendelse.");
  }//Metoden valgHendelser slutter.

  public static void visValgInteresser() {
    System.out.println(" ");
    System.out.println("vis I - vis interesser.");
    System.out.println("ny I - legg til interesse.");
    System.out.println("slett I - slett interesse.");
  }//Metoden valgInteresser slutter.

  public static void avslutning() {
    System.out.println(" ");
    System.out.println("Evens innbydelser avslutter. Paa gjensyn!");
    System.out.println("----------------------------------------------------------------");
  }//Metoden avslutning slutter.

//----------------------------------------------------------------
}//Klassen Evenkalender slutter.
