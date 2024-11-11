public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(double deficit){
        super("Insufficient funds: Trying to withdraw" + deficit + "more than available.");
    }
}