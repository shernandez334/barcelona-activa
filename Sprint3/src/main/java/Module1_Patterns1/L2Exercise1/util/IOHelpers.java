package Module1_Patterns1.L2Exercise1.util;

import Module1_Patterns1.L2Exercise1.exceptions.NonAlphabeticInputException;
import Module1_Patterns1.L2Exercise1.inputChecker.InputTestReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class IOHelpers {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final InputTestReader INPUT_TEST_READER = new InputTestReader();
    private static final Logger LOGGER = LoggerFactory.getLogger(IOHelpers.class);

    public int readIntegers(String message){
        int number= 0;
        boolean isNumber = false;
        while (!isNumber){
            try {
                System.out.println(message);
                number = SCANNER.nextInt();
                isNumber = true;
            } catch (NumberFormatException e){
                LOGGER.error("You must input a number {}", e.getMessage());
                System.out.println("You must input a number " + e.getMessage());
            }
        }
        return number;
    }

    public String readString(String message){
        String str = "";
        boolean isString = false;
        do{
            try {
                System.out.println(message);
                str = INPUT_TEST_READER.readStringInput();
                isString = true;
            } catch (NonAlphabeticInputException e){
                System.out.println("Wrong Input. Introduce a valid number: " + e.getMessage());
                LOGGER.warn("Wrong Input. Introduce a valid number: {}", e.getMessage());
            }
        } while (!isString);
        return str;
    }
}