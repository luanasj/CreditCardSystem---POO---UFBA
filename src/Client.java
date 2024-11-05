//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Client {
//    private String name;
//    private Date birthday;
//    private boolean enterprise;
//    private String doc;
//    private Adress adress;
//    private List<CreditCard> creditCard;
//
//    public Client(String name, Date birthday, boolean enterprise, String doc, Adress adress) {
//        this.name = name;
//        this.birthday = birthday;
//        this.enterprise = enterprise;
//        this.doc = doc;
//        this.adress = adress;
//        this.creditCard = new LinkedList<>();
//    }
//
//    public String getClientInfo() {
//        String clientInfo = this.name + "\n" + this.birthday + "\n" +  (this.enterprise ? "CNPJ: " : "CPF: ") + this.doc + "\n" + adress.getAdress();
//
//        return clientInfo;
//    }
//
//    public void createCreditCard(){}
//
//    public String getClientCards(){}
//
//    public String getCardInfo(){}
//
//}
