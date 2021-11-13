package hingst.bank.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String msg) {
        super(msg);
    }
}
