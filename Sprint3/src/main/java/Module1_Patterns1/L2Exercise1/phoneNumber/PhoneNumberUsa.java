package Module1_Patterns1.L2Exercise1.phoneNumber;

public class PhoneNumberUsa extends PhoneNumber {

    public PhoneNumberUsa(String phoneNumber) {
        super("+34 ", phoneNumber);
    }

    @Override
    public String getFullPhoneNumber() {
        StringBuilder sb = new StringBuilder(super.getPrefix());
        sb.append(super.getPhoneNumber());
        return sb.toString();
    }
}
   