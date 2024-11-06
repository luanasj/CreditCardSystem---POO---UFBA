import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {




        LocalDate data = LocalDate.now().plusYears(4);
        System.out.println(data.getMonthValue());
        HashMap<String, Integer> map = new HashMap<>(); map.put("A", 1); map.put("B", 2); map.put("C", 3);
        Collection<Integer> values = map.values(); System.out.println("Valores no mapa: " + values);
        // Adicionando um novo valor ao mapa
        map.put("D", 4); System.out.println("Valores atualizados no mapa: "+ map.get("F"));
    }
}