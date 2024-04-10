package Lab4.Handlers;
import Lab4.MainClasses.Echipament;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializare {
    public static void serializare(List<Echipament> echipamente) {
        try (FileOutputStream fileOut = new FileOutputStream("echip.bin");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut))
        {
            objectOut.writeObject(echipamente);
            objectOut.close();
            fileOut.close();
            System.out.println("Serializare reusita în echip.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
