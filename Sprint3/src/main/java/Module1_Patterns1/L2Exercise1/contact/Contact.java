package Module1_Patterns1.L2Exercise1.contact;

public class Contact {
    private String name;
    private String number;
    private String fullAddress;

    public Contact(String name, String number, String address){
        this.name = name;
        this.number = number;
        this.fullAddress = address;
    }

    @Override
    public String toString(){
        return "Name: " + this.name +  "\n" +
               "Number: " + this.number + "\n" +
                "Address: " + this.fullAddress;
    }
}