public enum TransactionType {
    BUY("compra"),PAYMMENT("pagamento"),CHARGEBACK("estorno"),INSTALLMENT("parcelamento");

    private String dsc;

    TransactionType(String dsc){
            this.dsc = dsc;
    }

    public String getDsc(){
        return this.dsc;
    }




}
