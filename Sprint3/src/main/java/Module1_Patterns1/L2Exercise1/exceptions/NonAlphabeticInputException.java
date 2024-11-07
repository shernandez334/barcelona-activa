package Module1_Patterns1.L2Exercise1.exceptions;

public class NonAlphabeticInputException extends Exception{
   public NonAlphabeticInputException(String error){
       super(error);
   }
}