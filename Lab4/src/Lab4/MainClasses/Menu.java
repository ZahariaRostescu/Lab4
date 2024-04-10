package Lab4.MainClasses;
import Lab4.Handlers.Deserializare;
import Lab4.Handlers.EchipamentHandler;
import Lab4.Handlers.Serializare;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    public Menu() {}
    public static void menuAppear(List<Echipament> echipamente)
    {
        int opt;
        do {
            System.out.println("1.Afisarea tuturor echipamentelor\n2.Afisarea imprimantelor\n3.Afisarea copiatoarelor\n4.Afisarea sistemelor de calcul\n5.Modificarea starii in care se afla un echipament\n6.Setarea unui anumit mod de scriere pentru o imprimanta\n7.Setarea unui format de copiere pentru copiatoare\n8.Instalarea unui anumit sistem de operare pe un sistem de calcul\n9.Afisarea echipamentelor vandute\n10.Sa se realizeze doua metode statice pentru serializarea / deserializarea colectiei de obiecte in fisierul echip.bin\n");
            System.out.println("Optiunea dorita: ");
            Scanner keyboard = new Scanner(System.in);
            opt = keyboard.nextInt();
            String nume_cautat;
            switch (opt) {
                case 0 -> exit(0);
                case 1 -> EchipamentHandler.afisare(echipamente);
                case 2 -> Echipament.showImprimanta(echipamente);
                case 3 -> Echipament.showCopiator(echipamente);
                case 4 -> Echipament.showSistemCalcul(echipamente);
                case 5 -> Echipament.SearchandModify(echipamente);
                case 6 -> Imprimanta.SearchandModify(echipamente);
                case 7 -> Copiator.SearchandModify(echipamente);
                case 8 -> SistemeCalcul.SearchandModify(echipamente);
                case 9 -> Echipament.showByState(echipamente, "vandut");
                case 10 -> {
                    String opt2;
                    keyboard.nextLine();
                    System.out.println("1. Serializare\n2.Deserializare\nOpt: ");
                    opt2 = keyboard.nextLine();
                    switch (opt2) {
                        case "1":
                            Serializare.serializare(echipamente);
                            break;
                        case "Serializare":
                            Serializare.serializare(echipamente);
                            break;
                        case "2":
                            Deserializare.deserializare();
                            break;
                        case "Deserializare":
                            Deserializare.deserializare();
                            break;
                    }
                }
                default -> System.out.println("Optiunea aleasa nu este valida\n");
            }
        }
        while(opt!=0);
    }
}
