public abstract class Account implements Interestable{
    private double amount; 
    public Account(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;      
    }
    public void setAmount(double i){
            amount = i;
    }
    public void deposit(double i) throws NegativeException{
        if(i < 0){
            throw new NegativeException("Deposit amounts cannot be negative.");
        }
            amount = amount + i;
    }
    public void withdraw(double i) throws NegativeException,InsufficientFundsException{
        if(i< 0){
            throw new NegativeException("Withdrawal amounts cannot be negative.");
        }
        if(i> amount){
            throw new InsufficientFundsException(amount - i);
        }
        amount = amount - i;
    }
    public abstract void applyInterest();
}