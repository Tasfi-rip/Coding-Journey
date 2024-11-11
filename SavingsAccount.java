public class SavingsAccount extends Account{
    private double interestRate;
    public SavingsAccount(double amount, double interestRate) throws NegativeException{
        super(amount);
        if(interestRate <0){
            throw new NegativeException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    }
    @Override
    public void applyInterest(){
        setAmount(getAmount()+(getAmount()*interestRate));
}
}