import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Adress client1Adress = new Adress("ruazinha","bairrozinho","234","6714-368","Salcity","Bahivis","Brazil");
        Client client1 = new Client("Fulano",new Date("02/28/2000"),false,"000-000-000-01",client1Adress);

        client1.createCreditCard(01,07,client1);

        System.out.println(client1.getClientCardsList());
    }
}