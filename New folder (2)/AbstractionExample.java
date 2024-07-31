abstract class BankAccount
 {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) 
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
      {
        if(amount > 0) 
	 {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
	 else
	 {
            System.out.println("Invalid deposit amount.");
         }
    }

    public abstract void withdraw(double amount);

    protected void setBalance(double balance)
     {
        this.balance = balance;
     }
}





class SavingsAccount extends BankAccount
 {
    private double interestRate;
    public SavingsAccount(String accountNumber, double initialBalance, double interestRate)
    {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void withdraw(double amount)
      {
        if(amount > 0 && amount <= getBalance()) 
	{
            setBalance(getBalance() - amount);
            System.out.println("Withdrew: " + amount);
        }
	 else
	 {
            System.out.println("Insufficient balance or invalid amount.");
         }
    }

    public void addInterest()
     {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
     }
}

class CurrentAccount extends BankAccount
 {
    private double overdraftLimit;
    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) 
    {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) 
	{
          if(amount > 0 && amount <= getBalance() + overdraftLimit) 
	  {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew: " + amount);
          } 
         else
	 {
            System.out.println("Insufficient balance or overdraft limit exceeded.");
         }
    }
}

public class AbstractionExample
 {
    public static void main(String[] args) 
     {
        BankAccount savings = new SavingsAccount("SA123", 1000, 5);
        BankAccount current = new CurrentAccount("CA123", 500, 1000);
        System.out.println("Savings Account Balance: "+savings.getBalance());
        savings.deposit(200);
        savings.withdraw(150);
        ((SavingsAccount) savings).addInterest();

        System.out.println("Current Account Balance: " + current.getBalance());
        current.deposit(300);
        current.withdraw(1000);
        current.withdraw(2000); 

        System.out.println("Savings Account Balance after transactions: " + savings.getBalance());
        System.out.println("Current Account Balance after transactions: " + current.getBalance());
    }
}
