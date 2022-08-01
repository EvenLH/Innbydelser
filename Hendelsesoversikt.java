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
      hendelsesboken.put(midlArray[0],
      new Hendelse(midlArray[0],Integer.parseInt(midlArray[1]),
      Integer.parseInt(midlArray[2]),Integer.parseInt(midlArray[3]),
      Integer.parseInt(midlArray[4]),midlArray[5])); //Utsagn delt i 4 linjer.
    }

    leseren.close();
  }//Metoden lesHendelser slutter.

  public void nyHendelse() {
    Scanner skrift = new Scanner(System.in);
    System.out.print("Angi hendelsens navn: ");
    String n = skrift.nextLine();

    System.out.println("Om du ogsaa vil angi dato og klokkeslett, skriv 'ja'.");
    String svar = skrift.nextLine();
    if(svar.equalsIgnoreCase("Ja")) {
      System.out.print("Angi aar (fire siffer): ");
      int aa = Integer.parseInt(skrift.nextLine());
      System.out.print("Angi maaned (to siffer): ");
      int m = Integer.parseInt(skrift.nextLine());
      System.out.print("Angi dag (to siffer): ");
      int d = Integer.parseInt(skrift.nextLine());
      System.out.print("Angi klokkeslett (fire siffer): ");
      int k = Integer.parseInt(skrift.nextLine());
      hendelsesboken.put(n, new Hendelse(n, aa, m, d, k));
    }
    else {
      hendelsesboken.put(n, new Hendelse(n));
    }

    try {
      FileWriter hendelsesfilen = new FileWriter("hendelser.txt", true);
      hendelsesfilen.write(hendelsesboken.get(n).hentLagerStreng() + "\n");
      hendelsesfilen.close();
      System.out.println("Hendelse lagret (" + hendelsesboken.get(n).hentLagerStreng() + ").");
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden nyHendelse slutter.

  public void visHendelser() {
    System.out.println("HENDELSER");
    for(String noekkel: hendelsesboken.keySet()) {
      System.out.println(hendelsesboken.get(noekkel).hentHendelseMedDato());
    }
  }//Metoden visHendelser slutter.

  public void slettHendelse() {
    Scanner leseren = new Scanner(System.in);
    System.out.println("Angi hendelse til sletting: ");
    String hendelsesnavnet = leseren.nextLine();

    hendelsesboken.remove(hendelsesnavnet);

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
  }//Metoden slettHendelse slutter.

//----------------------------------------------------------------
}//Klassen Hendelsesoversikt slutter.
