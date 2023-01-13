package Exceptions;

public class MissingContainerException extends Exception{
    private String whoIsWalking;
    private String message;

    public MissingContainerException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
