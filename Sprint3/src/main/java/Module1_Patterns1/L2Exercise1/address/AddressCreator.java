package Module1_Patterns1.L2Exercise1.address;

import Module1_Patterns1.L2Exercise1.factories.AddressFactory;
import Module1_Patterns1.L2Exercise1.util.IOHelpers;

import java.util.Scanner;

public class AddressCreator implements AddressFactory {
    private static final IOHelpers IO_HELPERS = new IOHelpers();
    private static final Scanner SCANNER = new Scanner(System.in);

    public AddressUsa createAddressUsa(){
        String address = IO_HELPERS.readString("Address: ").trim();
        int zipcode = IO_HELPERS.readIntegers("Zipcode: ");
        String city = IO_HELPERS.readString("City: ");
        String state = IO_HELPERS.readString("State: ");
        return new AddressUsa(address, zipcode, city, state);
    }

    public AddressFrance createAddressFrance(){
        String address = IO_HELPERS.readString("Address: ").trim();
        int zipcode = IO_HELPERS.readIntegers("Zipcode: ");
        String city = IO_HELPERS.readString("City: ");
        return new AddressFrance(address, zipcode, city);
    }
}