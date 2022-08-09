import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Hendelsesoversikt {

  HashMap<String,Hendelse> hendelsesboken;

  public Hendelsesoversikt() {
    hendelsesboken = new HashMap<String,Hendelse>();
  }//Metoden konstruktør slutter.

//----------------------------------------------------------------

  public void lesHendelser(String filnavn) {
    File hendelsesfilen = new File(filnavn);
    Scanner leseren;

    try {
      leseren = new Scanner(hendelsesfilen);
    }
    catch(FileNotFoundException fnfe) {
      System.out.println("Ingen hendelsesfil funnet (" + fnfe + ").");
      return;
    }

    while(leseren.hasNextLine()) {
      String linjen = leseren.nextLine();
      String[] midlArray = linjen.strip().split(";");
      hendelsesboken.put(midlArray[0],new Hendelse(midlArray[0],midlArray[1],midlArray[2],midlArray[3],midlArray[4],midlArray[5]));
    }

    leseren.close();
  }//Metoden lesHendelser slutter.

  public void visHendelser() {
    System.out.println(" ");
    System.out.println("HENDELSER");

    ArrayList<Hendelse> midlArray = new ArrayList<Hendelse>();
    for(String noekkel: hendelsesboken.keySet()) {
      midlArray.add(hendelsesboken.get(noekkel));
    }

    while(midlArray.size() > 0) {
      int indeksTidligste = 0;
      for(int i = 0; i < midlArray.size(); i++) {
        if(midlArray.get(i).hentDatoSomTall() < midlArray.get(indeksTidligste).hentDatoSomTall()) {
          indeksTidligste = i;
        }
      }
      System.out.println(midlArray.remove(indeksTidligste).hentHendelseMedDato());
    }
  }//Metoden visHendelser slutter.

  public void nyHendelse() {
    Scanner skrift = new Scanner(System.in);

    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi hendelsens navn: ");
      String n = skrift.nextLine();
      hendelsesboken.put(n, new Hendelse(n));

      System.out.println("Aar (a), maaned (m), dag (d), klokkeslett (k), beskrivelse (b).");
      System.out.print("Angi alt du vil skrive inn ved å skrive alle de aktuelle bokstavene: ");
      String hendelseSomOpprettes = skrift.nextLine().toLowerCase();

      if(hendelseSomOpprettes.contains("a")) {
        System.out.print("Angi aarstall (fire siffer): ");
        hendelsesboken.get(n).endreStartAar(skrift.nextLine());
      }
      if(hendelseSomOpprettes.contains("m")) {
        System.out.print("Angi maaned (to siffer): ");
        hendelsesboken.get(n).endreStartMnd(skrift.nextLine());
      }
      if(hendelseSomOpprettes.contains("d")) {
        System.out.print("Angi dag (to siffer): ");
        hendelsesboken.get(n).endreStartDag(skrift.nextLine());
      }
      if(hendelseSomOpprettes.contains("k")) {
        System.out.print("Angi klokkeslett (fire siffer, uten andre tegn): ");
        hendelsesboken.get(n).endreStartklokken(skrift.nextLine());
      }
      if(hendelseSomOpprettes.contains("b")) {
        System.out.print("Skriv beskrivelse: ");
        hendelsesboken.get(n).endreBeskrivelse(skrift.nextLine());
      }

      System.out.print("Vil du legge til flere hendelser? ");
      valget = skrift.nextLine();
    }

    this.oppdatereHendelsesfil();
  }//Metoden nyHendelse slutter.

  public void redigerHendelse() {}//Metoden redigerHendelse slutter.

  public void slettHendelse() {
    Scanner skrift = new Scanner(System.in);

    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi hendelse til sletting: ");
      String hendelsesnavnet = skrift.nextLine();
      hendelsesboken.remove(hendelsesnavnet);

      System.out.print("Vil du slette flere hendelser? ");
      valget = skrift.nextLine();
    }

    this.oppdatereHendelsesfil();
  }//Metoden slettHendelse slutter.

  public void oppdatereHendelsesfil() {
    ArrayList<String> midl = new ArrayList<String>();
    for(String noekkel: hendelsesboken.keySet()) {
      midl.add(hendelsesboken.get(noekkel).hentLagerStreng());
    }

    try {
      FileWriter hendelsesfilen = new FileWriter("Hendelser.txt", false);
      for(int i = 0; i < midl.size(); i++) {
        hendelsesfilen.write(midl.get(i) + "\n");
      }
      hendelsesfilen.close();
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden oppdatereHendelsesfil slutter.

//----------------------------------------------------------------
}//Klassen Hendelsesoversikt slutter.
