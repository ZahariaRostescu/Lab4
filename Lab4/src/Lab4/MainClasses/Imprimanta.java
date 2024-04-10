package Lab4.MainClasses;

import Lab4.Enums.ModTIparire;
import Lab4.Enums.StareEchipament;
import Lab4.MainClasses.Echipament;

import java.util.List;
import java.util.Scanner;

public class Imprimanta extends Echipament {
    private int ppm;
    private String dpi;
    private int pagCartus;
    private ModTIparire modTiparire;
    public Imprimanta() {}
    public Imprimanta(String denumire, int nr_inventar, float pret, String zona_mag, StareEchipament stare, int ppm, String dpi, int pagCartus, ModTIparire modTipare)
    {
        super(denumire,nr_inventar,pret, zona_mag, stare);
        this.ppm=ppm;
        this.dpi=dpi;
        this.pagCartus=pagCartus;
        this.modTiparire=modTipare;
    }
    public String toString()
    {
        return super.toString()+" "+ ppm+ " "+ dpi.toString()+" "+ pagCartus+" "+modTiparire.toString();
    }
    public void modifyMod()
    {
        System.out.println("Modul actual al echipamentului: "+this.modTiparire.toString());
        System.out.println("Cum doriti sa modificati?\n  alb_negru/color\n\nOpt dumneavoastra: ");
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine();
        if(opt.compareTo("alb_negru")==0)
            this.modTiparire=ModTIparire.alb_negru;
        else if  (opt.compareTo("color")==0) {
            this.modTiparire=ModTIparire.color;
        }
        else
            System.out.println("\nSchimbarea nu se poate face");
    }
    public static void SearchandModify(List<Echipament> echipamente)
    {
        Scanner keyboard=new Scanner(System.in);
        String nume_cautat;
        System.out.println("Numele dupa care cautati: ");
        nume_cautat=keyboard.nextLine();
        for (Echipament e: echipamente)
        {
            if(e.checkName(nume_cautat)) {
                Imprimanta impr;
                impr = (Imprimanta) e;
                impr.modifyMod();
                break;
            }
        }
    }
}