import java.util.*;

class Customer
 {
   int cusId;
   int accountNo;
   String name;
   double balance;
   String encryPassword;
   public Customer(int cusId,int accountNo,String name,double balance,String encryPassword)
    {
        this.cusId=cusId;
	this.accountNo=accountNo;
	this.name=name;
	this.balance=balance;
	this.encryPassword=encryPassword;
    }
   int getCusId()
    {
      return cusId;
    }
  int getAccountNo()
   {
     return accountNo;
   }
  String getName()
   {
     return name;
   }
  double getBalance()
   {
     return balance;
   }
  

 }

public class BankingApplication
{
public static List<Customer> fillCostomerFromFile(String filepath)
  {
    List<Customer> customers=new ArrayList<>();
    try
      {
         FileReader ob=new FileReader(filepath);
         BufferedReader br=new BufferedReader(ob);
         String line;
	 while((line=br.readLine())!=null)
          {
              String details[]=line.split(" ");  
              int cusId=Integer.parseInt(details[0]);
              int accountNo=Integer.parseInt(details[1]);
	      String name=details[2];
	      Double.balance=Double.parseDouble(details[3]);
	      String encryPassword=details[4];
 	      customers.add(new Customer(cusId,accountNo,name,balance,encryPassword));  
          }
      }
   catch(IOException e)
    {
      System.out.println(e);
    }
  return customers;
  }

public static void main(String args[])
 {
   String filepath="Bank_db.txt";
   List<Customer> customer=fillCostomerFromFile(filepath);
   
 }
}