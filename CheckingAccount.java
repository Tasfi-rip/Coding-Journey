public class CheckingAccount extends Account{
    private static final double INTEREST_RATE = 0.00005;
    public CheckingAccount(double amount) throws NegativeException{
        super(amount);
        if(amount <0){
            throw new NegativeException("Amount cannot be negative.");
        }
    }
    @Override
    public void applyInterest(){
        setAmount(getAmount()+(getAmount()*INTEREST_RATE));
    }
}