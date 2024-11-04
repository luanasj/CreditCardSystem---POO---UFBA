
import java.time.LocalDate;

public class Payment {
    private LocalDate date;



    private double value;

    public Payment(LocalDate date,double value){
        this.date = date;
        this.value = value;
    }

    public String getPaymentInfo(){
        return "Data do Pagamento: " + date + "\nValor: " + value;
    }
}
