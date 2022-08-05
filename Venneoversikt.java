import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Venneoversikt {

  HashMap<String,Venn> venneboken;

  public Venneoversikt() {
    venneboken = new HashMap<String,Venn>();
  }//Metoden konstruktør slutter.

//----------------------------------------------------------------

  public void lesVenner(String filnavn) {
    File vennefilen = new File(filnavn);
    Scanner leseren;

    try {
      leseren = new Scanner(vennefilen);
    }
    catch(FileNotFoundException fnfe) {
      System.out.println("Ingen vennefil funnet (" + fnfe + ").");
      return;
    }

    while(leseren.hasNextLine()) {
      String linjen = leseren.nextLine();
      String[] midlArray = linjen.strip().split(";");
      venneboken.put(midlArray[3], new Venn(midlArray[0],midlArray[1],midlArray[2],midlArray[3]));
    }

    leseren.close();
  }//Metoden lesVenner slutter.

  public void visVenner() {
    System.out.println(" ");
    System.out.println("VENNER");
    for(String noekkel: venneboken.keySet()) {
      System.out.println("* " + venneboken.get(noekkel).hentFulltNavn());
    }
  }//Metoden visVenner slutter.

  public void nyVenn() {
    Scanner skrift = new Scanner(System.in);
    System.out.print("Angi alle fornavn: ");
    String f = skrift.nextLine();
    System.out.print("Angi alle mellomnavn: ");
    String m = skrift.nextLine();
    System.out.print("Angi alle etternavn: ");
    String e = skrift.nextLine();
    System.out.print("Angi et kallenavn: ");
    String k = skrift.nextLine();

    venneboken.put(k, new Venn(f,m,e,k));

    try {
      FileWriter vennefilen = new FileWriter("Venner.txt", true);
      vennefilen.write(venneboken.get(k).hentLagerStreng() + "\n");
      vennefilen.close();
      System.out.println("Venn lagret (" + venneboken.get(k).hentLagerStreng() + ").");
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden nyVenn slutter.

  public void redigerVenn() {
    System.out.println("Metoden redigerVenn er uferdig.");
  }//Metoden redigerVenn slutter.

  public void slettVenn() {
    Scanner skrift = new Scanner(System.in);
    System.out.print("Angi kallenavn til sletting: ");
    String kallenavnet = skrift.nextLine();

    venneboken.remove(kallenavnet);

    ArrayList<String> midl = new ArrayList<String>();
    for(String noekkel: venneboken.keySet()) {
      midl.add(venneboken.get(noekkel).hentLagerStreng());
    }

    try {
      FileWriter vennefilen = new FileWriter("Venner.txt", false);
      for(int i = 0; i < midl.size(); i++) {
        vennefilen.write(midl.get(i) + "\n");
      }
      vennefilen.close();
    }
    catch(IOException ioe) {
      System.out.println("Feil (" + ioe + ").");
    }
  }//Metoden slettVenn slutter.

//----------------------------------------------------------------
}//Klassen Venneoversikt slutter.
