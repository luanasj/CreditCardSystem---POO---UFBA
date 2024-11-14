import java.time.LocalDate;
import java.util.*;

public class Bill {

    private int month;
    private int year;
    private HashMap<String,Transaction> transactions;
    private List<Payment> payments;
    private double value;
    private double balance;
    private double minimumPayment;
    private boolean paid;

    public Bill(LocalDate date){
        this.month = date.getMonthValue();
        this.year = date.getYear();
        this.payments = new ArrayList<Payment>();
        this.paid = false;
        this.transactions = new HashMap<String,Transaction>();
        this.value = getBalance();
        this.balance = this.value;
        this.minimumPayment = this.value*(0.4);
    }



    public Bill(LocalDate date,double monthlyFee){
        this(date);
        this.transactions = new HashMap<String,Transaction>();
        this.value = getBalance() + monthlyFee;
        this.balance = this.value;
        this.minimumPayment = this.value*(0.4);
    }

    public double getBalance(){
        Collection<Transaction> values = this.transactions.values();
        double valuesSum = 0;
        for(Transaction transaction : values){
            valuesSum += transaction.getValue();
        };

        return valuesSum;

    }

    public String getBillInfo(){
        String billInfo = "Fatura: " + this.month + "/" + this.year + "\nValor da Fatura: " + this.value + "\nSaldo: " + this.balance + "\n Pagamento Minimo: " + this.minimumPayment + "\nSituação: " + (paid?"Pago" : "Pendente");

        return billInfo;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }


    public HashMap<String, Transaction> getTransactions() {
        return this.transactions;
    }

    public HashMap<String, Transaction> getTransactions(TransactionType transactionType) {
        HashMap<String, Transaction> transactiosForType = new HashMap<String, Transaction>();
        for(String transactionkey : this.transactions.keySet()){
            if(this.transactions){

            }

        }
    }

    public List<Payment> getPayments() {
        return this.payments;
    }

    private void createPayment(double paymentValue){
        this.payments.add(new Payment(LocalDate.now(), paymentValue));
    }

    public String payBill(double paymentValue){
        if(paymentValue < this.minimumPayment){
            return "Pagamento inválido: abaixo do valor mínimo de " + minimumPayment;
        }

        this.balance -= paymentValue;
        createPayment(paymentValue);
        return "Pagamento Realizado no valor de " + paymentValue + "\n Fatura: " + this.month + "/" + this.year + "Saldo:" + this.balance;
    }

}
