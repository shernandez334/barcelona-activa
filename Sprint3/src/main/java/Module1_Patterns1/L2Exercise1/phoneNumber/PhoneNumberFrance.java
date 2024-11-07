package Module1_Patterns1.L2Exercise1.phoneNumber;

public class PhoneNumberFrance extends PhoneNumber {

    public PhoneNumberFrance(String phoneNumber) {
        super("+33 ", phoneNumber);
    }

    @Override
    public String getFullPhoneNumber() {
        StringBuilder sb = new StringBuilder(super.getPrefix());
        sb.append(super.getPhoneNumber());
        return sb.toString();
    }
}
