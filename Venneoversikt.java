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

    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi alle fornavn: ");
      String f = skrift.nextLine();
      System.out.print("Angi alle mellomnavn: ");
      String m = skrift.nextLine();
      System.out.print("Angi alle etternavn: ");
      String e = skrift.nextLine();
      System.out.println("Kallenavn maa ha minst 1 tegn, og vaere ulike alle andre kallenavn.");
      System.out.print("Angi et kallenavn (maa vaere minst 1 tegn): ");
      String k = skrift.nextLine();
      venneboken.put(k, new Venn(f,m,e,k));

      System.out.print("Vil du legge til flere venner? ");
      valget = skrift.nextLine();
    }

    this.oppdatereVennefil();
  }//Metoden nyVenn slutter.

  public void redigerVenn() {
    Scanner skrift = new Scanner(System.in);

    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi kallenavnet til den som skal redigeres: ");
      String kallenavn = skrift.nextLine();
      System.out.println("Fornavn (f), mellomnavn (m), etternavn (e), kallenavn (k).");
      System.out.print("Angi alt du vil redigere ved å skrive alle de aktuelle bokstavene: ");
      String navnSomRedigeres = skrift.nextLine().toLowerCase();

      if(navnSomRedigeres.contains("f")) {
        System.out.print("Angi nytt fornavn (erstatter " + venneboken.get(kallenavn).hentFornavn() + "): ");
        venneboken.get(kallenavn).endreFornavn(skrift.nextLine());
      }
      if(navnSomRedigeres.contains("m")) {
        System.out.print("Angi nytt mellomnavn (erstatter " + venneboken.get(kallenavn).hentMellomnavn() + "): ");
        venneboken.get(kallenavn).endreMellomnavn(skrift.nextLine());
      }
      if(navnSomRedigeres.contains("e")) {
        System.out.print("Angi nytt etternavn (erstatter " + venneboken.get(kallenavn).hentEtternavn() + "): ");
        venneboken.get(kallenavn).endreEtternavn(skrift.nextLine());
      }
      if(navnSomRedigeres.contains("k")) {
        System.out.println("Kallenavn maa ha minst 1 tegn, og vaere ulike alle andre kallenavn.");
        System.out.print("Angi nytt kallenavn (erstatter " + venneboken.get(kallenavn).hentKallenavn() + "): ");
        String nyttKallenavn = skrift.nextLine();
        venneboken.get(kallenavn).endreKallenavn(nyttKallenavn);

        venneboken.put(nyttKallenavn, venneboken.remove(kallenavn));
      }

      System.out.print("Vil du redigere flere venner? ");
      valget = skrift.nextLine();
    }

    this.oppdatereVennefil();
  }//Metoden redigerVenn slutter.

  public void slettVenn() {
    Scanner skrift = new Scanner(System.in);

    String valget = "ja";
    while(valget.equalsIgnoreCase("ja")) {
      System.out.print("Angi kallenavnet til den som skal slettes: ");
      String kallenavnet = skrift.nextLine();
      venneboken.remove(kallenavnet);

      System.out.print("Vil du slette flere venner? ");
      valget = skrift.nextLine();
    }

    this.oppdatereVennefil();
  }//Metoden slettVenn slutter.

  public void oppdatereVennefil() {
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
  }//Metoden oppdatereVennefil slutter.

//----------------------------------------------------------------
}//Klassen Venneoversikt slutter.
