import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private String name;
    private Date birthday;
    private boolean enterprise;
    private String doc;
    private Adress adress;
    private List<CreditCard> creditCards;


    public Client(String name, Date birthday, boolean enterprise, String doc, Adress adress) {
        this.name = name;
        this.birthday = birthday;
        this.enterprise = enterprise;
        this.doc = doc;
        this.adress = adress;
        this.creditCards = new LinkedList<>();
    }

    public Client(String name) {
        this.name = name;
        this.birthday = null;
        this.enterprise = false;
        this.doc = "";
        this.adress = null;
        this.creditCards = new LinkedList<>();
    }

    public String getClientInfo() {
        String clientInfo = this.name + "\n" + this.birthday + "\n" +  (this.enterprise ? "CNPJ: " : "CPF: ") + this.doc + "\n" + adress.getAdress();

        return clientInfo;
    }

    public String createCreditCard(int dayOfClosing, int monthOfClosing, Client holder){
        this.creditCards.add(new CreditCard(dayOfClosing, monthOfClosing, holder));
        return "Cartão criado com sucesso";
    }

    public String createCreditCard(int dayOfClosing, int monthOfClosing, Client holder, Benefits benefits, double initialLimit, AccountType accountType){
        this.creditCards.add(new CreditCard(dayOfClosing, monthOfClosing, holder, benefits, initialLimit, accountType));
        return "Cartão criado com sucesso";
    }

    public String getClientCardsList(){
        String cardsList="";

        for(int i = 0 ; i<this.creditCards.size();i++){
            cardsList += i+1 + ". " + this.creditCards.get(i).getNumber() + "\n";
        }

        return cardsList;

    }

    public CreditCard getCreditCard(int num){
        return this.creditCards.get(num-1);
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
