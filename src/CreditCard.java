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
    private HashMap<String,Bill> bills;

    private CreditCard(int dayOfClosing,int monthOfClosing, Client holder,boolean special){
        this.number = UUID.randomUUID().toString();
        this.password = String.valueOf(Math.floor(Math.random()*1000));
        this.expiration = LocalDate.now().plusYears(4);
        this.securityCode = String.valueOf(Math.floor(Math.random()*100));
        this.closing = LocalDate.of(LocalDate.now().getYear(), monthOfClosing,dayOfClosing);
        this.holder = holder;
        this.bills = new HashMap<String,Bill>();
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

    }

    public Bill getLastBill(){

    public Bill getBill(){

    }


    }


    public void payBill(){

    }

    public double getLimit(){
        return this.limit;
    }

    public void changeLimit(double limit){
        this.limit = limit;
    }


    public void createTransaction( String name, double value, Establishment establishment, boolean installment){
        String currentMonth = LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        if(passedClosingOfTheMonth(LocalDate.now())){
            bills.put(currentMonth,new Bill(LocalDate.now(), new HashMap<String,Transaction>()));
        }
        Transaction newTransaction = new Transaction(name,value,establishment,installment,"1");
        bills.get(currentMonth).getTransactions().put(name,newTransaction);
    }

    public void createTransaction(String name, double value, Establishment establishment, boolean installment, int installments){
        //parcelado
        double installmentValue = value/installments;
        for(int i = 0;i<installments;i++){
            LocalDate installmentDate = LocalDate.now().plusMonths(i);
            String currentMonth = installmentDate.getMonthValue() + "/" + installmentDate.getYear();
            if(passedClosingOfTheMonth(installmentDate)){
                bills.put(currentMonth,new Bill(LocalDate.now(), new HashMap<String,Transaction>()));
            }
            Transaction newTransaction = new Transaction(name,installmentValue,establishment,installment,String.valueOf(i));
            bills.get(currentMonth).getTransactions().put(name,newTransaction);
        }

    }

    private void creteBill(){

    }

    private boolean passedClosingOfTheMonth(LocalDate date){
        boolean exists =  bills.get(date.getMonthValue() + "/" + date.getYear()) == null;
        boolean hasPassedClosing = date.getDayOfMonth() >= closing.getDayOfMonth();
        return exists && hasPassedClosing;
    }
}
