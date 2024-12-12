package cat.itacademy.s05.t01.exception;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message){
        super(message);
    }
}
