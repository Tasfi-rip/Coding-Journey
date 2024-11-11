import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class BankApp{
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int accountIndex = -1;//no account
    private static boolean accountSelected = false;// to see if an account is selected

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);


        //running program
        while(true){
            if(accounts.isEmpty()){
                System.out.println("No ACCOUNTS MADE. PLEASE CREATE AN ACCOUNT.");
                System.out.println("Please input a command.");
                System.out.println("1. Create a new Chequing Account");
                System.out.println("2. Create a new Saving Account");
                System.out.println("3. Deposit to current account");
                System.out.println("4. Withdraw from current account");
                System.out.println("5. Apply interest to current account");
                System.out.println("6. Switch to a different account");
            }
            else{
                System.out.println("Currently working with: " + accountIndex+ " " + "Balance of $" + accounts.get(accountIndex).getAmount());
                System.out.println("Please input a command.");
                System.out.println("1. Create a new Chequing Account");
                System.out.println("2. Create a new Saving Account");
                System.out.println("3. Deposit to current account");
                System.out.println("4. Withdraw from current account");
                System.out.println("5. Apply interest to current account");
                System.out.println("6. Switch to a different account");
            }
            System.out.println("0. Stop Execution");
            try{
                int command = scanner.nextInt();
                scanner.nextLine();//clear
    
                switch(command){
                    case 1: 
                        createChequingAccount(scanner);
                        break;
                    case 2: 
                        createSavingAccount(scanner);
                        break;
                    case 3: 
                        deposit(scanner);
                        break; 
                    case 4:
                        withdraw(scanner);
                        break;
                    case 5:
                        applyInterest();
                        break;
                    case 6: 
                        switchAccount(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting");
                        return;
                    default: 
                        System.out.println("Invalid Command");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please enter a valid number");
                scanner.nextLine();//clear invalid input
            }
        }
      
    }
    private static void createChequingAccount(Scanner scanner){
        try{
            accounts.add(new CheckingAccount(0));
            accountIndex = accounts.size()-1;
            accountSelected = true;//account selected 
        }
        catch(NegativeException e){
            System.out.println(e.getMessage());
        }
    }
    private static void createSavingAccount(Scanner scanner){
        System.out.println("Enter interest rate for savings account");
        double interest = scanner.nextDouble();
        try{
            accounts.add(new SavingsAccount(0, interest));
            accountIndex = accounts.size() - 1;
            accountSelected = true; 
        }
        catch(NegativeException e){
            System.out.println(e.getMessage());
        }
    }
    private static void deposit(Scanner scanner){
        if(!accountSelected){
            System.out.println("No account selected");
            return; 
        }
        System.out.println("Select Amount to be deposited");
        double amount = scanner.nextDouble();
        try{
            accounts.get(accountIndex).deposit(amount);
            System.out.println("Deposit successful.");
        }
        catch(NegativeException e){
            System.out.println(e.getMessage());
        }

    }
    private static void withdraw(Scanner scanner){
        if(!accountSelected){
            System.out.println("No account selected");
            return; 
        }
        System.out.println("Select Amount to be withdraw");
        double amount = scanner.nextDouble();
        try{
            accounts.get(accountIndex).withdraw(amount);
            System.out.println("Withdraw successful.");
        }
        catch(NegativeException e){
            System.out.println(e.getMessage());
        }
        catch(InsufficientFundsException i){
            System.out.println(i.getMessage());
        }
    }
    private static void applyInterest(){
        if(!accountSelected){
            System.out.println("No account selected");
            return; 
        }
        
            accounts.get(accountIndex).applyInterest();
            System.out.println("Interest Applied");
        
    }
    private static void switchAccount(Scanner scanner){
        if(accounts.isEmpty()){
            System.out.println("No accounts available to switch to");
            return;
        }

        System.out.println("Which account would you like to switch to");
        int id = scanner.nextInt();
        if(id>0 && id <= accounts.size()){
            accountIndex = id -1;
            accountSelected = true;
            System.out.println("Switched to account ID: " + id);
        }
        else{
            System.out.println("Account does not exist.");
        }
    }
}
