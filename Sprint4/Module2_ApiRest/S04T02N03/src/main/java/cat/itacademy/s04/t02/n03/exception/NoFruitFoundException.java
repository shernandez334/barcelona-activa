package cat.itacademy.s04.t02.n03.exception;

public class NoFruitFoundException extends RuntimeException{

    public NoFruitFoundException(String message){
        super(message);
    }
}