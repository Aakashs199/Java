import java.util.*;
public class Repeat
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the String");
      String a=sc.nextLine();
      System.out.println("Enter the n value");
      int n=sc.nextInt();
      int len=a.length();
      int i,ans=0;
      while(n>0)
         {
             for(i=0;i<len;i++)
               {
                 if(a.charAt(i%len)=='a'&&n>0)
                   {       
                     ans++;
                   }
                 n--;
               }
          }
        System.out.println("The number of a is: "+ans);
  }
}