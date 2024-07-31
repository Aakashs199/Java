import java.util.Scanner;
class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance)
     {
        setBalance(initialBalance);
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
     {
        if(balance >= 0) 
	{
            this.balance = balance;
        } 
	else
	 {
            System.out.println("-------Invalid initial balance----------");
         }
    }
}


public class Atm 
  {
    private BankAccount account;

    public Atm(double initialBalance)
    {
        account = new BankAccount(initialBalance);
    }

    public void deposit(double amount)
      {
        if(amount>0)
	 {
            account.setBalance(account.getBalance()+amount);
            System.out.println("Deposited: $"+amount);
         }
	 else
	 {
            System.out.println("---------Invalid amount for deposit----------");
         }
    }

    public void withdraw(double amount)
	 {
          if(amount>0 && amount<=account.getBalance())
	   {
             account.setBalance(account.getBalance()-amount);
             System.out.println("Withdrawn: $"+amount);
           }
	 else 
	  {
            System.out.println("Insufficient funds");
         }
    }

 public static void main(String[] args) 
   {
        Atm atm = new Atm(1000);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) 
	{
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

       switch(choice)
	    {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: $" + atm.account.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
