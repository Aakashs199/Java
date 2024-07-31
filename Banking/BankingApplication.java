
import java.io.*;
import java.util.*;
public class BankingApplication 
{
    static Scanner sc = new Scanner(System.in);
    public static class Customer
    {
        private int cusId;
        private int accountNo;
        private String name;
        private double balance;
        private String encryPassword;

        public Customer(int cusId,int accountNo,String name,double balance,String encryPassword)
	 {
            this.cusId = cusId;
            this.accountNo = accountNo;
            this.name = name;
            this.balance = balance;
            this.encryPassword = encryPassword;
         }

        public int getCusId() 
	{
            return cusId;
        }

        public int getAccountNo() 
	{
            return accountNo;
        }

        public String getName()
	 {
            return name;
         }

        public double getBalance()
	 {
            return balance;
         }

        public String getPassword() 
	 {
            return encryPassword;
         }
    }

static String encryptPassword(String password)
 {
        StringBuilder encryptedPassword = new StringBuilder();
        for (char ch : password.toCharArray())
	 {
            if(Character.isLetter(ch)) 
		{
                  char encryptedChar = (char)(ch + 1);
                  if((ch == 'Z') || (ch == 'z'))
		   {
                     encryptedChar -= 26;
                    }
                encryptedPassword.append(encryptedChar);
            }
	 else if(Character.isDigit(ch))
		 {
                char encryptedChar = (char)(ch == '9' ? '0' : ch + 1);
                encryptedPassword.append(encryptedChar);
            } 
	   else 
	     {
                encryptedPassword.append(ch);
             }
        }
        return encryptedPassword.toString();
    }

 public static List<Customer> fillCustomerFromFile(String filepath)
     {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) 
	{
            String line;
            while((line = br.readLine()) != null) 
	     {
                if(!line.trim().isEmpty())
	 	 {
                    String[] details = line.split(" ");
                    if (details.length == 5)
		     {
                        int cusId = Integer.parseInt(details[0]);
                        int accountNo = Integer.parseInt(details[1]);
                        String name = details[2];
                        double balance = Double.parseDouble(details[3]);
                        String encryPassword = details[4];
                        customers.add(new Customer(cusId,accountNo,name,balance,encryPassword));
                      } 
		    else 
		      {
                        System.out.println("Invalid format in file: "+line);
                      }
                }
            }
        }
	 catch(IOException e)
	 {
            System.out.println("Error reading file: " + e.getMessage());
         }
	 catch(NumberFormatException e) 
	{
            System.out.println("Error parsing data: " + e.getMessage());
        }
        return customers;
    }

 static void createNewAccount(List<Customer> customers, String filepath) 
{
        System.out.print("Enter your Name: ");
        sc.nextLine();  
        String name = sc.nextLine();
        System.out.print("Create a new Password: ");
        String password = sc.nextLine();
        System.out.print("Re-Enter the Password: ");
        String reenteredPassword = sc.nextLine();
        if (!password.equals(reenteredPassword)) 
	{
            System.out.println("You Entered the Re-Password Wrong");
            return;
        }
        
        String encryptedPassword = encryptPassword(password);        
        double balance = 10000;
        Random random = new Random();
        int cusId = random.nextInt(90) + 10;
        int accountNo = random.nextInt(90000) + 10000;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true)))
	 {
            bw.newLine();
            bw.write(cusId + " " + accountNo + " " + name + " " + balance + " " + encryptedPassword);
            customers.add(new Customer(cusId, accountNo, name, balance, encryptedPassword));
            System.out.println("New Customer Added Successfully!");
        } 
	catch(IOException e)
	 {
            System.out.println("Error writing to file: " + e.getMessage());
         }
    }

    public static void main(String[] args) 
	{
        String filepath = "Bank_db.txt";
        List<Customer> customers = fillCustomerFromFile(filepath);
        System.out.println("----After Reading from File----");
        for (Customer value : customers) 
	{
            System.out.println(value.getCusId() + " " + value.getAccountNo() + " " + value.getName() + " " + value.getBalance() + " " + value.getPassword());
        }

        while(true)
	 {
            System.out.println("Enter the Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createNewAccount(customers, filepath); 
                    break;
                case 2:
                  
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

