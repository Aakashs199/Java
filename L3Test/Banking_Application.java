import java.util.*;
class Account 
{
  String customerName;
  String Account;
  int accountNum;
  int balance;
  int ifscCode;
  public Account(String customerName,int accountNum,int balance,int ifscCode,String Account) 
   {
     this.customerName = customerName;
     this.Account=Account;
     this.accountNum = accountNum;
     this.balance = balance;
     this.ifscCode = ifscCode;
    }
  void deposit(int amount)
  {
    balance += amount;
    display();
  }
  void display() 
   {
    
     System.out.println("Customer name: " + customerName);
     System.out.println("Account Type: "+Account);
     System.out.println("Account number: " + accountNum);
     System.out.println("IFSC Code: ICIC" + ifscCode);
     System.out.println("Balance Amount in Account $: " + balance);
     System.out.println("---------------------------------");
     System.out.println();
    }
  void withdraw(int amount) 
   {
     if (balance>=amount)
       {
          balance -= amount;
       }
      else
        {
             System.out.println();
            System.out.println("****Insufficient Balance****");
        }
        display();
    }
}

class SavingAccount extends Account
 {
    double interestRate = 10/ 100;
    double time =1;
    boolean hasCheckbook=false;
    boolean valid=true;
    public SavingAccount(String customerName,int accountNum,int ifscCode,String SavingAccount)
    {
        super(customerName, accountNum, 0, ifscCode,SavingAccount);
     }

    void compoundInterest() {
    if (valid) {
        double A = balance * Math.pow((1+interestRate),time);
        double interest = A - balance;
        deposit((int) interest);
    } else {
        System.out.println("Not Valid for Interest");
        System.out.println();
    }
}


    void issueCheck(int amount) 
     {
        if(hasCheckbook)
         {
             if (balance>=amount)
               {
                balance -= amount;
                System.out.println("Check issued for $" + amount);
               }
             else 
               {
                System.out.println("Insufficient Balance to issue check.");
               }
          } 
          else
          {
            System.out.println("You don't have a checkbook for this account.");
          }
    }
 }

class CurrentAccount extends Account
  {
    double minimumBalance;
    double serviceCharge;
    boolean hasCheckbook=true;
    boolean valid=false;
    double interestRate = 10/ 100;
    double time =1;

    public CurrentAccount(String customerName,int accountNum,int ifscCode,String CurrentAccount)
     {
        super(customerName,accountNum,0,ifscCode,CurrentAccount);
     }
    void checkMinimumBalance(double minimumBalance,double serviceCharge)
      {
        this.minimumBalance=minimumBalance;
        this.serviceCharge=serviceCharge;
        if (balance < minimumBalance)
          {
            System.out.println("Your Account has an Insufficient Balance");
            balance -= serviceCharge;
            display();
          }
       }

    void issueCheck(int amount)
     {
        if (hasCheckbook)
        {
            if (balance >= amount)
             {
                balance -= amount;
                System.out.println("Check issued for $" + amount);
             }
            else
             {
                System.out.println("Insufficient Balance to issue check.");
             }
         } 
        else 
          {
            System.out.println("You don't have a checkbook for this account.");
          }
    }
    void compoundInterest() {
    if (valid)
     {
        double B = balance * Math.pow((1+interestRate),time);
        double interest = B - balance;
        deposit((int) interest);
    } else {
        System.out.println("Not Valid for Interest");
        System.out.println();
    }
}

}

class Banking_Application
  {
    public static void main(String args[]) 
   {
     Scanner sc = new Scanner(System.in);
     Random rand = new Random();
     int acc1 = Math.abs(rand.nextInt());
     int acc2 = Math.abs(rand.nextInt());
     int ifsc1 = Math.abs(rand.nextInt());
     int ifsc2 = Math.abs(rand.nextInt());
     SavingAccount saving = new SavingAccount("Akash", acc1, ifsc1,"SavingAccount");
     CurrentAccount current = new CurrentAccount("Balaji", acc2, ifsc2,"CurrentAccount");

    while (true) 
       {
          System.out.println("1.Show Account Details\n2.Deposit\n3.Withdraw\n4.Issue Check\n5.Check Balance\n6.Intrest\n0.Exit");
           System.out.println();
           System.out.print("Enter your Choise:");
          int choice=sc.nextInt();
          if(choice == 0) 
           {
             break;
           }
         switch (choice)
          {
           case 1:
               System.out.println("1.Saving Account\n2.Current Account ");
               System.out.println();
               System.out.print("Enter your Choise:");
               int a=sc.nextInt();
               if (a==1)
                 {
                   System.out.println("       Saving Account Details");
                   saving.display();
                 }
               else
                 {
                   System.out.println("       Current Account Details");
                   current.display();
                 }
                break;
            case 2:
               System.out.println("1.Saving Account\n2.Current Account ");
               System.out.println();
               System.out.print("Enter your Choise:");
               int b = sc.nextInt();
               System.out.print("Enter the amount to Deposit in Account $: ");
               int dep = sc.nextInt();
               System.out.println();
               System.out.println("The Amount "+dep+ " is Deposited to your Account  ");
               if(b==1)
                {
                  saving.deposit(dep);
                } 
               else 
                {
                  current.deposit(dep);
                }
               break;
             case 3:
                System.out.println("1.Saving Account\n2.Current Account ");
                System.out.println();
                System.out.print("Enter your Choise:");
                int c=sc.nextInt();
                System.out.print("Enter the amount to Withdraw from Account $: ");
                int with = sc.nextInt();
                if (c==1)
                  {
                    saving.withdraw(with);
                  } 
                else 
                  {
                    current.withdraw(with);
                  }
                  break;
              case 4:
                 System.out.println("1. Saving Account\n2. Current Account ");
                  System.out.println();
                  System.out.print("Enter your Choise:");
                 int d = sc.nextInt();
                 System.out.print("Enter the check amount in your Account $: ");
                 int check = sc.nextInt();
                 if(d==1) 
                  {
                   saving.issueCheck(check);
                  }
                  else
                   {
                    current.issueCheck(check);
                   }
                   break;
              case 5:
                  System.out.println("1. Saving Account\n2. Current Account ");
                   System.out.println();
                   System.out.print("Enter your Choise:");
                  int e=sc.nextInt();
                  if(e==1)
                    {
                     System.out.println("Balance is: "+saving.balance);
                    }
                  else
                    {
                     System.out.println("Balance is: "+current.balance);
                    }
                    break;
               case 6:
                  System.out.println("1.Saving Account\n2.Current Account ");
                   System.out.println();
                   System.out.print("Enter your Choise:");
                  int f=sc.nextInt();
                  if(f==1)
                    {
                     System.out.println("Balance is: "+saving.balance);
                    }
                  else
                    {
                     System.out.println("Balance is: "+current.balance);
                    }
                    break;
              default:
                    System.out.println("Pleace Enter the Valid Choise");
                    System.out.println();
                    break;
            }
        }
    }
}
