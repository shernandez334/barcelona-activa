package Module1_Patterns1.L2Exercise1.factories;


import Module1_Patterns1.L2Exercise1.phoneNumber.PhoneNumberFrance;
import Module1_Patterns1.L2Exercise1.phoneNumber.PhoneNumberUsa;

public interface PhoneNumberFactory {
    PhoneNumberFrance createPhoneNumberFrance();
    PhoneNumberUsa createPhoneNumberUsa();
}
