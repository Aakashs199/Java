import java.util.*;
public class Retask6
{
public static boolean check(int n)
{
  if(n<=0)
   {
      return false;
   }
   if (n==1)
   {
     return true;
   }
   if(n%3!=0)
   {
     return false;
   }
   else
   {
     return check(n/3);
   }
}
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the Number: ");
  int n=sc.nextInt();
  if(check(n))
   {
     System.out.println("TRUE");
   }
  else
   {
     System.out.println("FALSE");
   }
}
}