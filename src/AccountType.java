public enum AccountType {
    SIMPLE(0),MASTER (20),UNLIMTED (30),PLATINUM (40),UNIVERSITARY (50),VIP(60),ASSOCIATE(70);

    private final int accountTax;

    AccountType(int accountTax){
        this.accountTax = accountTax;
    }

    public int getValue(){
        return this.accountTax;
    }
}
