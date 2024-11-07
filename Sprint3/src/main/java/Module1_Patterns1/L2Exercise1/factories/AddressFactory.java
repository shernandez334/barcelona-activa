package Module1_Patterns1.L2Exercise1.factories;

import Module1_Patterns1.L2Exercise1.address.AddressFrance;
import Module1_Patterns1.L2Exercise1.address.AddressUsa;

public interface AddressFactory {
    AddressFrance createAddressFrance();
    AddressUsa createAddressUsa();
}