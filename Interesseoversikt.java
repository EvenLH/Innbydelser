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

  public void nyInteresse() {
    Scanner skrift = new Scanner(System.in);
    System.out.print("Angi interessens navn: ");
    String n = skrift.nextLine();

    interesseboken.put(n, new Interesse(n));

    try {
      FileWriter interessefilen = new FileWriter("Interesser.txt");
      interessefilen.write(interesseboken.get(n).hentLagerStreng() + "\n");
      interessefilen.close();
      System.out.println("Interesse lagret (" + interesseboken.get(n).hentLagerStreng() + ").");
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden nyInteresse slutter.

  public void slettInteresse() {
    Scanner leseren = new Scanner(System.in);
    System.out.println("Angi interesse til sletting: ");
    String interessenavnet = leseren.nextLine();

    interesseboken.remove(interessenavnet);

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
  }//Metoden slettInteresse slutter.

//----------------------------------------------------------------
}//Klassen Interesseoversikt slutter.
