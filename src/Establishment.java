public class Establishment {
    private String name;
    private String subsidiary;
    private String registeredNumber;

    public Establishment(String name, String subsidiary, String registeredNumber){
        this.name = name;
        this.subsidiary = subsidiary;
        this.registeredNumber = registeredNumber;
    }

    public String getFacilityInfo(){
        String facilityInfo = "Estabelecimento: " + this.name + "\nFilial: " + this.subsidiary + "\n CNPJ: " + this.registeredNumber;
        return facilityInfo;
    }
}
