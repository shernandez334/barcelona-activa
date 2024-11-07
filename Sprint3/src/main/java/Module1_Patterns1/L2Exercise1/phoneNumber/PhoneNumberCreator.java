package Module1_Patterns1.L2Exercise1.phoneNumber;

import Module1_Patterns1.L2Exercise1.factories.PhoneNumberFactory;
import Module1_Patterns1.L2Exercise1.util.IOHelpers;

public class PhoneNumberCreator implements PhoneNumberFactory {
    private static final IOHelpers IO_HELPERS = new IOHelpers();

    @Override
    public PhoneNumberUsa createPhoneNumberUsa(){
        String phoneNumber = IO_HELPERS.readString("Phone Number: ");
        return new PhoneNumberUsa(phoneNumber);
    }

    @Override
    public PhoneNumberFrance createPhoneNumberFrance(){
        String phoneNumber = IO_HELPERS.readString("Phone Number: ");
        return new PhoneNumberFrance(phoneNumber);
    }
}