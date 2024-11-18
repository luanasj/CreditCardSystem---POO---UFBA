import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Cadastro novo CLiente:\nPrimeiro, por favor, nos informe o seus dados e Endereço");
        System.out.print("Rua: ");
        String rua = scanner.next();
        System.out.print("Bairro: ");
        String bairro = scanner.next();
        System.out.print("Numero: ");
        String numero = scanner.next();
        System.out.print("CEP: ");
        String cep = scanner.next();
        System.out.print("Cidade: ");
        String cidade = scanner.next();
        System.out.print("Estado: ");
        String estado = scanner.next();
        System.out.print("País: ");
        String pais = scanner.next();

        System.out.println("Agora forneça alguns dados pessoais");
        System.out.print("Nome: ");
        String nomeCli = scanner.next();
        System.out.print("Empresarial (true/false): ");
        boolean empresarial = scanner.nextBoolean();
        System.out.print("Data de"+(empresarial?"Fundação":"Nascimento")+" (mm/dd/aa): ");
        String dtNascCli = scanner.next();
        System.out.print(empresarial?"CNPJ: ":"CPF: ");
        String documento = scanner.next();




        Adress client1Adress = new Adress(rua,bairro,numero,cep,cidade,estado,pais);
        Client client1 = new Client(nomeCli,new Date(dtNascCli),empresarial,documento,client1Adress);

        System.out.println("Cliente Criado! Confira as informações: \n" + client1.getClientInfo());

        client1.createCreditCard(01,07,client1);

        System.out.println("Lista de catões de crédito do cliente:");
        System.out.println(client1.getClientCardsList());
    }
}