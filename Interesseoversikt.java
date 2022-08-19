import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Interesseoversikt {

  HashMap<String,Interesse> interesseboken;

  public Interesseoversikt() {
    interesseboken = new HashMap<String,Interesse>();
  }//Metoden konstruktør slutter.

//----------------------------------------------------------------
  public void lesInteresser(String filnavn) {
    File interessefilen = new File(filnavn);
    Scanner leseren;

    try {
      leseren = new Scanner(interessefilen);
    }
    catch(FileNotFoundException fnfe) {
      System.out.println("Ingen interessefil funnet (" + fnfe + ").");
      return;
    }

    while(leseren.hasNextLine()) {
      String linjen = leseren.nextLine();
      String[] midlArray = linjen.strip().split(";");
      Interesse midlInteresse = new Interesse(midlArray[0]);
      interesseboken.put(midlArray[0], midlInteresse);

      String venneverdi = null;
      String tallverdi = null;
      for(int i = 1; i < midlArray.length; i++) {
        if(i%2 == 1) {
          venneverdi = midlArray[i];
        }
        else if(i%2 == 0) {
          tallverdi = midlArray[i];
          midlInteresse.leggTilVerdi(venneverdi, tallverdi);
        }
        else {
          System.out.println("Noe gikk galt i metoden 'lesInteresser'.");
        }
      }
    }

    leseren.close();
  }//Metoden lesInteresser slutter.

  public void visInteresser() {
    System.out.println("Metoden visInteresser er uferdig.");
  }//Metoden visInteresser slutter.

  public void nyInteresse(Scanner skrift) {
    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi interessens navn: ");
      String n = skrift.nextLine();
      interesseboken.put(n, new Interesse(n));

      System.out.print("Vil du legge til flere interesser? ");
      valget = skrift.nextLine();
    }

    this.oppdatereInteressefil();
  }//Metoden nyInteresse slutter.

  public void redigerInteresse() {
    System.out.println("Metoden redigerInteresse er uferdig.");
  }//Metoden redigerInteresse slutter.

  public void slettInteresse(Scanner skrift) {
    string valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.println("Angi interesse til sletting: ");
      String interessenavnet = skrift.nextLine();
      interesseboken.remove(interessenavnet);

      System.out.print("Vil du slette flere interesser? ");
      valget = skrift.nextLine();
    }

    this.oppdatereInteressefil();
  }//Metoden slettInteresse slutter.

  public void oppdatereInteressefil() {
    ArrayList<String> midl = new ArrayList<String>();
    for(String noekkel: interesseboken.keySet()) {
      midl.add(interesseboken.get(noekkel).hentLagerStreng());
    }

    try {
      FileWriter interessefilen = new FileWriter("Interesser.txt", false);
      for(int i = 0; i < midl.size(); i++) {
        interessefilen.write(midl.get(i) + "\n");
      }
      interessefilen.close();
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden oppdatereInteressefil slutter.

//----------------------------------------------------------------
}//Klassen Interesseoversikt slutter.
