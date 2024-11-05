//import javax.print.DocFlavor;
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.UUID;
//
//public class CreditCard {
//    private String number;
//    private String password;
//    private LocalDate expiration;
//    private String securityCode;
//    private boolean special;
//    private double monthlyFee;
//    private double limit;
//    private LocalDate closing; //saldo,depesa do mes
//    private Benefits benefits;
//    private Client holder;
//    private List<Bill> bills;
//    private HashMap<String,Transaction> history;
//    private List<Payment> payments;
//
//    private CreditCard(int dayOfClosing,int monthOfClosing, Client holder,boolean special){
//        this.number = UUID.randomUUID().toString();
//        this.password = String.valueOf(Math.floor(Math.random()*1000));
//        this.expiration = LocalDate.now().plusYears(4);
//        this.securityCode = String.valueOf(Math.floor(Math.random()*100));
//        this.closing = LocalDate.of(LocalDate.now().getYear(), monthOfClosing,dayOfClosing);
//        this.holder = holder;
//        this.bills = new LinkedList<Bill>();
//        this.history = new HashMap<String,Transaction>();
//        this.payments = new LinkedList<Payment>();
//        this.special = special;
//    }
//
//    public CreditCard(int dayOfClosing,int monthOfClosing, Client holder){
//        this(dayOfClosing,monthOfClosing,holder,false);
//        this.monthlyFee = 0;
//        this.limit = 400;
//        this.benefits = new Benefits();
//    }
//
//    public CreditCard(int dayOfClosing,int monthOfClosing, Client holder){
//        this(dayOfClosing,monthOfClosing,holder,false);
//        this.monthlyFee = 0;
//        this.limit = 400;
//        this.benefits = new Benefits();
//    }
//
//
//
//    public void getCardInfo(){
//
//    }
//
//    public void setPassword(){
//
//    }
//
//    public void setSecurityCode(){
//
//    }
//
//    public Benefits getBenefits() {
//
//    }
//
//    public void changeBenefits(){
//
//    }
//
//    public List<Bill> getBills() {
//
//    }
//
//    public Bill getLastBill(){
//
//    }
//
//    public List<Transaction> getTransactionsHistory() {
//
//    }
//
//    public void payBill(){
//
//    }
//
//    public double getLimit(){
//
//    }
//
//    public double changeLimit(){
//
//    }
//
//    public void makeInstallment(){
//
//    }
//}
