public class Benefits {
    public boolean miles;
    public boolean cashback;
    public boolean points;
    public boolean discounts;

    public Benefits(){
        this.miles = false;
        this.cashback = false;
        this.points = false;
        this.discounts = false;
    }

    public Benefits(boolean activateAll){
        this.miles = true;
        this.cashback = true;
        this.points = true;
        this.discounts = true;
    }

    public Benefits(boolean miles, boolean cashback,boolean points, boolean discounts){
        this.miles = miles;
        this.cashback = cashback;
        this.points = points;
        this.discounts = discounts;
    }



    public String getBenefits(){
        String activeBenefits = "beneficios ativos: " + (miles?"milhas; ":"") + (cashback ? "cashback; " : "") + (points?"pontos; " : "") + (discounts?"discontos; " : "");
        return activeBenefits;
    }

    public void setMiles(boolean miles) {
        this.miles = miles;
    }

    public void setCashback(boolean cashback) {
        this.cashback = cashback;
    }

    public void setDiscounts(boolean discounts) {
        this.discounts = discounts;
    }

    public void setPoints(boolean points) {
        this.points = points;
    }
}
