package Lab4;

import Lab4.Handlers.EchipamentHandler;
import Lab4.MainClasses.Echipament;
import Lab4.MainClasses.Menu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        List<Echipament> echipamente= new ArrayList<Echipament>();
        EchipamentHandler ech = new EchipamentHandler();
        echipamente=ech.loadList();
        Menu.menuAppear(echipamente);
    }
}