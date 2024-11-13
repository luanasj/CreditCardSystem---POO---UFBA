public class Benefits {
    private boolean miles;
    private int milesTax;
    private boolean cashback;
    private int cashbackTax;
    private boolean points;
    private int pointsTax;
    private boolean discounts;
    private int discountsTax;

    public Benefits(){
        this.miles = false;
        this.milesTax = 0;
        this.cashback = false;
        this.cashbackTax = 0;
        this.points = false;
        this.pointsTax = 0;
        this.discounts = false;
        this.discountsTax = 0;
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
        String activeBenefits = "beneficios ativos: " + (miles?"milhas: " + this.milesTax + "\n":"") + (cashback ? "cashback: "+ this.cashbackTax+ "\n" : "") + (points?"pontos: "+this.pointsTax+ "\n" : "") + (discounts?"discontos: "+this.discountsTax+"\n" : "");
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

    public boolean isMiles() {
        return miles;
    }

    public boolean isCashback() {
        return cashback;
    }

    public boolean isPoints() {
        return points;
    }

    public boolean isDiscounts() {
        return discounts;
    }



}
