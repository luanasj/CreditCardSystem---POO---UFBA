import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Transaction {
    private String id;
    private String name;
    private LocalDate date;
    private double value;
    private Establishment establishment;
    private boolean installment;
    private String parcela;



    public Transaction(String name, double value, Establishment establishment, boolean installment, String parcela){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = LocalDate.now();
        this.value = value;
        this.establishment = establishment;
        this.installment = installment;
        this.parcela = parcela;
    }

    public String getTransactionInfo(){
        return "ID: " + this.id + "\n" +this.name + "\n" + this.date + "Valor da Compra: " + this.value +"\n" + this.establishment.getFacilityInfo() +  (installment?"\nParcela:" + this.parcela : "");
    }

    public LocalDate getDate() {
        return date;
    }


    public double getValue() {
        return value;
    }


    public String cancelTransaction(HashMap<String,Transaction> transactionsList){
        transactionsList.remove(this.id);
        return "Transação: " + this.name + " cancelada.";
    }

    public void makeInstallment(Transaction transaction, HashMap<String,Transaction> transactionsList, int num){
        double newValue = transaction.value/num;
        for(int i = 0;i<num;i++){
            String newName = this.name + "parcela" + i+1 + "/" + num;
            Transaction newTransaction = new Transaction(newName,newValue,this.establishment,true,String.valueOf(i));
            transactionsList.put(newTransaction.id,newTransaction);
        }
        cancelTransaction(transactionsList);

    }

}
