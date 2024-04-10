package Lab4.Handlers;

import Lab4.MainClasses.Echipament;

import java.io.*;
import java.util.List;

public class Deserializare {
    //Functia ce deserializeaza obiectele @return lista de obiecte

    public static List<Echipament> deserializare() {
        List<Echipament> echipamente = null;
        try (FileInputStream fileIn = new FileInputStream("echip.bin");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn))
        {
            echipamente = (List<Echipament>) objectIn.readObject();
            System.out.println("Deserializare reusita din echip.bin");
            System.out.println("Lista este: \n");
            for(Echipament e: echipamente)
            {
                System.out.println(e.toString());
            }
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return echipamente;
    }
}
