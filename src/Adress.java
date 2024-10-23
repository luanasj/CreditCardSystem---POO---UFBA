public class Adress {

    private String street;
    private String neighbourhood;
    private String number;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    public Adress(String street, String neighbourhood, String number, String zipCode, String city,String state, String country){
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getAdress(){
        String adress = this.street + ", " + number + ". " + this.neighbourhood + ".\n" + this.zipCode + " " + city + ", " + this.state + ".\n" + this.country;

        return adress;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
