import java.util.Date;
import java.util.List;

public class CreditCard {
    private String number;
    private String password;
    private Date expiration;
    private String securityCode;
    private double monthlyFee;
    private double limit;
    private double closing;
    private Benefits benefits;
    private Client holder;
    private List<Bill> bills;
    private List<Transaction> history;
    private List<Payment> payments;


    public CreditCard(){

    }

    public String getCardInfo(){

    }

    public void changeSecurityCode(){

    }

    public Benefits getBenefits() {

    }

    public void changeBenefits(){

    }

    public List<Bill> getBills() {

    }

    public Bill getLastBill(){

    }

    public List<Transaction> getTransactionsHistory() {

    }

    public void payBill(){

    }

    public double getLimit(){

    }

    public double changeLimit(){

    }
}
