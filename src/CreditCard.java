import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CreditCard {
    private String number;
    private String password;
    private LocalDate expiration;
    private String securityCode;
    private boolean special;
    private double monthlyFee;
    private double limit;
    private LocalDate closing; //saldo,depesa do mes
    private Benefits benefits;
    private Client holder;
    private List<Bill> bills;
    private HashMap<String,Transaction> history;

    private CreditCard(int dayOfClosing,int monthOfClosing, Client holder,boolean special){
        this.number = UUID.randomUUID().toString();
        this.password = String.valueOf(Math.floor(Math.random()*1000));
        this.expiration = LocalDate.now().plusYears(4);
        this.securityCode = String.valueOf(Math.floor(Math.random()*100));
        this.closing = LocalDate.of(LocalDate.now().getYear(), monthOfClosing,dayOfClosing);
        this.holder = holder;
        this.bills = new LinkedList<Bill>();
        this.history = new HashMap<String,Transaction>();
        this.special = special;
    }

    public CreditCard(int dayOfClosing,int monthOfClosing, Client holder){
        this(dayOfClosing,monthOfClosing,holder,false);
        this.monthlyFee = 0;
        this.limit = 400;
        this.benefits = new Benefits();
    }

    public CreditCard(int dayOfClosing,int monthOfClosing, Client holder,Benefits benefits, double initialLimit){
        this(dayOfClosing,monthOfClosing,holder,true);
        this.monthlyFee = 20;
        this.limit = initialLimit;
        this.benefits = benefits;
    }

    public void getCardInfo(){

    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }

    public Benefits getBenefits() {
        return this.benefits;
    }


    public List<Bill> getLastBills(int num) {
        return this.bills.subList(this.bills.size() - 1 - num,this.bills.size() -1);
    }

    public Bill getLastBill(){
        boolean isCurrent = this.bills.get(this.bills.size()-1).getMonth() == LocalDate.now().getMonthValue() && this.bills.get(this.bills.size()-1).getYear() == LocalDate.now().getYear();
        boolean hasPassedClosing = LocalDate.now().getDayOfMonth() >= closing.getDayOfMonth();
        if(isCurrent && hasPassedClosing){
            HashMap<String,Transaction> newBillTransactions;
            int i = 0;
            while(i<this.history.size() && this.history.values().toArray()[i].)
        }
        return this.bills.get(this.bills.size()-1);
    }


    public HashMap<String,Transaction> getTransactionsHistory(int num) {
        return this.history
    }

    public void payBill(){

    }

    public double getLimit(){

    }

    public double changeLimit(){

    }

    public void makeInstallment(){

    }
}
