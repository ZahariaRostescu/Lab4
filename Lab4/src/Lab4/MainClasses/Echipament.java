package Lab4.MainClasses;

import Lab4.Enums.StareEchipament;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Echipament implements Serializable {

    protected String denumire;
    protected int nr_inventar;
    protected float pret;
    protected String zona_mag;
    protected StareEchipament stare;
    public Echipament(){}
    public Echipament(String denumire, int nr_inventar, float pret, String zona_mag, StareEchipament stare)
    {
        this.denumire=denumire;
        this.nr_inventar=nr_inventar;
        this.pret=pret;
        this.zona_mag=zona_mag;
        this.stare=stare;
    }
    public String toString()
    {
        return denumire+" " +nr_inventar+ " "+pret + " "+zona_mag.toString()+ " "+ stare;
    }
    public String getDenumire()
    {
        return denumire;
    }
    public boolean checkName(String nume) {
        String aux = getDenumire();
        int comparisonResult = aux.compareTo(nume);

        if (comparisonResult == 0)
            return true;
        else return false;
    }
    public boolean checkStare(String stare_dorita)
    {
        if(stare.toString().compareTo(stare_dorita)==0)
            return true;
        else return false;
    }
    public void modifyStare()
    {
        System.out.println("Starea actuala a echipamentului este: "+stare.toString());
        System.out.println("In ce stare doriti sa modificati?\n  achizitionat/expus/vandut\n\nOpt dumneavoastra: ");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();
        if(opt.compareTo("achizitionat")==0)
            stare=StareEchipament.achizitionat;
        else if  (opt.compareTo("expus")==0) {
            stare=StareEchipament.expus;
        }
        else if (opt.compareTo("vandut")==0) {
            stare=StareEchipament.vandut;
        }
        else
            System.out.println("\nSchimbarea nu se poate face");
    }
    public static void showCopiator(List<Echipament> echipamente)
    {
        for(Echipament e: echipamente)
        {
            if(e.getClass().getCanonicalName().contains("Copiator")) //se verifica daca contine clasa
                System.out.println(e.toString());
        }
    }
    public static void showImprimanta(List<Echipament> echipamente)
    {
        for(Echipament e: echipamente)
        {
            if(e instanceof Imprimanta)
                System.out.println(e.toString());
        }
    }
    public static void showSistemCalcul(List<Echipament> echipamente)
    {
       //sistemeCalcul x= new sistemeCalcul();
        for(Echipament e: echipamente)
        {
            if(e.getClass()==SistemeCalcul.class)
                System.out.println(e.toString());
        }
    }
    public static void SearchandModify(List<Echipament> echipamente) {
        Scanner keyboard = new Scanner(System.in);
        String nume_cautat;
        System.out.println("Numele dupa care cautati: ");
        nume_cautat = keyboard.nextLine();
        for (Echipament e : echipamente) {
            if (e.checkName(nume_cautat)) {
                e.modifyStare();
                break;
            }
        }
    }
    public static void showByState(List<Echipament> echipamente,String stare)
    {
        for (Echipament e: echipamente)
        {
            if (e.checkStare(stare))
            {
                System.out.println(e.toString());
            }
        }
    }
}