import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class Client {
    private String name;
    private Date birthday;
    private boolean enterprise;
    private String doc;
    private Adress adress;
    private HashMap<String,CreditCard> creditCards;


    public Client(String name, Date birthday, boolean enterprise, String doc, Adress adress) {
        this.name = name;
        this.birthday = birthday;
        this.enterprise = enterprise;
        this.doc = doc;
        this.adress = adress;
        this.creditCards = new HashMap<String,CreditCard>();
    }

    public Client(String name) {
        this.name = name;
        this.birthday = null;
        this.enterprise = false;
        this.doc = "";
        this.adress = null;
        this.creditCards = new HashMap<String,CreditCard>();
    }

    public String getClientInfo() {
        String clientInfo = this.name + "\n" + this.birthday + "\n" +  (this.enterprise ? "CNPJ: " : "CPF: ") + this.doc + "\n" + adress.getAdress();

        return clientInfo;
    }

    public String createCreditCard(int dayOfClosing, int monthOfClosing, Client holder){
        CreditCard createdCreditCard = new CreditCard(dayOfClosing, monthOfClosing, holder);
        this.creditCards.put(createdCreditCard.getNumber(),createdCreditCard);
        return "Cartão criado com sucesso";
    }

    public String createCreditCard(int dayOfClosing, int monthOfClosing, Client holder, Benefits benefits, double initialLimit, AccountType accountType){
        CreditCard createdCreditCard = new CreditCard(dayOfClosing, monthOfClosing, holder, benefits, initialLimit, accountType);
        this.creditCards.put(createdCreditCard.getNumber(),createdCreditCard);
        return "Cartão criado com sucesso";
    }

    public String getClientCardsList(){
        String cardsList="";

        for(int i = 0 ; i<this.creditCards.keySet().size();i++){
            cardsList += i+1 + ". " + this.creditCards.keySet().stream().toList().get(i) + "\n";
        }

        return cardsList;

    }

    public CreditCard getCreditCard(String creditCardNumber){
        return this.creditCards.get(creditCardNumber);

    }



    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setEnterprise(boolean enterprise) {
        this.enterprise = enterprise;
    }

    public boolean getEnterprise() {
        return this.enterprise;
    }


}
