import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CreditCard {
    //construir a lógica de como o limite e o saldo vão se comportar.

    private String number;
    private String password;
    private LocalDate expiration;
    private String securityCode;
    private boolean special;
    private AccountType accountType;
    private double monthlyFee;
    private double limit;
    private LocalDate closing; //saldo,depesa do mes
    private Benefits benefits;
    private Client holder;
    private HashMap<String,Bill> bills;
    private final String adminPassword = "senhaDificil";

    protected CreditCard(int dayOfClosing,int monthOfClosing, Client holder,boolean special){
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
        this.accountType = AccountType.SIMPLE;
    }

    public CreditCard(int dayOfClosing,int monthOfClosing, Client holder,Benefits benefits, double initialLimit,AccountType accountType){
        this(dayOfClosing,monthOfClosing,holder,true);
        this.monthlyFee = accountType.getValue();
        this.limit = initialLimit;
        this.benefits = benefits;
        this.accountType = accountType;
    }

    public CreditCard(String nomeCliente, double initialLimit){
        this(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), new Client(nomeCliente));
    }

    public void getCardInfo(){
        String basicCardInfo = "Numero do Cartao: " + this.number + "\n Valido até: " + this.expiration + "\n Código de Segurança: " + this.securityCode + (special?"\nTipo de Conta: "+ accountType + "\nTaxa Mensal: " + this.accountType.getValue():"") + "\nDia de Fechamento de Fatura" + this.closing.getDayOfMonth();
    }

    public String getNumber() {
        return number;
    }

    public String setPassword(String previousPassword,String newPassword){
        if(previousPassword == this.password){
            this.password = newPassword;
            return "Senha alterada";
        }

        return "Senha incorreta";
    }

    public String setPassword(String adminPassword){
        if(adminPassword == this.adminPassword){
            this.password = String.valueOf(Math.floor(Math.random()*1000));
            return "Nova senha:" + this.password;
        }

        return "Senha incorreta";
    }

    public void setSecurityCode(String securityCode){
        this.securityCode = securityCode;
    }

    public Benefits getBenefits() {
        return this.benefits;
    }


    public Bill getBill(String month){
        return this.bills.get(month);
    }

    public double getLimit(){

        return this.limit;
    }

    public double getAvailableLimit(){
        double availableLimit = limit;
        for(Bill bill : bills.values()){
            availableLimit -= bill.getBalance();
        }
        return this.limit;
    }

    public void changeLimit(double limit){
        this.limit = limit;
    }


    public void createTransaction( String name, double value, Establishment establishment){
        if(getAvailableLimit() - value > 0){
            String currentMonth = LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
            if (passedClosingOfTheMonth(LocalDate.now())) {
                bills.put(currentMonth, new Bill(LocalDate.now()));
            }
            Transaction newTransaction = new Transaction(name, value, establishment, false, "1");
            bills.get(currentMonth).getTransactions().put(name, newTransaction);
        }
    }

    public void createTransaction( String name, double value, Establishment establishment, String benefit, float benefitTax){
        switch (benefit){
            case "cashback":
                if(benefits.isCashback()){
                    value *= benefitTax;
                }
                break;
            case "points":
                if(benefits.isPoints()){
                    value -= benefitTax;
                }
                // code block
                break;
            case "miles":
                //
                break;
            case "discounts":
                //
                break;
            default:
        }

        this.createTransaction(name,value,establishment);

    }


    public void createTransaction(String name, double value, Establishment establishment, boolean installment, int installments){
        //parcelado
        if(getAvailableLimit() - value > 0){
            double installmentValue = value / installments;
            for (int i = 0; i < installments; i++) {
                LocalDate installmentDate = LocalDate.now().plusMonths(i);
                String currentMonth = installmentDate.getMonthValue() + "/" + installmentDate.getYear();
                if (passedClosingOfTheMonth(installmentDate)) {
                    bills.put(currentMonth, new Bill(LocalDate.now()));
                }
                Transaction newTransaction = new Transaction(name, installmentValue, establishment, installment, String.valueOf(i));
                bills.get(currentMonth).getTransactions().put(name, newTransaction);
            }
        }
    }

    
    
    private boolean passedClosingOfTheMonth(LocalDate date){
        boolean exists =  bills.get(date.getMonthValue() + "/" + date.getYear()) == null;
        boolean hasPassedClosing = date.getDayOfMonth() >= closing.getDayOfMonth();
        return exists && hasPassedClosing;
    }

    public void changeClient(Client newHolder){
        if(this.holder.getEnterprise()){
            this.holder = newHolder;
        }
    }

}
