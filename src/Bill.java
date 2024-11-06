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

    private Bill(LocalDate date){
        this.month = date.getMonthValue();
        this.year = date.getYear();
        this.payments = new ArrayList<Payment>();
        this.paid = false;
    }

    public Bill(LocalDate date, HashMap<String,Transaction> transactions){
        this(date);
        this.transactions = transactions;
        this.value = getBalance(transactions);
        this.balance = this.value;
        this.minimumPayment = this.value*(0.4);
    }

    public Bill(LocalDate date, HashMap<String,Transaction> transactions,double monthlyFee){
        this(date);
        this.transactions = transactions;
        this.value = getBalance(transactions) + monthlyFee;
        this.balance = this.value;
        this.minimumPayment = this.value*(0.4);
    }

    private double getBalance(HashMap<String,Transaction> transactions){
        Collection<Transaction> values = transactions.values();
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
