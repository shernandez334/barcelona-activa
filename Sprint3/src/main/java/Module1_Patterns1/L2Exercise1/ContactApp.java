package Module1_Patterns1.L2Exercise1;

import Module1_Patterns1.L2Exercise1.address.AddressCreator;
import Module1_Patterns1.L2Exercise1.address.AddressFrance;
import Module1_Patterns1.L2Exercise1.address.AddressUsa;
import Module1_Patterns1.L2Exercise1.contact.Contact;
import Module1_Patterns1.L2Exercise1.phoneNumber.PhoneNumberCreator;
import Module1_Patterns1.L2Exercise1.phoneNumber.PhoneNumberFrance;
import Module1_Patterns1.L2Exercise1.phoneNumber.PhoneNumberUsa;
import Module1_Patterns1.L2Exercise1.util.IOHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ContactApp {
    private static final IOHelpers ioHelpers = new IOHelpers();
    private static final AddressCreator ADDRESS_CREATOR = new AddressCreator();
    private static final PhoneNumberCreator PHONE_CREATOR = new PhoneNumberCreator();
    private static final IOHelpers IO_HELPERS = new IOHelpers();
    private List<Contact> contacts = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(IOHelpers.class);
    private static final String COUNTRY_OPTIONS =
            "Which country is your contact from: \n" +
                    "1. USA\n" +
                    "2. France\n" +
                    "3. Exit\n";

    public void run(){
        manageContactApp();
    }

    public void manageContactApp(){
        int op;
        do {
            op = ioHelpers.readIntegers("Welcome to WhatsApp:\n" +
                    "1. Create Contact.\n" +
                    "2. View Contacts.\n" +
                    "3. Exit.");

            switch (op){
                case 1 -> createContactMenu();
                case 2 -> displayContacts();
            }
        } while (op != 3);
    }

    public void createContactMenu(){
        int op = ioHelpers.readIntegers(COUNTRY_OPTIONS);
        switch (op) {
            case 1 -> {
                String name = IO_HELPERS.readString("Name: ");
                PhoneNumberUsa phoneNumberUsa = PHONE_CREATOR.createPhoneNumberUsa();
                AddressUsa addressUsa = ADDRESS_CREATOR.createAddressUsa();
                Contact contact = new Contact(name, phoneNumberUsa.getFullPhoneNumber(), addressUsa.getFullAddress());
                contacts.add(contact);
            }
            case 2 -> {
                String name = IO_HELPERS.readString("Name: ");
                PhoneNumberFrance phoneNumberFrance = PHONE_CREATOR.createPhoneNumberFrance();
                AddressFrance addressFrance = ADDRESS_CREATOR.createAddressFrance();
                Contact contact = new Contact(name, phoneNumberFrance.getFullPhoneNumber(), addressFrance.getFullAddress());
                contacts.add(contact);
            }
            case 3 -> System.out.println("Exiting Contact Creation...");
            default -> System.out.print("Wrong option. Try again.");
        }
    }

    public void displayContacts(){
        contacts.forEach(e -> System.out.println(e.toString()));
    }
}