package Module1_Patterns1.L2Exercise1.inputChecker;

import Module1_Patterns1.L2Exercise1.exceptions.NonAlphabeticInputException;

import java.util.Scanner;

public class InputTestReader {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ALPHANUMERIC_PATTERN = "[a-zA-Z0-9\\s,]+";

    public String readStringInput() throws NonAlphabeticInputException {
        String str = SCANNER.nextLine();
        if (!str.matches(ALPHANUMERIC_PATTERN)) {
            throw new NonAlphabeticInputException("The system couldn't recognize the string.");
        }
        return str;
    }
}
